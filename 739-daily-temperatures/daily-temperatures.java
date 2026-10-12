class Solution {
    public int[] dailyTemperatures(int[] nums) {
        Stack<Integer> st = new Stack();

        int n = nums.length;
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = 0;
                st.push(i);
            } else {
                ans[i] = st.peek() - i;
                st.push(i);
            }
        }
        return ans;
    }
}