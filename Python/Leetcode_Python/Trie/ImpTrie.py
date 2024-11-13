class Trie:

    class Node:
        def __init__(self, char) -> None:
            self.char = char
            self.letterBank = dict()
            self.isWord = False

    def __init__(self) -> None:
        self.root = self.Node(" ")

    def insert(self, word: str) -> None:

        current = self.root

        for ch in word:
            if ch not in current.letterBank:
                current.letterBank[ch] = self.Node(ch)
            current = current.letterBank[ch]

        current.isWord = True

    def search(self, word: str) -> bool:
        current = self.root
        for ch in word:
            if ch not in current.letterBank:
                return False
            current = current.letterBank[ch]
        return current.isWord

    def startsWith(self, prefix: str) -> bool:
        current = self.root
        for ch in prefix:
            if ch not in current.letterBank:
                return False
            current = current.letterBank[ch]
        return True


c = Trie()

print(c.insert("apple"))
print(c.insert("watermelon"))

print(c.search("water"))
print(c.startWith("wat"))
print(c.search("watermelon"))
