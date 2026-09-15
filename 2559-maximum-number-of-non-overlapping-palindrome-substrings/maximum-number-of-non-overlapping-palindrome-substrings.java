class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        if (k == 1)
            return n;
        int res = 0;
        for (int i = 0; i <= n - k; i++) {
            if (check(s, i, i + k - 1)) {
                res++;
                i = i + k - 1;
            } else if (i < n - k && check(s, i, i + k)) {
                res++;
                i += k;
            }
        }
        return res;
    }

    public boolean check(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
}