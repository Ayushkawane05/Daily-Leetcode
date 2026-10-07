class Solution {
    public int mySqrt(int n) {
        long x = (long) n;
        long i = 0;
        for ( i = 0; (i * i) < x; i++) {
            if((i+1)*(i+1)>x) break;

        }
        return (int)i;
    }
}