package Courses;
import java.util.*;

public class FinTaun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int Adults = scanner.nextInt();
        int Kids = scanner.nextInt();

        int min;
        int max;

        if(Kids==0){
            max=min=Adults*100;
        }
        else if(Kids<Adults){
            min=Adults*100;
            max = Adults * 100 + (Kids-1)* 100;
        }
        else{
             min = Adults * 100 + (Kids-Adults)* 100;
             max = Adults * 100 + (Kids-1)* 100;
        }

        System.out.println(min);
        System.out.println(max);
    }
}
