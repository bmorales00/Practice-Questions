# Time Complexity: O(log n) || Space Complexity: O(1)
def findMin(nums: List[int]) -> int:
    size = len(nums) - 1
    smallest = nums[size // 2]
    start = 0
    end = size

    while start <= end:
        mid = (start + end) // 2

        val = nums[mid]
        smallest = min(smallest, val)

        if val >= nums[start] and val >= nums[end] and nums[start] >= nums[end]:
            start = mid + 1
        elif val >= nums[start] and val >= nums[end] and nums[end] >= nums[start]:
            end = mid - 1
        elif val <= nums[end]:
            end = mid - 1
        elif val >= nums[start]:
            start = mid + 1

    return smallest
