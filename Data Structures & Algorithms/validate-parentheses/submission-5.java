class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}',  '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for(char a: s.toCharArray()) {
            if (map.containsKey(a)) {
                if (!stack.isEmpty() && stack.peek() == map.get(a)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(a);
            }
        }
        return stack.isEmpty();
    }
}
