# TIme Complexity: O(n) || Space Complexity: O(n)
def maxVowels(s:str, k:int)->int:
    if not s:
        return -1

    i =0
    j = k-1
    total = 0
    res = 0
    vowels = set(["a", "e", "i", "o", "u"])

    for x in range(k):
        ch = s[x]
        if ch in vowels:
            total+=1
    res = max(res, total)

    while j < len(s)-1:
        if res == k:
            return k
        
        if s[i] in vowels:
            total-=1
        i+=1
        j+=1
        if s[j]in vowels:
            total+=1
        res = max(res, total)

    return res
        






