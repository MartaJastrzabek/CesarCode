import java.util.InputMismatchException;

public class CesarCode {
    private static final String ALPHABET = "AĄBCĆDEĘFGHIJKLŁMNŃOÓPRSŚTUWYZŹŻ";
    private static final int ALPHABET_LENGTH = ALPHABET.length();
    private String orginalMessage;
    private int vector;

    public CesarCode(String orginalMessage, int vector) {
        this.orginalMessage = orginalMessage.toUpperCase();
        if(vector < 1){
            throw new InputMismatchException("Przesunięcie nie może być mniejsze od 1");
        }
        this.vector = vector;
    }

    public String getOrginalMessage() {
        return "Orginalna wiadomość: " + orginalMessage;
    }

    public String encrypt(){
        String newMessage = "";
        for(int i = 0; i < orginalMessage.length(); i++){
            char checkedChar = orginalMessage.charAt(i);
            if(Character.isLetter(checkedChar)){
                int index = ALPHABET.indexOf(checkedChar);
                if((index + vector)< ALPHABET_LENGTH){
                    newMessage += ALPHABET.charAt(index + vector);
                } else {
                    //multiply by -1 to make count an positive number
                    int count = (ALPHABET_LENGTH - index - vector)*(-1);
                    newMessage += ALPHABET.charAt(count);
                }
            }else {
                newMessage += orginalMessage.charAt(i);
            }
        }
        return "Zaszyfrowana wiadomość: " + newMessage;
    }

    public String decrypt(){
        String newMessage = "";
        for(int i = 0; i < orginalMessage.length(); i++){
            char checkedChar = orginalMessage.charAt(i);
            if(Character.isLetter(checkedChar)){
                int index = ALPHABET.indexOf(checkedChar);
                if((index - vector) >= 0){
                    newMessage += ALPHABET.charAt(index - vector);
                } else {
                    //multiply by -1 to make count an positive number
                    int count = ALPHABET_LENGTH - (index - vector) *(-1);
                    newMessage += ALPHABET.charAt(count);
                }
            }else {
                newMessage += orginalMessage.charAt(i);
            }
        }
        return "Zdeszyfrowana wiadomość: " + newMessage;
    }

}
