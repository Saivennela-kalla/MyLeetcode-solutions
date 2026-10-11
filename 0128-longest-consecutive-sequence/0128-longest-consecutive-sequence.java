class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> values = new HashSet<>();
        for (int value : nums) {
            values.add(value);
        }
        int longest = 0;
        for (int value : values) {
            if (!values.contains(value - 1)) {
                int length = 1;
                while (values.contains(value + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}