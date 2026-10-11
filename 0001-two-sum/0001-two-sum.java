class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> Index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (Index.containsKey(complement)) {
                return new int[] {Index.get(complement), i };
            }
            Index.put(nums[i], i);
        }
        return new int[0];
    }
}