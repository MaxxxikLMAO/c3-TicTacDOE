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

        System.out.println("Preji prijemne prokrastinovani s pokud mozno nejmene viny, co to jen pujde. ");
        System.out.println("Note: hraci pole je vysoke 15 pozic na vysku a 20 pozic na sirku. ");

        do {
// P1 (CIRCLE)
            int row, column;
            do {
                System.out.print("\n(P1) Zadejte do ktere radky chcete umistit piskvorku (1-15)");
                row = sc.nextInt(); //nemuze byt nextint
                row--;
                if (row > 15 | row < 0)
                    System.out.println("\nNespravne zadana radka. Zkuste to prosim znovu. ");
                else
                    System.out.println("Uspesne zadano.");

            } while (row < 0 | row > 15); // repeatne step pokud invalid hodnota

            do {
                System.out.print("(P1) Zadej sloupec 1-20: ");
                column = sc.nextInt(); //nemuze byt nextint
                column--;
                if (column > 20 | column < 1)
                    System.out.println("\nNespravne zadany sloupec. Zkuste prosim znovu.");
                else
                    System.out.println("Uspesne zadano.");
            } while (column < 0 | column > 20);

            if (field[row][column].equals("-"))
                System.out.println("\nVase umisteni probehlo uspesne!\n");
            else
                System.out.println("Tato pozice je jiz zabrana. ");
            field[row][column] = circle;

            System.out.println("*hraci pole*");
            for (int rowLength = 0; rowLength < field.length; rowLength++) {
                for (int columnLength = 0; columnLength < field[rowLength].length; columnLength++) {
                    System.out.print(field[rowLength][columnLength]);
                }
                System.out.println(" ");
            }

            if (checkWin(column, row, circle, field)) {
                System.out.println("VYHRÁLI JSTE!!! (s ypsilonem)");
                return; //ukončí current metodu jak PÁN (jsme v mainu, takže se program ukončí)
            }

//P2 (CROSS)
            int row2, column2;

            do {
                System.out.print("\n(P2) Zadej do ktere radky chces umistit piskvorku (1-15)");
                row2 = sc.nextInt(); //nemuze byt nextint
                row2--;
                if (row2 > 15 | row2 < 0)
                    System.out.println("\nNespravne zadana rada. Zkuste to prosim znovu. ");
                else
                    System.out.println("Uspesne zadano.");

            } while (row2 < 0 | row2 > 15); // repeatne step pokud invalid hodnota

            do {
                System.out.print("(P2) Zadej sloupec (1-20): ");
                column2 = sc.nextInt(); //nemuze byt nextint
                column2--;
                if (column2 > 20 | column2 < 1)
                    System.out.println("\nNespravne zadany sloupec. Zkuste prosim znovu.");
                else
                    System.out.println("Uspesne zadano.");
            } while (column2 < 0 | column2 > 20);

            if (field[row2][column2].equals("-"))
                System.out.println("\nVase ulozeni probehlo uspesne!\n");
            else
                System.out.println("Tato pozice je jiz zabrana. ");
            field[row2][column2] = cross;

            System.out.println("*hraci pole*");
            for (int rowLength2 = 0; rowLength2 < field.length; rowLength2++) {
                for (int columnLength2 = 0; columnLength2 < field[rowLength2].length; columnLength2++) {
                    System.out.print(field[rowLength2][columnLength2]);
                }
                System.out.println(" ");
            }

            if (checkWin(column, row, cross, field)) {
                System.out.println("VYHRÁLI JSTE!!! (s ypsilonem)");
                return; //ukončí current metodu jak DŽEJQOB PÁNEQ (jsme v mainu, takže se program ukončí)
            }
        } while (true);
    }

    static int VerticalAxisCount(int x, int y, String unit, String[][] playground) {
        int alikeCount = 0;

        for (int modificator = 1; modificator < 5; modificator++) {
            if (y - modificator >= 0) {
                String newTile = playground[y - modificator][x];
                if (newTile.equals(unit)) {
                    alikeCount++;
                } else {
                    break;
                }
            }
        }

        for (int modificator = 1; modificator < 5; modificator++) {
            if (y + modificator < playground[x].length) {
                String newTile = playground[y + modificator][x];
                if (newTile.equals(unit)) {
                    alikeCount++;
                } else {
                    break;
                }
            }
        }
        return alikeCount;
    }

    static int HorizontalAxisCount(int x, int y, String tile, String[][] playground) {
        int alikeCount = 0;

        for (int modificator = 1; modificator < 5; modificator++) {
            // pokud neni jednotka by the edge of da playground, tak nechat pricitani alikeCountu
            if (x - modificator >= 0) {
                String newTile = playground[y][x - modificator];
                if (newTile.equals(tile)) {
                    alikeCount++;
                } else {
                    break;
                }
            }
        }

        for (int modificator = 1; modificator < 5; modificator++) {
            if (x + modificator < playground[y].length) {
                String newTile = playground[y][x + modificator];
                if (newTile.equals(tile)) {
                    alikeCount++;
                } else {
                    break;
                }
            }
        }
        return alikeCount;
    }

    static int DiagonalAxisCountOne(int x, int y, String tile, String[][] playground) {
        int alikeCount = 0;

        for (int modificator = 1; modificator < 5; modificator++) {
            // pokud neni jednotka by the edge of da playground, tak nechat pricitani alikeCountu
            if (y - modificator >= 0 && x - modificator >= 0) {
                String newTile = playground[y - modificator][x - modificator];
                if (newTile.equals(tile)) {
                    alikeCount++;
                } else {
                    break;
                }
            }
        }

        for (int modificator = 1; modificator < 5; modificator++) {
            if (y + modificator >= 0 && x + modificator >= 0) {
                String newTile = playground[y + modificator][x + modificator];
                if (newTile.equals(tile)) {
                    alikeCount++;
                } else {
                    break;
                }
            }
        }
        return alikeCount;
    }

    static int DiagonalAxisCountTwo(int x, int y, String tile, String[][] playground) {
        int alikeCount = 0;

        for (int modificator = 1; modificator < 5; modificator++) {
            // pokud neni jednotka by the edge of da playground, tak nechat pricitani alikeCountu
            if (y - modificator >= 0 && x + modificator >= 0) {
                String newTile = playground[y - modificator][x + modificator];
                if (newTile.equals(tile)) {
                    alikeCount++;
                } else {
                    break;
                }
            }
        }

        for (int modificator = 1; modificator < 5; modificator++) {
            if (y + modificator >= 0 && x - modificator >= 0) {
                String newTile = playground[y + modificator][x - modificator];
                if (newTile.equals(tile)) {
                    alikeCount++;
                } else {
                    break;
                }
            }
        }
        return alikeCount;
    }

    static boolean checkWin(int x, int y, String tile, String[][] playground) {
        if (DiagonalAxisCountOne(x, y, tile, playground) >= 4 || HorizontalAxisCount(x, y, tile, playground) >= 4 || VerticalAxisCount(x, y, tile, playground) >= 4) {
            return true;
        } else {
            return false;
        }
    }

    //
//CODYcomment ify ze kdyz soucet se necemu rovna tak triggernu nejakou metodu
}
