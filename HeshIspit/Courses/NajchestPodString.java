package Courses;
import java.util.*;

public class NajchestPodString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        HashMap<String, Integer> map = new HashMap<>();

        int n = word.length();
        int freq = Integer.MIN_VALUE;
        String rez = "";

        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n-i; j++) {
                String w = word.substring(j,j+i+1);
                if(map.get(w)==null){
                    map.put(w,1);
                }
                else{
                    map.put(w,map.get(w)+1);
                }

                int tmp = map.get(w);
                if(tmp>freq){
                    freq=tmp;
                    rez = w;
                }
                else if(tmp==freq){
                    if(w.length() > rez.length())rez=w;

                    else if(w.length() == rez.length()){
                        if(rez.compareTo(w)>0){
                            rez = w;
                        }
                    }
                }
            }
        }
        System.out.println(rez);
    }
}
