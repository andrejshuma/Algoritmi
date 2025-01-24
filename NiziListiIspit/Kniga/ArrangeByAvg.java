package Kniga;

import classes.DLL;
import classes.DLLNode;

import java.util.*;

public class ArrangeByAvg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        DLL<Integer> lista = new DLL<>();
        for (int i = 0; i <n ; i++) lista.insertLast(scanner.nextInt());

        System.out.println(lista);

        DLLNode<Integer> curr = lista.getFirst();
        int sum = 0;
        while(curr!=null){
            sum+= curr.element;
            curr = curr.succ;
        }

        float avg = (float) sum / (float) lista.getSize();
        curr = lista.getLast();

        DLL<Integer> pomali = new DLL<>();
        DLL<Integer> pogolemi = new DLL<>();


        while(curr!=null){
            if(curr.element<= avg)pomali.insertLast(curr.element);
            else pogolemi.insertLast(curr.element);

            curr=curr.pred;
        }

        System.out.println(pomali);
        System.out.println(pogolemi);
    }
}
