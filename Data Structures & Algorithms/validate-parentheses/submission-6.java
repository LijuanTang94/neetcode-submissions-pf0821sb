class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for(char a: s.toCharArray()) {
            if ('(' == a || '[' == a || '{' == a) {
                stack.push(a);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (map.get(stack.peek()) != a) {
                    return false;
                } else {
                    stack.pop();
                }
            } 
        }
        return stack.isEmpty();
    }
}
