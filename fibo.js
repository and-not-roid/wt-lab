function fibo(n) {
    a = [0, 1]

    for (let i = 2; i < n; i++) {
        a.push(a[i - 1] + a[i - 2])
    }
    return a
}

console.log(fibo(21))
