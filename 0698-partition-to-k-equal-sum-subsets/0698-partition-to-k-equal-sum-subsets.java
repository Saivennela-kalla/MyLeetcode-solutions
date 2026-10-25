class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        if (total % k != 0) {
            return false;
        }

        int target = total / k;
        Arrays.sort(nums);

        if (nums[nums.length - 1] > target) {
            return false;
        }

        reverse(nums);
        return place(nums, 0, new int[k], target);
    }

    private boolean place(int[] nums, int index, int[] sums, int target) {
        if (index == nums.length) {
            return true;
        }

        int stick = nums[index];

        for (int side = 0; side < sums.length; side++) {
            if (sums[side] + stick > target) {
                continue;
            }

            boolean sameSumSeen = false;
            for (int previous = 0; previous < side; previous++) {
                if (sums[previous] == sums[side]) {
                    sameSumSeen = true;
                    break;
                }
            }
            if (sameSumSeen) {
                continue;
            }

            sums[side] += stick;
            if (place(nums, index + 1, sums, target)) {
                return true;
            }
            sums[side] -= stick;

            if (sums[side] == 0) {
                break;
            }
        }

        return false;
    }

    private void reverse(int[] nums) {
        for (int left = 0, right = nums.length - 1; left < right; left++, right--) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }
}