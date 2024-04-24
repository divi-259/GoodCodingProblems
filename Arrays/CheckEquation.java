import java.util.*;

/* Problem Statement: Validate if the equation is syntactically correct.

Valid operators: +, -, a-z, (, )
Test cases:
Valid - a + x = b + (c + a)
Invalid - a + x = (ending with =; doesn't have RHS)
Invalid - a + -x = a + b (- in -x is a unary operator)

Original Question Link: https://leetcode.com/discuss/interview-question/5031821/Google-or-Phone-or-Senior-Software-Engineer
Solution approach taken from the user: kumarujjwal1998
*/
public class CheckEquation {

    public static void main(String args[]) {
        
        String[] testCases = {
            "a+b+c",
            "a + (-b)",
            "a+((b))",
            "-a - (b)",
            "a + b + ",
            "123 + ABC",
            "123",
            "abc=",
            "hello world",
            ") a + )((b)",
            "a b",
            "a(b)"
        };

        for(String str : testCases) {
            print(str, check(str));
        }
    }

    private static void print(String str, boolean isValid) {
        if(isValid==true)
            System.out.println("The Given String " + str + " is Valid");
        else System.out.println("The Given String " + str + " is Invalid");
    }

    private static boolean check(String str) {
        String arr[] = str.split("=");
        // if there are more than 1 equal signs or the equal sign is at the start or end of expression,
        // return false
        if(arr.length!=2)
            return false;
        else return (checkExpression(arr[0]) && checkExpression(arr[1]));
    }

    private static boolean checkExpression(String expr) {

        // removing all the white spacces from the expression
        expr = expr.replaceAll("\\s","");

        // if expression ends with operator it is invalid
        if(expr.endsWith("+") || expr.endsWith("-"))
            return false;

       // to keep track of open paranthesis
       Stack<Character> stack = new Stack<>();

       // Flag to indicate if the previous token was a variable or a closing parenthesis
        boolean previousWasVariableOrClosingParen = false;
        
        for (char ch : expr.toCharArray()) {
            if(Character.isLetter(ch)) {
                if(previousWasVariableOrClosingParen) // if previous was also variable
                    return false;
                previousWasVariableOrClosingParen = true; // now the previous is a variable
            }
            else if(ch=='(') {
                if(previousWasVariableOrClosingParen)
                    return false;
                stack.push(ch);
                previousWasVariableOrClosingParen = false;
            }
            else if(ch==')') {
                if(stack.isEmpty() || stack.peek()!='(')
                    return false;
                stack.pop();
                previousWasVariableOrClosingParen = true;
            }
            else if(ch=='+' || ch=='-') {
                if(!previousWasVariableOrClosingParen)
                    return false;
                previousWasVariableOrClosingParen = false;
            }
            else // invalid token
                return false;
        }
        return stack.isEmpty();
    }

}