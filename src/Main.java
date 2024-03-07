public class Main {
    public static void main(String[] args) {
        StringTranscoder stringTranscoder = new StringTranscoder();
        String inputString = "FHELLO WORLD";
        System.out.println("Input: " + inputString);
        String encodedString = stringTranscoder.encode(inputString);
        System.out.println("Encoded: " + encodedString);
        String decodedString = stringTranscoder.decode(encodedString);
        System.out.println("Decoded: " + decodedString);

    }
}