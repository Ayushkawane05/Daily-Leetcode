class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char a : s.toCharArray()) {
            map.put(a, map.getOrDefault(a, 0) + 1);

        }
        List<Character> chars = new ArrayList<>(map.keySet());
        chars.sort((a, b) -> map.get(b) - map.get(a));

        StringBuilder st = new StringBuilder();
        for (char a : chars) {
            int n = map.get(a);
            while (n != 0) {
                st.append(a);
                n--;
            }
        }
        return st.toString();

    }
}