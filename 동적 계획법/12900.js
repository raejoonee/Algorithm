function solution(n) {
    let dp = [1, 1];
    while (n--) dp[n % 2] = dp[0] % 1000000007 + dp[1] % 1000000007;
    return dp[1] % 1000000007;
}
