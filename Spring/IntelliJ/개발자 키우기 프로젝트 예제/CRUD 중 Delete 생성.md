# CRUD 중 Delete 생성

1. controller에서 매핑 메서드 생성

~~~java
@DeleteMapping("/developer/{memberId}")
public DeveloperDetailDto deleteDeveloper(
  @PathVariable String memberId
) {
  return dMakerService.deleteDeveloper(memberId);
}
~~~

@PathVariable 어노테이션을 통해 member Id를 가져오고, 서비스에 deleteDeveloper(memberId)를 통해 Delete 구현



2. StatusCode Enum 클래스 생성

~~~java
@Getter
@AllArgsConstructor
public enum StatusCode {
    EMPLOYED("고용"),
    RETIRED("퇴직");

    private final String description;
}
~~~



3. Developer Entity 클래스에 StatusCode를 추가하고, RetiredDeveloper Entity 클래스를 생성

~~~java
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class RetiredDeveloper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private String memberId;
    private String name;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
~~~



4. RetiredDeveloperRepository 생성

~~~java
@Repository
public interface RetiredDeveloperRepository extends JpaRepository<RetiredDeveloper, Long> {

}
~~~



5. Service에서 deleteDeveloper 메서드 생성
   * 트랜잭션 특성 중 Atomic 특성을 설정하기 위해서는 @Transactional 어노테이션이 필수
   * Atomic 특성을 위해 실제로 DB에서 지우는 것이 아닌 RetiredDeveloper에 데이터를 분리 보관한다.

~~~java
@Transactional
public DeveloperDetailDto deleteDeveloper(String memberId) {

  //1. EMPLOYED 상태의 멤버를 RETIRED로 바꿔주는 과정
  Developer developer = developerRepository.findByMemberId(memberId)
    .orElseThrow(() -> new DMakerException(NO_DEVELOPER));
  developer.setStatusCode(StatusCode.RETIRED);
  
  //2. save into RetiredDeveloper
  RetiredDeveloper retiredDeveloper = RetiredDeveloper.builder()
    .memberId(memberId)
    .name(developer.getName())
    .build();
  retiredDeveloperRepository.save(retiredDeveloper);
  return DeveloperDetailDto.fromEntity(developer);
}
~~~



## delete 메서드 만들 때 @Transactional이 없다면?

~~~java
public DeveloperDetailDto deleteDeveloper(String memberId) {

  //1. EMPLOYED 상태의 멤버를 RETIRED로 바꿔주는 과정
  Developer developer = developerRepository.findByMemberId(memberId)
    .orElseThrow(() -> new DMakerException(NO_DEVELOPER));
  developer.setStatusCode(StatusCode.RETIRED);
  
  //@Transactional이 없어졌기에 Repository에 직접 save해줘야 DB에 들어간다.
  developerRepository.save(developer);
  if (developer != null) throw new DMakerException(NO_DEVLEOPER);
  
  //2. save into RetiredDeveloper
  RetiredDeveloper retiredDeveloper = RetiredDeveloper.builder()
    .memberId(memberId)
    .name(developer.getName())
    .build();
  retiredDeveloperRepository.save(retiredDeveloper);
  return DeveloperDetailDto.fromEntity(developer);
}
~~~

* 위 처럼 Repository.save() 를 이용해야함.
* 또한 Transaction의 Atomic 특성이 없기 때문에 중간에 오류가 생긴다면, RETIRED 상태로 바뀌었지만, RetiredDeveloperRepository에는 저장이 안된다.
* 그렇기 때문에 Transactional 어노테이션을 붙여서 여러 과정을 일련의 과정으로 만들어 주도록 한다.