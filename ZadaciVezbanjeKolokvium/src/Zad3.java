import java.util.*;
public class Zad3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int maks=0;
        int min=0;

        // 4 vozrasni, 10 deca
        // maksimalno se trosi  (n+m-1) * 100, ako na edniot covek se site deca, a drugite se sami
        if (m > 0) maks = (n + m - 1) * 100;
        else maks = n * 100;

        if(n<m) {
            // minimalno se trosi ako sekoj od lugjeto ima deca i barem eden besplaten kje dojde za sekoj covek
            // znaci minimalno kje se plati (n + (m-n))*100
            // 4 10     V ddd V ddd Vddd Vd

            if (m == 1 || m == 0) min = maks;
            else min = (n + Math.abs(m - n)) * 100;
        }
        else{ // decata site besplatno kje se vozat
            min = n*100;
        }


        System.out.println(min);
        System.out.println(maks);

    }
}
