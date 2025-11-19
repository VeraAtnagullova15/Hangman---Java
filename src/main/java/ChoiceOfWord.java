import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

public class ChoiceOfWord {
    public static String randomWord()  {
        ClassLoader classLoader = Game.class.getClassLoader();

        InputStream is = classLoader.getResourceAsStream("singular.txt");
        if (is == null) {
            System.out.println("Файл не найден!");
        }
        Scanner scan = new Scanner(is);
        String[] arrayWords = new String[67_600]; // number of word in the file
        for(int i = 0; i < arrayWords.length; i++) {
            arrayWords[i] = scan.nextLine();
        }
        scan.close();
        Random rand = new Random();
        String wordForGuess = arrayWords[rand.nextInt(arrayWords.length)];
        wordForGuess = wordForGuess.toLowerCase();
        return wordForGuess;
    }
}
