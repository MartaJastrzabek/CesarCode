import java.util.InputMismatchException;
import java.util.Scanner;

public class CesarCodeTest {
    public static void main(String[] args) {
        boolean isExit = false;
        CesarCode cesar;
        String message;
        int vector;
        Scanner in = new Scanner(System.in);
        do{
            System.out.println(printMenu());
            try {
                int choice = in.nextInt();
                in.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Podaj wiadomość do zaszyfrowania: ");
                        message = in.nextLine();
                        System.out.println("Podaj wartość przesunięcia: ");
                        vector = in.nextInt();
                        in.nextLine();
                        cesar = new CesarCode(message, vector);
                        System.out.println(printOrginalMessage() + message.toUpperCase());
                        System.out.println("Zaszyfrowana wiadomość: " + cesar.encrypt());
                        break;
                    case 2:
                        System.out.println("Podaj wiadomość do zaszyfrowania: ");
                        message = in.nextLine();
                        System.out.println("Podaj wartość przesunięcia: ");
                        vector = in.nextInt();
                        in.nextLine();
                        cesar = new CesarCode(message, vector);
                        System.out.println(printOrginalMessage() + message.toUpperCase());
                        System.out.println("Zdeszyfrowana wiadomość: " + cesar.decrypt());
                        break;
                    case 0:
                        isExit = true;
                        break;
                    default:
                        System.out.println("Podaj poprawną wartość!");
                }

            } catch (InputMismatchException e){
                System.out.println("Wprowadzono nie właściwy typ danych wejściowych");
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }while (!isExit);

        in.close();
    }

    private static String printOrginalMessage(){
        return "Orginalna wiadomość: ";
    }

    private static String printMenu(){
        return "Menu: \nWciśnij 1. aby zaszyfrować wiadomość,\n" +
                "Wciśnij 2. aby zdeszyfrować wiadomość,\n" +
                "Wciśnij 0. aby wyjść z programu";
    }
}
