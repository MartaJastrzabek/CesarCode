import java.util.InputMismatchException;
import java.util.Scanner;

public class CesarCodeTest {
    public static void main(String[] args) {
        boolean isExit = false;
        do{
            System.out.println(printMenu());
            try {
                Scanner in = new Scanner(System.in);
                int choice = in.nextInt();
                in.nextLine();
                CesarCode cesar;
                switch (choice) {
                    case 1:
                        cesar = getUserInput(in);
                        System.out.println(cesar.getOrginalMessage());
                        System.out.println(cesar.encrypt());
                        break;
                    case 2:
                        cesar = getUserInput(in);
                        System.out.println(cesar.getOrginalMessage());
                        System.out.println(cesar.decrypt());
                        break;
                    case 0:
                        isExit = true;
                        break;
                    default:
                        throw new InputMismatchException("Podaj poprawną wartość!");
                }
            } catch (InputMismatchException e){
                System.out.println(e.getMessage());
            }
        }while (!isExit);


    }

    private static CesarCode getUserInput(Scanner in) {
        System.out.println("Podaj wiadomość: ");
        String message = in.nextLine();
        System.out.println("Podaj żądane przesunięcie:");
        int vector = in.nextInt();
        in.nextLine();
        return new CesarCode(message, vector);
    }


    private static String printMenu(){
        return "Menu: \nWciśnij 1. aby zaszyfrować wiadomość,\n" +
                "Wciśnij 2. aby zdeszyfrować wiadomość,\n" +
                "Wciśnij 0. aby wyjść z programu";
    }
}