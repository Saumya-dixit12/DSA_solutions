class Solution {
    public double findMaxAverage(int[] nums, int k) {

        // First window ka sum
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int maxSum = windowSum;

        // Window ko slide karo
        for (int i = k; i < nums.length; i++) {

            // New element add
            windowSum += nums[i];

            // Old element remove
            windowSum -= nums[i - k];

            maxSum = Math.max(maxSum, windowSum);
        }

        return (double) maxSum / k;
    }
}
