class NestedInteger:
   def isInteger(self) -> bool:
       """
       @return True if this NestedInteger holds a single integer, rather than a nested list.
       """

   def getInteger(self) -> int:
       """
       @return the single integer that this NestedInteger holds, if it holds a single integer
       Return None if this NestedInteger holds a nested list
       """

   def getList(self) -> [NestedInteger]:
       """
       @return the nested list that this NestedInteger holds, if it holds a nested list
       Return None if this NestedInteger holds a single integer
       """

class NestedIterator:
    def __init__(self, nestedList:[NestedInteger]) -> None:
        self.nestedList = nestedList
        self.res = []

    def next(self)->int:
        

