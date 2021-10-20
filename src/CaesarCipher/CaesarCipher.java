package CaesarCipher;


import java.io.*;

public class CaesarCipher {
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyzæøå";

    public static String encryption(String input, int key){
        StringBuilder encrypted = new StringBuilder();
        input = input.toLowerCase();

        // looping through the input to encrypt
        for (int i = 0; i < input.length(); i++){
            // slit the string to single character
            char character = input.charAt(i);

            //checking if character is a letter to shift
            if (Character.isLetter(character)){
                int position = alphabet.indexOf(input.charAt(i));
                //using the key to shift position
                int newPosition = (position + key) % alphabet.length();
                character = alphabet.charAt(newPosition);

                // appending shifted characters
                encrypted.append(character);
            }
            else if (!Character.isLetter(character)) {
                // appending space etc.
                encrypted.append(character);
            }

        }
        // call to save to textfile
        fileSaver(encrypted, key, "encrypt");

        return encrypted.toString();
    }

    public static String decryption(String input, int key){
        StringBuilder decrypted = new StringBuilder();
        input = input.toLowerCase();

        for (int i = 0; i < input.length(); i++){
            char character = input.charAt(i);
            //checking if character is a letter to shift
            if (Character.isLetter(character)) {
                int position = alphabet.indexOf(input.charAt(i));
                int newPosition = (position - key) % alphabet.length();
                // if the new position is less than 0
                if (newPosition < 0) {
                    newPosition = alphabet.length() + newPosition;
                }
                char decryptedCharacter = alphabet.charAt(newPosition);

                decrypted.append(decryptedCharacter);
            }
            else if (!Character.isLetter(character)){
                decrypted.append(character);
            }

        }
        fileSaver(decrypted, key, "decrypt");
        return decrypted.toString();
    }

    private static void fileSaver(StringBuilder string, int key, String method) {
        // Simple method to save the result as a textfile
        // Saving file with name of method and shift key
        File file = new File("src/CaesarCipher/files/" +method + key + ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(string.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
