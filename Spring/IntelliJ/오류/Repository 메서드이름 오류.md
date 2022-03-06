# UnsatisfiedDependencyException

~~~java
org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'DMakerController' defined in file [/Users/pang/Downloads/dmaker/build/classes/java/main/com/fastcampus/programming/dmaker/controller/DMakerController.class]: Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'DMakerService' defined in file [/Users/pang/Downloads/dmaker/build/classes/java/main/com/fastcampus/programming/dmaker/service/DMakerService.class]: Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'developerRepository' defined in com.fastcampus.programming.dmaker.repository.DeveloperRepository defined in @EnableJpaRepositories declared on JpaRepositoriesRegistrar.EnableJpaRepositoriesConfiguration: Invocation of init method failed; nested exception is org.springframework.data.repository.query.QueryCreationException: Could not create query for public abstract java.util.Optional com.fastcampus.programming.dmaker.repository.DeveloperRepository.findByMemberID(java.lang.String)! Reason: Failed to create query for method public abstract java.util.Optional com.fastcampus.programming.dmaker.repository.DeveloperRepository.findByMemberID(java.lang.String)! No property memberID found for type Developer! Did you mean 'memberId'?; nested exception is java.lang.IllegalArgumentException: Failed to create query for method public abstract java.util.Optional com.fastcampus.programming.dmaker.repository.DeveloperRepository.findByMemberID(java.lang.String)! No property memberID found for type Developer! Did you mean 'memberId'?
~~~



## 원인 분석

오류코드를 보면 현재 controller부터 빈을 생성 못하고있다.

어노테이션을 빼먹었나 계속 확인했으나, 실패했고, Repository에서 코드상 오류는 없지만 디버그 상 오류가 떠있길래 메서드 명을 바꿔보았다.



* Entity

~~~java
package com.fastcampus.programming.dmaker.entity;

import com.fastcampus.programming.dmaker.type.DeveloperLevel;
import com.fastcampus.programming.dmaker.type.DeveloperSkillType;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private Integer experienceYears;
    private String memberId;
}
~~~



* Repository

~~~java
@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {

  //Optional<Developer> findByMemberID(String memberId);
  Optional<Developer> findByMemberId(String memberId);
}
~~~



## 해결

Repository에서 findBy... 를 쓸 때 Repository에서 사용하는 프로퍼티 명을 제대로 써야한다.

스프링에서 제공하는 메서드들로 추측된다.

![image-20220220122322150](/Users/pang/Desktop/TIL/md-images/image-20220220122322150.png)