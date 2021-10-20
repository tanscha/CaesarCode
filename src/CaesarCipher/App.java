package CaesarCipher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App {

    private static String fileHandler(String in){

        StringBuilder filein = new StringBuilder();
        System.out.println("filein " + filein);
        try {
            File file = new File(in);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String fileData = scanner.nextLine();
                filein.append(fileData);
                filein.append(System.lineSeparator());
            }
            scanner.close();

        }
        catch (FileNotFoundException e){
            System.out.println(" ");
            // using input if the file is not found
            filein.append(in);
        }

        return filein.toString();
    }

    public static void main(String[] args) throws InterruptedException {
        boolean exitLoop = false;
        while (!exitLoop) {
            System.out.println("\n---------------------------------------------\n---------WELCOME TO CEASAR CIPHER---------");
            System.out.println("Do you want to encrypt or decrypt your text?\nWrite -e to encrypt, -d to decrypt, bye to exit");
            Scanner newScanner = new Scanner(System.in);
            String option = newScanner.nextLine();

            switch (option) {
                case "-e" -> {
                    System.out.println("---------------------------------------------\n--------Encryption chosen--------");
                    System.out.println("Enter text to encrypt or name of textfile: ");
                    String input = newScanner.nextLine();

                    System.out.println("-------------------------------------------\nEnter decryption key between 1 to 29: ");
                    int key = Integer.parseInt(newScanner.nextLine());


                    System.out.println("-------------------------------------------\nYour text encrypted: ");
                    System.out.print(CaesarCipher.encryption(fileHandler(input), key));
                    TimeUnit.SECONDS.sleep(5);

                }
                case "-d" -> {
                    System.out.println("---------------------------------------------\n--------Decryption chosen--------");
                    System.out.println("Enter text to decrypt or name of textfile: ");
                    String input = newScanner.nextLine();

                    System.out.println("-------------------------------------------\nEnter decryption key between 1 to 29: ");
                    int key = Integer.parseInt(newScanner.nextLine());

                    System.out.println("-------------------------------------------\nYour text decrypted: ");
                    String decrypt = CaesarCipher.decryption(fileHandler(input), key);
                    System.out.print(decrypt);

                    TimeUnit.SECONDS.sleep(5);
                }
                case "bye" -> {
                    System.out.println("Terminating...");
                    exitLoop = true;
                }
            }
        }
    }
}
