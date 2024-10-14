def isMatch(s: str, p: str) -> bool:
    # dp[i][j] means whether s[:i] matches p[:j]
    dp = [[False] * (len(p) + 1) for _ in range(len(s) + 1)]
    dp[0][0] = True  # Empty string matches empty pattern
    
    # Initialize dp for patterns like a* or a*b* that can match an empty string
    for j in range(1, len(p) + 1):
        if p[j - 1] == '*':
            dp[0][j] = dp[0][j - 2]  # '*' can match zero of the preceding element
    
    for i in range(1, len(s) + 1):
        for j in range(1, len(p) + 1):
            if p[j - 1] == '.' or p[j - 1] == s[i - 1]:
                dp[i][j] = dp[i - 1][j - 1]  # Match single character or '.'
            elif p[j - 1] == '*':
                dp[i][j] = dp[i][j - 2]  # Match zero occurrence
                if p[j - 2] == '.' or p[j - 2] == s[i - 1]:
                    dp[i][j] |= dp[i - 1][j]  # Match one or more occurrences
    
    return dp[len(s)][len(p)]
