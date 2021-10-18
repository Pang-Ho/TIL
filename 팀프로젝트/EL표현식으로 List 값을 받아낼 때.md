# EL표현식으로 List 값을 받아낼 때



```java
List<RecipeVO> list = service.getRecipeDetail(no);
ModelAndView mv = new ModelAndView();
mv.addObject("list", list);
```

* 리스트를 jsp에 넘겼고

```jsp
${list.user_no}
```

* jsp에서 값을 받아내려는 순간 오류가 생겼다.

For input string: "recipe_title"

java.lang.NumberFormatException: For input string: "recipe_title"

* String을 int로 받아내려 한 적도 없기에 곰곰히 생각해보고 떠올랐던 것은 EL표현식 문제였다.

```java
map<String, String> map = new HashMap<String, String>();
map.put("id", id) => map.get("id") => ${id}

list.add(vo) => list.get(0).getId => ${list[0].id}
```



