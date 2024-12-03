from typing import List


def arrayStringsAreEqual(word1:List[str], word2:List[str])->bool:
    if not word1 or not word2:
        return False

    return "".join(word1) == "".join(word2)
