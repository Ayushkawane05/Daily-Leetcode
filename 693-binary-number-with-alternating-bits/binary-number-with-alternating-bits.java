class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev = n & 1;
        while (n != 0) {
            n = n >> 1;
            if (prev == (n & 1))
                return false;
            prev = n & 1;
        }
        return true;
    }
}