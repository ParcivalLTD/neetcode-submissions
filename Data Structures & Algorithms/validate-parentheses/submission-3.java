class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.length() % 2 == 1) return false;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case ')':
                if(stack.empty()) return false;
                if(stack.pop() != '(') return false;
                break;
                case ']':
                if(stack.empty()) return false;
                if(stack.pop() != '[') return false;
                break;
                case '}':
                if(stack.empty()) return false;
                if(stack.pop() != '{') return false;
                break;
                default:
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
