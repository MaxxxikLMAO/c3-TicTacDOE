import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        String field[][] = new String[15][20];
        String circle = "o";
        String cross = "x";
        String dash = "-";
        // int end, row, column, i, j;
        Scanner sc = new Scanner(System.in);

        for (int rowIndex = 0; rowIndex < field.length; rowIndex++) {
            String[] row = field[rowIndex];
            for (int columnIndex = 0; columnIndex < row.length; columnIndex++) {
                row[columnIndex] = "-";
            }
        }

        System.out.println("Preji prijemne prokrastinovani s pokud mozno nejmene guiltem, co to jen pujde. ");
        System.out.println("Note: hraci pole je vysoke 15 pozic na vysku a 20 pozic na sirku. ");


// P1 (CIRCLE)
        int row, column;
        do {
            System.out.print("\nZadej do ktere radky chces umistit piskvorku (1-15)");
            row = sc.nextInt(); //nemuze byt nextint
            row--;
            if (row > 15 | row < 0)
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
        for (int rowLength = 0; rowLength < field.length; rowLength++) {
            for (int columnLength = 0; columnLength < field.length; columnLength++) {
                System.out.print(field[rowLength][columnLength]);
            }
            System.out.println(" ");
        }

        if(checkWin(column, row, circle, field)) {
            System.out.println("VYHRÁLI JSTE!!! (s ypsilonem)");
            return; //ukončí current metodu jak DŽEJQOB PÁNEQ (jsme v mainu, takže se program ukončí)
        }

//P2 (CROSS)
        int row2, column2;

        do {
            System.out.print("\nZadej do ktere radky chces umistit piskvorku (1-15)");
            row2 = sc.nextInt(); //nemuze byt nextint
            row2--;
            if (row2 > 15 | row2 < 0)
                System.out.println("\nNespravne zadana rada. Zkuste to prosim znovu. ");
            else
                System.out.println("Uspesne zadano.");

        } while (row2 < 0 | row2 > 15); // repeatne step pokud invalid hodnota

        do {
            System.out.print("Zadej sloupec (1-20): ");
            column2 = sc.nextInt(); //nemuze byt nextint
            column2--;
            if (column2 > 20 | column2 < 1)
                System.out.println("\nNespravne zadany sloupec. Zkuste prosim znovu.");
            else
                System.out.println("Uspesne zadano.");
        } while (column2 < 0 | column2 > 20);

        if (field[row2][column2].equals("-"))
            System.out.println("\nVase rezervace probehla uspesne!\n");
        else
            System.out.println("Tato pozice je jiz zabrana. ");
        field[row2][column2] = cross;

        System.out.println("*hraci pole*");
        for (int rowLength2 = 0; rowLength2 < field.length; rowLength2++) {
            for (int columnLength2 = 0; columnLength2 < field.length; columnLength2++) {
                System.out.print(field[rowLength2][columnLength2]);
            }
            System.out.println(" ");

        }

        if(checkWin(column, row, circle, field)) {
            System.out.println("VYHRÁLI JSTE!!! (s ypsilonem)");
            return; //ukončí current metodu jak DŽEJQOB PÁNEQ (jsme v mainu, takže se program ukončí)
        }

    }

    static int VerticalAxisCount(int x, int y, String unit, String[][] playground) {
        int alikeCount = 0;

        for(int modificator = 1; modificator < 5; modificator++) {
            String newTile = playground[y][x - modificator];
            if(newTile.equals(unit)) {
                alikeCount++;
            } else {
                break;
            }
        }

        for(int modificator = 1; modificator < 5; modificator++) {
            String newTile = playground[y][x + modificator];
            if(newTile.equals(unit)) {
                alikeCount++;
            } else {
                break;
            }
        }
        return alikeCount;
    }

    static int HorizontalAxisCount(int x, int y, String tile, String[][] playground) {
        int alikeCount = 0;

        for(int modificator = 1; modificator < 5; modificator++) {
            String newTile = playground[y - modificator][x];
            if(newTile.equals(tile)) {
                alikeCount++;
            } else {
                break;
            }
        }

        for(int modificator = 1; modificator < 5; modificator++) {
            String newTile = playground[y - modificator][x];
            if(newTile.equals(tile)) {
                alikeCount++;
            } else {
                break;
            }
        }
        return alikeCount;
    }

    static int DiagonalAxisCount(int x, int y, String tile, String[][] playground) {
        int alikeCount = 0;

        for(int modificator = 1; modificator < 5; modificator++) {
            String newTile = playground[y - modificator][x  - modificator];
            if(newTile.equals(tile)) {
                alikeCount++;
            } else {
                break;
            }
        }

        for(int modificator = 1; modificator < 5; modificator++) {
            String newTile = playground[y + modificator][x + modificator];
            if(newTile.equals(tile)) {
                alikeCount++;
            } else {
                break;
            }
        }
        return alikeCount;
    }

    static boolean checkWin(int x, int y, String tile, String[][] playground) {

        if(DiagonalAxisCount(x, y, tile, playground) > 4 || HorizontalAxisCount(x, y, tile, playground) > 4 || VerticalAxisCount(x, y, tile, playground) > 4) {
            return true;
        } else {
            return false;
        }
    }

    //
//CODYcomment ify ze kdyz soucet se necemu rovna tak triggernu nejakou metodu
}
