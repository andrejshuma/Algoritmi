package Courses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class EvaluateExpression {

    public static int evaluateExpression(String expression){
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        int i = 0;
        while (i < expression.length()) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                int num = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                operands.push(num);
            } else if (ch == '*') {
                i++;
                int num = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                int top = operands.pop();
                operands.push(top * num);
            } else if (ch == '+') {
                operators.push(ch);
                i++;
            }


        }

        while (!operators.isEmpty()) {
            char op = operators.pop();
            if (op == '+') {
                int b = operands.pop();
                int a = operands.pop();
                operands.push(a + b);
            }
        }

        return operands.pop();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println(evaluateExpression(input.readLine()));
    }

}