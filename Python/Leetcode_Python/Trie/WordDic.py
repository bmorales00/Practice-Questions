# Space Complexity: O(n)
class WordDictionary:
    class Node:
        def __init__(self, ch: str) -> None:
            self.ch = ch
            self.letters = {}
            self.isWord = False

    def __init__(self) -> None:
        self.root = self.Node("")

    # Time Complexity: O(w)
    def addWord(self, word: str) -> None:
        if not word:
            return
        current = self.root
        for ch in word:
            if ch not in current.letters:
                current.letters[ch] = self.Node(ch)
            current = current.letters[ch]

        current.isWord = True

    # Time Complexity: O(w)

    def search(self, word: str) -> bool:
        if not word:
            return False

        def dfs(current, index: int) -> bool:
            if index >= len(word):
                return current.isWord
            if word[index] != "." and word[index] not in current.letters:
                return False
            if word[index] != "." and word[index] in current.letters:
                return dfs(current.letters.get(word[index]), index + 1)
            if word[index] == ".":
                for v in current.letters.values():
                    if dfs(v, index + 1):
                        return True
            return False

        return dfs(self.root, 0)


if __name__ == "__main__":
    wd = WordDictionary()
    wd.addWord("bad")
    wd.addWord("dad")
    wd.addWord("pad")
    wd.addWord("mad")

    res = wd.search(".ad")
    print(res)
