package Kniga;

import java.util.*;

public class Pharmacy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        HashMap<Name, Drug> mapa = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            Drug drug = new Drug(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3]));
            mapa.put(new Name(input[0].toUpperCase()), drug);
        }

        String order = scanner.nextLine().toUpperCase();

        while (order.equals("END")) {
            int q = scanner.nextInt();
            scanner.nextLine();
            Drug drug = mapa.get(new Name(order));

            if (drug == null) {
                System.out.println("No such drug");
                order = scanner.nextLine();
            } else if (drug.name.equals(order)) {
                System.out.println(drug);
                if (drug.quantity < q) {
                    System.out.println("No drugs available");
                } else {
                    int old = drug.quantity;
                    drug.setQuantity(old - q);
                    mapa.put(new Name(order), drug);
                    System.out.println("Order Made");
                }
                order = scanner.nextLine().toUpperCase();
            }
        }
    }
}
//        5
//        ACEROLA 0 100 1000
//        ACIKLOVIR 1 1650 87
//        HYDROCYKLIN 0 55 10
//        GENTAMICIN 1 152 90
//        HYDROCYKLIN20 0 113 20
//        hydroCyklinn
//        2
//        hydroCyklin20
//        2
//        END
