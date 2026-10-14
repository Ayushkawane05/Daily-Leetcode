class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder ans = new StringBuilder();
        while (num > 0) {
            if (sum < 10) {
                ans.append(sum);
                sum = 0;
            } else {
                ans.append(9);
                sum = sum - 9;
            }
            num--;
        }
        if (sum == 0)
            return ans.toString();
        else
            return "";
    }
}