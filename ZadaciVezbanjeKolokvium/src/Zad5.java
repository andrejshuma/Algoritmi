import java.util.*;
import java.util.Queue;
import java.util.Stack;

public class Zad5 {
    public static int broiMesanja(int n){

         Queue<Integer> deck = new LinkedList<>();

        for (int i = 1; i <= 51; i++) {
            deck.add(i);
        }
        int counter=0;
        Stack<Integer> raka = new Stack<>();

        while(deck.peek()!=n){
            counter++;

            for (int i = 0; i <7 ; i++) {
                raka.push(deck.poll());
            }

            while(!raka.isEmpty()){
                int n1 = raka.pop();
                int n2 = deck.poll();

                deck.add(n1);
                deck.add(n2);
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
