class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, 0, 0, target);
    }

    public int solve(int[] nums, int index, int sum, int target) {

        // Base case
        if (index == nums.length) {
            return sum == target ? 1 : 0;
        }

        // Add +
        int plus = solve(nums, index + 1, sum + nums[index], target);

        // Add -
        int minus = solve(nums, index + 1, sum - nums[index], target);

        return plus + minus;
    }
}
