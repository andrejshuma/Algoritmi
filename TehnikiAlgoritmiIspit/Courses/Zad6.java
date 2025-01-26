package Courses;
import java.util.*;
public class Zad6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        int counter=0;
        ArrayList<Integer> zalutani= new ArrayList<>();
        ArrayList<Integer> spaces= new ArrayList<>();


        for (int i = 1; i <n ; i++) {
            if(list.get(i)<list.get(i-1)){
                counter++;
                zalutani.add(list.get(i));
                int pos = i-1;
                int mesta =0;
                while(list.get(i)<list.get(pos) && pos>0){
                    mesta++;
                    pos--;
                }
                if(list.get(i)<list.get(0))mesta++;
                spaces.add(mesta);
                list.remove(list.get(i));
                n--;
            }
        }

        System.out.println(counter);

        for (int i = 0; i < zalutani.size() ; i++) {
            System.out.println(zalutani.get(i) + " "+spaces.get(i));
        }
    }
}
