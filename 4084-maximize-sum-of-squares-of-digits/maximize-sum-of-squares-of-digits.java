class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder ans = new StringBuilder();
        int d = sum / 9;
        for (int i = 0; i < d; i++) {
            ans.append('9');
        }
        sum = sum % 9;
        num = num - d;
        while (num > 0) {
            if (sum < 10) {
                ans.append(sum);
                sum = 0;
            }
            num--;
        }
        if (sum == 0)
            return ans.toString();
        else
            return "";
    }
}