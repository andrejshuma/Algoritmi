import java.util.*;
import java.util.Queue;
import java.util.Stack;

public class Zad5 {
    public static int broiMesanja(int n){
         Queue<Integer> shpil=new LinkedList<>();

        for(int i=1;i<=51;i++){
            shpil.add(i);
        }

        Stack<Integer>zemeni=new Stack<>();

        int counter=0;

        while (shpil.peek()!=n){

            counter++;

            for(int i=0;i<7;i++){
                zemeni.push(shpil.poll());
            }

            while (!zemeni.isEmpty()){
                int n1=shpil.poll();

                int n2=zemeni.pop();

                shpil.add(n2);
                shpil.add(n1);
            }
        }
        return counter;

    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(broiMesanja(n));
    }
}
