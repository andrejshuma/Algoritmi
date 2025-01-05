import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Zad4 {

    public static int evaluateExpression(String expression){
        // 2+2*2*2*2*2*2+2*2
        Stack<Integer> stack = new Stack<>();
        int n = expression.length();
        int i =0;

        while(i<n){
            char c = expression.charAt(i);

            if(Character.isDigit(c)){
                int num = 0;
                while(i<n && Character.isDigit(expression.charAt(i))){
                    num = num * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                stack.push(num);
            }
            else if(c=='*'){
                i++;
                int num = 0;
                while(i<n && Character.isDigit(expression.charAt(i))){
                    num = num * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                stack.push(stack.pop()*num);
            }
            else i++;
        }
        int rez =0;
        while(!stack.isEmpty()){
            rez+= stack.pop();
        }return rez;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        int rez =evaluateExpression(expression);
        System.out.println(rez);
    }

}