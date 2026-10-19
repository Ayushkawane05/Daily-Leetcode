class Solution {

    HashMap<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> ans = new ArrayList<>();
        StringBuilder st = new StringBuilder();
        check(digits,st,ans,0);
        return ans;
    }

    public void check(String d, StringBuilder st, List<String> li, int i) {
        if (i >= d.length()) {
            li.add(st.toString());
            return;
        }
        String temp = map.get(d.charAt(i));
        for (int x = 0; x < temp.length(); x++) {
            st.append(temp.charAt(x));
            // System.out.println(temp.charAt(x));
            check(d, st, li, i + 1);
            st.deleteCharAt(st.length() - 1);
        }
        return;
    }
}