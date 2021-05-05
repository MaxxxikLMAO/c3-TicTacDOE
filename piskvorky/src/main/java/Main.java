import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        String field[][] = new String[15][20];
        String circle = "o";
        String cross = "x";
        String dash = "-";
       // int end, row, column, i, j;
        Scanner sc = new Scanner(System.in);

        for(int rowIndex = 0; rowIndex < field.length; rowIndex++) {
            String[] row = field[rowIndex];
            for(int columnIndex = 0; columnIndex < row.length; columnIndex++) {
                row[columnIndex] = "-";
            }
        }

        System.out.println("Preji prijemne prokrastinovani s pokud mozno nejmene guiltem, co to jen pujde. ");
        System.out.println("Note: hraci pole je vysoke 15 pozic na vysku a 20 pozic na sirku. ");

        int row, column;

        do {
            System.out.print("\nZadej do ktere radky chces umistit piskvorku (1-15)");
            row = sc.nextInt(); //nemuze byt nextint
            row--;
            if (row > 15 | row < 1)
                System.out.println("\nNespravne zadana rada. Zkuste to prosim znovu. ");
            else
                System.out.println("Uspesne zadano.");

        } while (row < 0 | row > 15); // repeatne step pokud invalid hodnota

        do {
            System.out.print("Zadej sloupec (1-20): ");
            column = sc.nextInt(); //nemuze byt nextint
            column--;
            if (column > 20 | column < 1)
                System.out.println("\nNespravne zadany sloupec. Zkuste prosim znovu.");
            else
                System.out.println("Uspesne zadano.");
        } while (column < 0 | column > 20);

        if (field[row][column].equals("-"))
            System.out.println("\nVase rezervace probehla uspesne!\n");
        else
            System.out.println("Tato pozice je jiz zabrana. ");
        field[row][column] = circle;

        System.out.println("*hraci pole*");
        for (int rowLength2 = 0; rowLength2 < field.length; rowLength2++) {
            for (int columnLength2 = 0; columnLength2 < field.length; columnLength2++) {
                System.out.print(field[rowLength2][columnLength2]);
            }
            System.out.println(" ");
        }

        /*do {



            System.out.println("Chcete pokracovat? (Ano = 69 / Ne = napis neco random xd)");
            end = sc.nextInt();

        } while (end == 69);*/
    }
}
