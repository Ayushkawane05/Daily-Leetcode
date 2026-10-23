class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int[] arr = new int[houses.length];
        Arrays.fill(arr, Integer.MAX_VALUE);

        for (int i = 0; i < houses.length; i++) {
            for (int j = 0; j < heaters.length; j++) {

                arr[i] = Math.min(arr[i], Math.abs(heaters[j] - houses[i]));
            }
        }
        int max = 0;
        for (int num : arr) {
            max = Math.max(num, max);
        }
        return max;
    }
}