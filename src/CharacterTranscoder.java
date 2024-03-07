import java.util.HashMap;
import java.util.Map;

// Responsible for encoding the characters in the input file
public class CharacterTranscoder {

    private final char[] referenceTable; // Responsible for getting offset character
    private final Map<Character, Integer> referenceTableMap; // Responsible for getting the initial character and its index
    private int offsetCharacterIndex;

    public CharacterTranscoder(Character offsetCharacter) {
        setOffsetCharacterIndex(offsetCharacter);
        this.referenceTable = getReferenceTable();
        this.referenceTableMap = getReferenceTableMap();
    }

    // Setter for offsetCharacterIndex to be changed at any time
    public void setOffsetCharacterIndex(Character offsetCharacter) {
        this.offsetCharacterIndex = getReferenceTableMap().get(offsetCharacter);
    }

    public Character encodeCharacter(Character character) {
        int characterIndex = referenceTableMap.getOrDefault(character, -1); // O(1)
        // Edge case: character not found in reference table
        if (characterIndex == -1) {
            return character;
        }
        int encodedIndex = characterIndex - offsetCharacterIndex;
        if (encodedIndex < 0) {
            encodedIndex += 44;
        }
        return referenceTable[encodedIndex]; // O(1)
    }

    public Character decodeCharacter(Character character) {
        int characterIndex = referenceTableMap.getOrDefault(character, -1); // O(1)
        // Edge case: character not found in reference table
        if (characterIndex == -1) {
            return character;
        }
        int decodedIndex = (characterIndex + offsetCharacterIndex) % 44;
        return referenceTable[decodedIndex]; // O(1)
    }

    private char[] getReferenceTable() {
        // Max of 44 characters
        char[] arr = new char[44];
        // Insert A to Z
        for (int i = 0; i < 26; i++) {
            arr[i] = (char) (65 + i);
        }
        // Insert 0 to 9
        for (int i = 26; i < 36; i++) {
            arr[i] = (char) (48 + i - 26);
        }
        // Insert special characters
        for (int i = 36; i < 44; i++) {
            arr[i] = (char) (40 + i - 36);
        }
        return arr;
    }

    private Map<Character, Integer> getReferenceTableMap() {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put((char) (65 + i), i);
        }
        // Insert 0 to 9
        for (int i = 26; i < 36; i++) {
            map.put((char) (48 + i - 26), i);
        }
        // Insert special characters
        for (int i = 36; i < 44; i++) {
            map.put((char) (40 + i - 36), i);
        }
        return map;
    }

}
