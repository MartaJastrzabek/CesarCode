public class CesarCode {
    private static final String ALPHABET = "AĄBCĆDEĘFGHIJKLŁMNŃOÓPRSŚTUWYZŹŻ";
    private static final int ALPHABET_LENGTH = ALPHABET.length();
    private String originalMessage;
    private int vector;

    public CesarCode(String originalMessage, int vector) {
        this.originalMessage = originalMessage.toUpperCase();
        if(vector < 1){
            throw new IllegalArgumentException("Przesunięcie nie może być mniejsze od 1");
        }
        this.vector = vector;
    }

    public String getOriginalMessage() {
        return originalMessage;
    }

    public String encrypt(){
        String newMessage = "";
        for(int i = 0; i < originalMessage.length(); i++){
            char checkedChar = originalMessage.charAt(i);
            int shiftedIndex;
            if(Character.isLetter(checkedChar)){
                shiftedIndex = (ALPHABET.indexOf(checkedChar) + vector)% ALPHABET_LENGTH;
                if(shiftedIndex < ALPHABET_LENGTH){
                    newMessage += ALPHABET.charAt(shiftedIndex);
                } else {
                    shiftedIndex -= ALPHABET_LENGTH;
                    newMessage += ALPHABET.charAt(shiftedIndex);
                }
            }else {
                newMessage += originalMessage.charAt(i);
            }
        }
        return newMessage;
    }

    public String decrypt(){
        String newMessage = "";
        for(int i = 0; i < originalMessage.length(); i++){
            char checkedChar = originalMessage.charAt(i);
            int shiftedIndex;
            if(Character.isLetter(checkedChar)){
                shiftedIndex = (ALPHABET.indexOf(checkedChar) - vector) % ALPHABET_LENGTH;
                if((shiftedIndex) >= 0){
                    newMessage += ALPHABET.charAt(shiftedIndex);
                } else {
                    shiftedIndex += ALPHABET_LENGTH;
                    newMessage += ALPHABET.charAt(shiftedIndex);
                }
            }else {
                newMessage += originalMessage.charAt(i);
            }
        }
        return newMessage;
    }
}
