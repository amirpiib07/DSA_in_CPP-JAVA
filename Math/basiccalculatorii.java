class Solution {
    public int calculate(String s) {
        int n = s.length();
        
        int result = 0;
        int lastNumber = 0;
        int currentNumber = 0;
        char operation = '+';
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            
            // Build number
            if (Character.isDigit(ch)) {
                currentNumber = currentNumber * 10 + (ch - '0');
            }
            
            // If operator OR last character
            if ((!Character.isDigit(ch) && ch != ' ') || i == n - 1) {
                
                if (operation == '+') {
                    result += lastNumber;
                    lastNumber = currentNumber;
                } 
                else if (operation == '-') {
                    result += lastNumber;
                    lastNumber = -currentNumber;
                } 
                else if (operation == '*') {
                    lastNumber = lastNumber * currentNumber;
                } 
                else if (operation == '/') {
                    lastNumber = lastNumber / currentNumber;
                }
                
                operation = ch;
                currentNumber = 0;
            }
        }
        
        result += lastNumber;
        return result;
    }
}