# 중복되지 않은 문자들 가장 긴것

https://leetcode.com/problems/longest-substring-without-repeating-characters/

'abcabcbb' => 'abc' => 3

중복되는 것을 확인해야 한다면 그것의 인덱스를 보관해두자

```javascript 
/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    let table = Array(26).fill(-1);
    let lt = 0;
    let maxLen = 0;
    for (let rt = 0; rt < s.length; rt++) {
        let found = s[rt].charCodeAt() - 'a'.charCodeAt();
        if (table[found] > -1 && table[found] >= lt) {
            lt = table[found] + 1;
        }
        table[found] = rt;
        maxLen = Math.max(maxLen, rt - lt + 1);
    }
    return maxLen;
};
```

