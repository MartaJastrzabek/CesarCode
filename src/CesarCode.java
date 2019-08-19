public class CesarCode {
    private static final String ALPHABET = "AĄBCĆDEĘFGHIJKLŁMNŃOÓPRSŚTUWYZŹŻ";
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
                int index = ALPHABET.indexOf(checkedChar) + vector;
                if(ALPHABET.length() < index){
                    index -= 32;
                }
                shiftedIndex = index % ALPHABET.length();
                newMessage += ALPHABET.charAt(shiftedIndex);
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
                int index = ALPHABET.indexOf(checkedChar) - vector;
                if(index < 0){
                    index += 32;
                }
                shiftedIndex = index % ALPHABET.length();
                newMessage += ALPHABET.charAt(shiftedIndex);
            }else {
                newMessage += originalMessage.charAt(i);
            }
        }
        return newMessage;
    }
}
