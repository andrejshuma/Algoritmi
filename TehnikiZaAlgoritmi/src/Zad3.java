
import java.util.*;
public class Zad3 {
    private static void sortiraj(int[] time, int[] profit,int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <n ; j++) {
                if( (float)profit[i] / (float)time[i] < (float)profit[j] / (float)time[j]){
                    int tmpP = profit[i];
                    int tmpT = time[i];
                    profit[i]=profit[j];
                    profit[j]=tmpP;
                    time[i]=time[j];
                    time[j]=tmpT;

                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int C = 40;

        int [] time = new int [n+1];
        int [] profit = new int [n+1];

        for (int i = 0; i <n ; i++) {
            time[i] = scanner.nextInt();
            profit[i] = scanner.nextInt();
        }
        sortiraj(time,profit,n);

        System.out.println(greedyKnapsack(time,profit,n,C));
    }

    private static int  greedyKnapsack(int[] time, int[] profit, int n, int C) {
        int rez =0;
        for (int i = 0; i < n; i++) {
            if(C>=time[i]){
                C-=time[i];
                rez+=profit[i];
            }
            else{
                rez+= (C / (float) time[i]) * profit[i];
                break;
            }
        }
        return rez;
    }


}
