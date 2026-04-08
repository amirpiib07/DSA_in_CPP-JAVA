class Solution {
    public int calculate(int a , int b, String t){
        if(t.equals("+")) return a+b;
        else if(t.equals("-")) return a-b;
        else if(t.equals("*")) return a*b;
         else return a/b;
        
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> st= new Stack<>();
        int m=0;
        for(int i=0;i<tokens.length;i++){
            if(!("+-*/".contains(tokens[i]))) {m=Integer.parseInt(tokens[i]);
                                             st.push(m);}
            else{
                int a= st.pop();
                int b=st.pop();
                st.push(calculate(b,a,tokens[i]));
            }
            
        }
        return st.peek();
    }
}