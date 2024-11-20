import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


class prog
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> lista = new ArrayList<>();
        List<Integer> lista1 = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            lista.add(a);
            lista1.add(b);
        }
        lista.sort(Comparator.naturalOrder());
        lista1.sort(Comparator.naturalOrder());

        int i = 1, j = 0;
        int count = 1;
        int maks = 1;
        while (i < n && j < n)
        {
            if(lista.get(i) <= lista1.get(j))
            {
                count++;
                i++;
            }
            else
            {
                count--;
                j++;
            }
            maks = Math.max(maks, count);
        }
        System.out.print(maks);
    }
}