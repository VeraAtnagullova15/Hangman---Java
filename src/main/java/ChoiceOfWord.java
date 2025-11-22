import java.io.*;
import java.util.*;

public class ChoiceOfWord {

    static String choosingWordForGuess(String filename) {
        ClassLoader classLoader = Game.class.getClassLoader();

        InputStream inputStream = classLoader.getResourceAsStream(filename);
        if (inputStream == null) {
            String path = new File("src/main/resources/" + filename).getAbsolutePath();
            System.out.println("Файл не удалось открыть!");
            System.out.println("Файл должен находиться в папке:");
            System.out.println(path);
            System.out.println("Программа будет завершена!");

            System.exit(1);
        }
        Scanner scanner = new Scanner(inputStream);

        List<String> words = new ArrayList<>();
        while (scanner.hasNextLine()) {
            words.add(scanner.nextLine().trim());
        }
        scanner.close();
        Random random = new Random();
        String wordForGuess;
        while (true) {
            wordForGuess = words.get(random.nextInt(0, words.size()));
            if (wordForGuess.length() <= 8 && wordForGuess.length() >= 5 &&
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

                return wordForGuess.toLowerCase();
            }
        }
    }
}


