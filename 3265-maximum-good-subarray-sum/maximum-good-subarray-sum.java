class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        Map<Integer, Long> map = new HashMap<>();

        long prefixSum = 0;
        long ans = Long.MIN_VALUE;

        for (int num : nums) {

            if (map.containsKey(num - k)) {
                ans = Math.max(ans, prefixSum + num - map.get(num - k));
            }

            if (map.containsKey(num + k)) {
                ans = Math.max(ans, prefixSum + num - map.get(num + k));
            }

            map.put(num, Math.min(
                map.getOrDefault(num, Long.MAX_VALUE),
                prefixSum
            ));

            prefixSum += num;
        }

        return ans == Long.MIN_VALUE ? 0 : ans;
    }
}