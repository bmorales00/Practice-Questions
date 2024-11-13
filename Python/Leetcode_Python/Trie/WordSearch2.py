# Time Complexity: O(w(mxn)) || Space Complexity:  O(w(mxn))
from typing import List


class Trie:
    class Node:
        def __init__(self, char="") -> None:
            self.char = char
            self.letters = {}
            self.isWord = False
            self.word = ""

    def __init__(self) -> None:
        self.root = self.Node()

    def addWord(self, word: str) -> None:
        if not word:
            return

        current = self.root
        for ch in word:
            if ch not in current.letters:
                current.letters[ch] = self.Node(ch)
            current = current.letters[ch]
        current.isWord = True
        current.word = word


def findWords(board: List[List[str]], words: List[str]) -> List[str]:
    if not board or not words:
        return []

    trie = Trie()
    for word in words:
        trie.addWord(word)
    m = len(board)
    n = len(board[0])
    res = []

    def dfs(current: Trie.Node, r: int, c: int, visited: set) -> None:
        if current.isWord and current.word:
            res.append(current.word)
            current.word = None
        if r < 0 or c < 0 or c >= n or r >= m or (r, c) in visited:
            return
        if board[r][c] not in current.letters:
            return

        visited.add((r, c))
        ch = board[r][c]
        current = current.letters[ch]

        dfs(current, r - 1, c, visited)
        dfs(current, r + 1, c, visited)
        dfs(current, r, c - 1, visited)
        dfs(current, r, c + 1, visited)

        visited.discard((r,c))

    current = trie.root
    for i in range(m):
        for j in range(n):
            if board[i][j] in current.letters:
                dfs(current, i, j, set())
    return res


if __name__ == "__main__":
    res = findWords(
        [
            ["o", "a", "a", "n"],
            ["e", "t", "a", "e"],
            ["i", "h", "k", "r"],
            ["i", "f", "l", "v"],
        ],
        ["oath", "pea", "eat", "rain"],
    )
    print(res)
