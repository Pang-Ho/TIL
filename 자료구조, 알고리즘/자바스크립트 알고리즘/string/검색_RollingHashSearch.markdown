# Rolling Hash Search

문자열에서 특정 단어 검색시 O(n)

```javascript
function rollingHashSearch(text, pattern) {
    const base = 256;
    const mod = 2_147_483_647;
    const n = text.length;
    const m = pattern.length;
    
    let h = 1;
    let tHash = 0;
    let pHash = 0;
    for (let i = 0; i < m - 1; i++) h = (h * base) % mod;
    for (let i = 0; i < m; i++) {
        tHash = (tHash * base + text.charCodeAt(i)) % mod;
        pHash = (pHash * base + pattern.charCodeAt(i)) % mod;
    }

    for (let i = 0; i <= n-m; i++) {
        if (tHash === pHash) {
            if (text.substr(i, m) === pattern) {
                return i;
            }
        }
        if (i < n - m) {
            tHash = (tHash - h * text.charCodeAt(i)) % mod;
            tHash = (tHash * base + text.charCodeAt(i+m)) % mod;
            if (tHash < 0) tHash += mod;   
        }
    }
    return -1;
}
```

