function find_fact(n) {
    ans = 1
    if (n == 0 || n == 1) {
        return 1
    }
    else {
        return n * find_fact(n - 1)
    }
}

console.log(find_fact(5))

