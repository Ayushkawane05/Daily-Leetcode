class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int[] best = new int[arr.length];
        Arrays.fill(best, Integer.MAX_VALUE);

        int l = 0;
        int sum = 0;

        int minLength = Integer.MAX_VALUE;
        int answer = Integer.MAX_VALUE;

        for (int r = 0; r < arr.length; r++) {

            sum += arr[r];

            while (sum > target) {
                sum -= arr[l++];
            }

            if (sum == target) {

                int len = r - l + 1;

                if (l > 0 && best[l - 1] != Integer.MAX_VALUE) {
                    answer = Math.min(
                        answer,
                        len + best[l - 1]
                    );
                }

                minLength = Math.min(minLength, len);
            }

            best[r] = minLength;
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}