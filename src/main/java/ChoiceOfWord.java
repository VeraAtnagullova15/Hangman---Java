import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ChoiceOfWord {

    public static String randomWord(String filename) {
        ClassLoader classLoader = Game.class.getClassLoader();

        InputStream inputStream = classLoader.getResourceAsStream(filename);
        if (inputStream == null) {
            System.out.println("Файл не найден!");
        }
        Scanner scanner = new Scanner(inputStream);

        ArrayList<String> listWords = new ArrayList<>();
        while (scanner.hasNextLine()) {
            listWords.add(scanner.nextLine().trim());
        }
        scanner.close();
        Random random = new Random();
        String wordForGuess;
        while (true) {
            wordForGuess = listWords.get(random.nextInt(0, listWords.size()));
            if (wordForGuess.length() <= 10 && wordForGuess.length() >= 5 &&
                    !wordForGuess.endsWith("ый") && !wordForGuess.endsWith("ой") &&
                    !wordForGuess.endsWith("ий") && !wordForGuess.endsWith("ая") &&
                    !wordForGuess.endsWith("яя") && !wordForGuess.endsWith("ое") &&
                    !wordForGuess.endsWith("ее") && !wordForGuess.endsWith("ые") &&
                    !wordForGuess.endsWith("ие") && !wordForGuess.endsWith("ы") &&
                    !wordForGuess.endsWith("и") && wordForGuess.indexOf("ц") == -1 &&
                    !wordForGuess.endsWith("ца") && !wordForGuess.endsWith("ум") &&
                    wordForGuess.indexOf("ы") == -1 && wordForGuess.indexOf("-") == -1 &&
                    wordForGuess.indexOf("ль") == -1 && wordForGuess.indexOf("х") == -1 &&
                    wordForGuess.indexOf("щ") == -1 && wordForGuess.indexOf("шка") == -1 &&
                    wordForGuess.indexOf("э") == -1) {

                wordForGuess = wordForGuess.toLowerCase();
                return wordForGuess;
            }
        }
    }
}


