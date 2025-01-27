package Courses;

import java.util.*;

public class ShufflingDeck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(numberOfShuffles(N));
    }

    private static int numberOfShuffles(int n) {
        Queue<Integer> deck = new LinkedList<>();

        for (int i = 1; i <=51 ; i++) {
            deck.add(i);
        }

        int counter = 0;
        Stack<Integer> hand = new Stack<>();

        while(deck.peek()!=n){
            counter++;

            for (int i = 0; i <7 ; i++) {
                hand.push(deck.poll());
            }

            while(!hand.isEmpty()){
                int n1 = hand.pop();
                int n2 = deck.poll();

                deck.add(n1);
                deck.add(n2);
            }
        }
        return counter;
    }
}
