# CRUD 중 Read 생성

1. controller에서 매핑 메서드 생성

~~~java
@GetMapping("/members")
public List<MemberDto> getAllMember() {
return Service.getAllMembers();
}
~~~

 여기서 List 안에 Member라는 Entity를 안넣을거예요. 왜냐면 Entity는 멤버가 가지고 있는 모든 정보를 담고있기 때문에 불필요한 정보가 담기기도하고, 응답을 내리는 것에서 분리해주는 것이 유연성에 훨씬 좋기 때문이예요.



2. Dto 생성

~~~java
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {
private String id;
private String name;
private SkillType memberSkillType;

public static MemberDto fromEntity(Member member) {
return MemberDto.builder()
      .id(member.getId())
      .name(member.getName())
      .memberSkillType(member.getMemberSkillType())
      .build();
}
}
~~~

위에는 엔티티 중에서 제가 가져올 내용만 가지고있는 dto를 빌드한 거예요.

그러면 이제 이 dto에 데이터를 넣을 서비스 메서드를 만들어볼거예요.



3. Service 클래스 메서드 생성

~~~java
public List<MemberDto> getAllMembers() {
return memberRepository.findAll()
     .stream().map(DeveloperDto::fromEntity)
     .collect(Collectors.toList());
}
~~~



Repository에서 findAll() 메서드를 통해 Entity를 가져와요. 그리고 map() 메서드를 통해서 DeveloperDto에 static으로 빌드한 fromEntity에는 dto builder한 내용이 리턴돼요.

뭔소리냐면 가져온 Entity를 Dto로 변환한단거예요.

그 후 collect() 메서드로 List 형태로 바꿨구요