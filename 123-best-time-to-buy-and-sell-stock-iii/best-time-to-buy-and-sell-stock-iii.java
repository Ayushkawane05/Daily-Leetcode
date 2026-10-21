class Solution {
    public int maxProfit(int[] prices) {
        int max1 = Integer.MIN_VALUE;
        int p1 = 0;
        int max2 = Integer.MIN_VALUE;
        int p2 = 0;

        for (int num : prices) {
            max1 = Math.max(max1, -num);
            p1 = Math.max(max1 + num, p1);
            max2 = Math.max(max2, p1 - num);
            p2 = Math.max(p2, max2 + num);
        }
        return p2;
    }
}