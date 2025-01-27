package Courses;
import java.util.*;
public class Zad1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<String> stack = new Stack<>();

        while(true){
            String input = scanner.nextLine();
            if(input.equals("x"))break;

            if(input.startsWith("end")){
                String target = input.substring(3);
                if(stack.contains(target))stack.remove(target);
                else {
                    System.out.println("Invalid");
                    return;
                }
            }
            else{
                stack.push(input);
            }
        }
        if(stack.isEmpty()) System.out.println("Valid");
        else System.out.println("Invalid");
    }
}
