class Solution {
    int findTarget(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Check mid - 1
            if (mid - 1 >= low && arr[mid - 1] == target) {
                return mid - 1;
            }

            // Check mid
            if (arr[mid] == target) {
                return mid;
            }

            // Check mid + 1
            if (mid + 1 <= high && arr[mid + 1] == target) {
                return mid + 1;
            }

            // Target is on the right side
            if (arr[mid] < target) {
                low = mid + 2;
            }

            // Target is on the left side
            else {
                high = mid - 2;
            }
        }

        return -1;
    }
}
