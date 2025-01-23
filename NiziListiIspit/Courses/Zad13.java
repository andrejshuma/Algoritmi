package Courses;

import classes.DLL;
import classes.DLLNode;

import java.util.*;

public class Zad13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        DLL<Integer> list = new DLL<>();
        for (int i = 0; i < n; i++) list.insertLast(scanner.nextInt());

        int counter =0; // prosekot pred > prosek posle

        DLLNode<Integer> curr = list.getFirst();

        while(curr!=null){

            DLLNode<Integer> pred = curr.pred;
            DLLNode<Integer> posle = curr.succ;

            int sumPred=0;
            int countPred=0;

            int sumPosle=0;
            int countPosle=0;

            while(pred!=null){
                countPred++;
                sumPred+=pred.element;
                pred=pred.pred;
            }

            while(posle!=null){
                countPosle++;
                sumPosle+=posle.element;
                posle=posle.succ;
            }

            if((double)sumPred / (double) countPred > (double) sumPosle / (double) countPosle)counter++;


            curr=curr.succ;
        }
        System.out.println(counter);
    }
}
