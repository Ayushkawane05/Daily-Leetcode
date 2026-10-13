class Solution {
    public int hammingDistance(int x, int y) {
        int result = 0;
        for (int i = 1; i < 32; i++) {
            if ((x & 1) != (y & 1)) {
                result++;
            }
            x = x >>> 1;
            y = y >>> 1;
        }
        return result;
    }
}