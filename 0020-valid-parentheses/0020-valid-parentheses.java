import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
    //     Stack<Character> stack= new Stack<Character> ;
    //     int length=s.length;
    //     for(int i=0;i<length;i++){
    //         char ch=s.charat(i);
    //         if(ch=='(' || ch=='{' || ch=='['){
    //             stack.push(ch);
    //         }
    //         else{
    //             if(stack.isEmpty()) return false;

    //             char top= stack.peek();
    //             if(ch==')' && top!='(' || ch=='}' && top!='{' || ch==']' && ch!='[') return false;
    //             stack pop;
    //         }

    //     }

    //     return stack.isEmpty();
    // }

        Stack<Character> stack= new Stack<Character>();
        int l=s.length();
        for(int i=0;i<l;i++){
            char ch= s.charAt(i); //**imp.**
            if(ch=='(' || ch=='{' || ch=='['){
            stack.push(ch);
            }
            else{ 
                if (stack.isEmpty()) return false;
                if(ch==')' && stack.peek()!='(' || ch=='}' && stack.peek()!='{' || ch==']' && stack.peek()!='[')
                { return false;
                }
                stack.pop();
            }
        }

    return stack.isEmpty();
    }
}