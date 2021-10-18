# checkbox를 선택하면 값은 1 하지 않으면 값은 0 그리고 DB 칼럼 이름 가져오기

* 사용자가 레시피 재료를 가지고 있다면 1 없다면 0을 DB에 저장하고 싶었다.
* 그래서 checkbox를 체크하면 1 아니면 0을 생각하였다.

```jsp
<c:forEach items="${column_namelist }" var="ingred_name">
    <input type="checkbox" name="${ingred_name }" value="1">${ingred_name }
    <input type="hidden" name="${ingred_name }" value="0">
</c:forEach>
```

* ingred_name에는 음식 재료를 나타내는 DB 칼럼이 각각 있다.
* fork, beef, chicken ... 등
* 이 컬럼 이름을 DB에서 가져와야 하기 때문에 밑 형식 처럼 컬럼 이름을 빼고 만약 user_no나 recipe_no가 컬럼 이름에 들어있다면 list로 받아서 list.remove("recipe_no")를 통해 없애고 받아왔다.

```xml
<select id="getColumn_nameList" resultType="String">
SELECT column_name
FROM INFORMATION_SCHEMA.COLUMNS
WHERE TABLE_SCHEMA='finaldb'  
   AND TABLE_NAME='ingredient';
</select>
```

