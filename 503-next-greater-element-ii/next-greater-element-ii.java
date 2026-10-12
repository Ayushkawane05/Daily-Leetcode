class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int last = nums.length - 1;
        List<Integer> li = new ArrayList<>();
        Stack<Integer> st = new Stack();
        int[] ans = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() <= nums[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[i] = -1;

                li.add(i);
                st.push(nums[i]);
            } else {
                ans[i] = st.peek();
                st.push(nums[i]);
            }
            System.out.println(last);

        }
        for (int i : li) {
            if (ans[i] == -1) {
                while (!st.isEmpty() && st.peek() <= nums[i]) {
                    st.pop();
                }

                if (st.isEmpty()) {
                    ans[i] = -1;
                } else {
                    ans[i] = st.peek();
                }
            }
        }
        return ans;
    }
}