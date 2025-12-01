# Anagram

https://leetcode.com/problems/group-anagrams/

알파벳 맵을 만들고 키를 만들어야하는 경우 효율적으로 만들 수 있다.

```javascript
/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    const map = {};
    for (let str of strs) {
        let table = {};
        for (let i = 'a'.charCodeAt(); i < 'z'.charCodeAt(); i++) {
            table[String.fromCharCode(i)] = 0;
        }
        for (let i = 0; i < str.length; i++) {
            table[str[i]]++;
        }

        let mapKey = "";
        for (let key in table) {
            if (table[key] > 0) mapKey += key + table[key]
        }

        if (map[mapKey]) {
            map[mapKey].push(str);
        } else {
            map[mapKey] = [str]
        }
    }

    let result = [];
    for (let key in map) {
        result.push(map[key])
    }
    return result;
};
```



```javascript
/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    const map = {};
    for (let str of strs) {
        let table = new Array(26).fill(0);
        
        for (let i = 0; i < str.length; i++) {
            table[str[i].charCodeAt() - 'a'.charCodeAt()]++;
        }

        let mapKey = table.join('#'); // 맵의 키를 배열의 결과값으로 사용하긴
        
        if (!map[mapKey]) {
            map[mapKey] = [];
        }
        map[mapKey].push(str);
    }

    return Object.values(map);
};
```

