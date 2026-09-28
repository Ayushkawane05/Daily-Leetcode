class Solution {
    public int maxDepth(String s) {
        int ans = 0;
        int count = 0;

        for (char a : s.toCharArray()) {
            if (a == '(')
                count++;
            else if (a == ')')
                count--;
            ans = Math.max(ans, count);
        }
        return ans;
    }
}