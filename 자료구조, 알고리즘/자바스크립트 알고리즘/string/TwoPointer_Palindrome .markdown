# Palindrome

* 팰린드롬인지 확인하는 방법
  * 모두 소문자로 변경하고 non-alphanumeric 문자를 지웠을 때 앞 뒤로 같으면 팰린드롬

```javascript
function palindrome(s) {
    s = s.toLowerCase().replace(/[^a-z0-9]/g, '');

    let lt = 0;
    let rt = s.length - 1;
    while (lt < rt) {
        if (s[lt] !== s[rt]) {
            return false;
        }
        lt++; rt--;
    }
    return true;
}
```



* 한 문자만 없어진다면 팰린드롬이 되는지 판단하는 방법

```javascript
function palindrome2(s) {
    
    function palindrome(lt, rt) {
        while (lt < rt) {
            if (s[lt] !== s[rt]) {
                return false;
            }
            lt++; rt--;
        }
        return true;
    }

    let lt = 0;
    let rt = s.length - 1;
    let cnt = 0;
    while (lt < rt) {
        if (s[lt] !== s[rt]) {
            return palindrome(lt + 1, rt) || palindrome(lt, rt - 1);
        }
        lt++; rt--;
    }
    return true;  
};
```

