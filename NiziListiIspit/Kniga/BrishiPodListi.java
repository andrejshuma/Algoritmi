package Kniga;
import classes.DLL;
import classes.DLLNode;
import java.util.*;
public class BrishiPodListi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numPrva = scanner.nextInt();
        DLL<Integer> prva= new DLL<>();
        for (int i = 0; i <numPrva ; i++) {
            prva.insertLast(scanner.nextInt());
        }
        
        int numVtora = scanner.nextInt();
        DLL<Integer> vtora= new DLL<>();
        for (int i = 0; i <numVtora ; i++) {
            vtora.insertLast(scanner.nextInt());
        }

        DLLNode<Integer> firstCurr = prva.getFirst();

        while(firstCurr!=null){
            DLLNode<Integer> vtorCurr = vtora.getFirst();
            if (Objects.equals(firstCurr.element, vtorCurr.element)) {
                boolean flag = true;
                DLLNode<Integer> tmp = firstCurr;
                for (int i = 0; i <vtora.getSize()-1 ; i++) {
                    tmp=tmp.succ;
                    vtorCurr=vtorCurr.succ;
                    if(!Objects.equals(tmp.element, vtorCurr.element)){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    for (int i = 0; i <vtora.getSize() ; i++) {
                        prva.delete(firstCurr);
                        firstCurr=firstCurr.succ;
                    }
                    continue;
                }

            }

            firstCurr=firstCurr.succ;
        }

//22 1 2 3 4 5 6 1 2 3 4 5 6 1 2 6 5 1 3 4 1 5 2 3 4 5 6
        System.out.println(prva);
    }
}
