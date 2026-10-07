class Solution {
    public List<String> removeInvalidParentheses(String s) {

        Set<String> set = new HashSet<>();

        StringBuilder str = new StringBuilder();

        int len = check(str, s, 0, set);

        List<String> ans = new ArrayList<>();

        for (String ss : set) {
            if (ss.length() == len) {
                ans.add(ss);
            }
        }

        return ans;
    }

    public int check(StringBuilder str, String s, int i, Set<String> set) {

        if (i >= s.length()) {

            if (valid(str.toString())) {
                set.add(str.toString());
                return str.length();
            }

            return 0;
        }

        char ch = s.charAt(i);

        if (ch != '(' && ch != ')') {

            str.append(ch);

            int ans = check(str, s, i + 1, set);

            str.deleteCharAt(str.length() - 1);

            return ans;
        }

        str.append(ch);

        int take = check(str, s, i + 1, set);

        str.deleteCharAt(str.length() - 1);

        int not = check(str, s, i + 1, set);

        return Math.max(take, not);
    }

    public boolean valid(String s) {

        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                balance++;
            } else if (ch == ')') {
                balance--;

                if (balance < 0)
                    return false;
            }
        }

        return balance == 0;
    }
}