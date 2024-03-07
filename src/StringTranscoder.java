// Responsible for encoding and decoding the characters in the input file
public class StringTranscoder {
    private final CharacterTranscoder characterTranscoder;

    public StringTranscoder() {
        // Default offset character is 'A' - Starting offset character
        this.characterTranscoder = new CharacterTranscoder('A');
    }

    public String encode(String string) {
        // Edge case: String is less than or equal to 1
        if (string.length() <= 1) {
            return string;
        }
        characterTranscoder.setOffsetCharacterIndex(string.charAt(0));
        StringBuilder encodedString = new StringBuilder();
        encodedString.append(string.charAt(0));
        for (int i = 1; i < string.length(); i++) {
            encodedString.append(characterTranscoder.encodeCharacter(string.charAt(i)));
        }
        return encodedString.toString();
    }

    public String decode(String string) {
        // Edge case: String is less than or equal to 1
        if (string.length() <= 1) {
            return string;
        }
        characterTranscoder.setOffsetCharacterIndex(string.charAt(0));
        StringBuilder decodedString = new StringBuilder();
        decodedString.append(string.charAt(0));
        for (int i = 1; i < string.length(); i++) {
            decodedString.append(characterTranscoder.decodeCharacter(string.charAt(i)));
        }
        return decodedString.toString();
    }
}
