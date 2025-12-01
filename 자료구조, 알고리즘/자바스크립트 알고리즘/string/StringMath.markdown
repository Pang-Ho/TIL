# String 숫자 더하기

String인 상태에서 숫자를 더하는 상황. 수가 너무 커서 문자열로 더할경우

수가 너무 크고, 소숫점이 있는 경우

```javascript
function addString2(str1, str2) {
    let i = str1.length - 1;
    let j = str2.length - 1;
    let carry = 0;

    let result = [];
    
    while (i >= 0 || j >= 0 || carry) {
        let d1 = i >= 0 ? str1.charCodeAt(i) - '0'.charCodeAt() : 0;
        let d2 = j >= 0 ? str2.charCodeAt(j) - '0'.charCodeAt() : 0;

        let sum = d1 + d2 + carry;
        carry = Math.floor(sum / 10);
        result.push(sum % 10);
        i--; j--;
    }

    return result.reverse().join('')
}
```



물론 자바스크립트는 BigInt 사용할것.

```javascript
const a = 123456789012345678901234567890n; // n 붙이면 BigInt 리터럴
const b = BigInt("987654321098765432109876543210"); // 문자열 → BigInt

//BigInt는 소수점 지원하지 않음 → 결과는 항상 버림(truncate)
const result = a / b;

console.log((a + b).toString());

```

소수점 계산은 매우 큰 자리수가 아니라면 Number로 해결하기.

