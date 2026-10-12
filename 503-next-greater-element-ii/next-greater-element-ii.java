class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack();
        int[] ans = new int[nums.length];
        for (int i = 2 * n - 1; i >= 0; i--) {
            int j = i % n;
            while (!st.isEmpty() && st.peek() <= nums[j]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[j] = -1;

                st.push(nums[j]);
            } else {
                ans[j] = st.peek();
                st.push(nums[j]);
            }

        }

        return ans;
    }
}