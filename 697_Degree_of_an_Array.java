class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        HashMap<Integer, Integer> first = new HashMap<>();

        int degree = 0;
        int answer = nums.length;

        for (int i = 0; i < nums.length; i++) {

            if (!first.containsKey(nums[i])) {
                first.put(nums[i], i);
            }

            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);

            degree = Math.max(degree, count.get(nums[i]));
        }

        for (int num : count.keySet()) {
            if (count.get(num) == degree) {
                int last = 0;

                for (int i = nums.length - 1; i >= 0; i--) {
                    if (nums[i] == num) {
                        last = i;
                        break;
                    }
                }

                answer = Math.min(answer, last - first.get(num) + 1);
            }
        }

        return answer;
    }
}
