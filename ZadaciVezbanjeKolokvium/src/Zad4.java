import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Zad4 {

    public static int evaluateExpression(String expression){
        Stack<Integer> stack = new Stack<>();
        int i=0;
        int n= expression.length();
        int rezult =0;

        while (i<n) {
            char ch = expression.charAt(i);

            if(Character.isDigit(ch)){
                int num = 0;
                while (i < n && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                stack.push(num);
            }
            else if(ch == '*'){
                i++;
                int num = 0;
                while (i < n && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                stack.push(stack.pop() * num);
            }
            else if(ch=='+')i++;
        }

        while(!stack.isEmpty()){
            rezult+=stack.pop();
        }
        return rezult;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println(evaluateExpression(input.readLine()));
    }

}