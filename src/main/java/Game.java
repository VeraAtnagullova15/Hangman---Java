import java.util.*;

public class Game {
    private static final int NUMBER_OF_MISTAKE = 6;
    private static int counterOfMistake;
    private static String filename = "singular.txt";
    private static final char HIDDEN_LETTER = '*';
    private static String wordForGuess;
    private static char[] word;
    private static char[] secretWord;
    private static List<String> usedLetters;


    static boolean isRussianLetter(char letter) {
        char c = Character.toLowerCase(letter);
        return ((letter >= 'а' && letter <= 'я') ||
                (letter >= 'А' && letter <= 'Я') ||
                letter == 'ё' || letter == 'Ë');
    }

    static boolean isInputLetterCorrect(String s) {
        if (s.length() == 1) {
            char letter = s.charAt(0);
            if (isRussianLetter(letter)) {
                return true;
            }
        }
        return false;
    }

    static boolean wordIsGuessed(char[] secretWord) {
        int counter = 0;
        for (int i = 0; i < secretWord.length; i++) {
            if (secretWord[i] != HIDDEN_LETTER) {
                counter++;
            }
        }
        if (counter == secretWord.length) {
            return true;
        }
        return false;
    }


    static char[] makeSecretWord(String wordForGuess) {
        char[] word = wordForGuess.toCharArray();
        char[] secretWord = new char[word.length]; // array to display the word with '*'
        for (int i = 0; i < secretWord.length; i++) {
            secretWord[i] = HIDDEN_LETTER;
        }
        return secretWord;
    }

    static char readLetter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите только одну букву русского алфавита");
        System.out.println();
        String attemptGuess = scanner.nextLine();
        attemptGuess = attemptGuess.toLowerCase();
        char letter = '0';
        if (isInputLetterCorrect(attemptGuess)) {
            letter = attemptGuess.charAt(0);
        }
        return letter;
    }

    static boolean isLetterUsedAgain(char symbol) {
        if (usedLetters.contains(String.valueOf(symbol))) {
            return true;
        }
        //usedLetters.add(String.valueOf(symbol));
        return false;
    }

    static void collectUsedLetter(char symbol) {
        if (!isLetterUsedAgain(symbol)) {
            usedLetters.add(String.valueOf(symbol));
        }
    }

    static boolean letterFound(char letter) {
        for (int i = 0; i < word.length; i++) {
            if (word[i] == letter) {
                return true;
            }
        }
        return false;
    }

    static void letterOpen(char letter) {
        int letterIndex;
        for (int i = 0; i < word.length; i++) {
            if (word[i] == letter) {
                letterIndex = i;
                secretWord[letterIndex] = letter;
            }
        }
    }

    static void printState() {
        for (char symbol : secretWord) {
            System.out.print(symbol);
        }
        System.out.println();
        System.out.println("Допущено ошибок:" + counterOfMistake);
        System.out.println("Осталось ошибок:" + (NUMBER_OF_MISTAKE - counterOfMistake));
        PictureOfHangman.draw(counterOfMistake);
    }

    static void printUsedLetters() {
        System.out.println("Список букв, которые уже были введены:");
        for (String letter : usedLetters) {
            System.out.print(letter + " ");
        }
        System.out.println();
        System.out.println();
    }

    static boolean isWin() {
        return wordIsGuessed(secretWord);
    }

    static boolean isLose() {
        if (counterOfMistake == NUMBER_OF_MISTAKE) {
            return true;
        }
        return false;
    }

    static boolean isGameOver() {
        return isWin() || isLose();
    }

    static void printWinMessage() {
        System.out.println("Вы выиграли! Поздравляю!!!");
        System.out.println();
    }

    static void printLoseMessage() {
        System.out.println("Вы проиграли.");
        System.out.println("Было загадано слово: " + wordForGuess);
        System.out.println();
    }


    static void gameLoop() {
        counterOfMistake = 0;
        wordForGuess = ChoiceOfWord.choosingWordForGuess(filename);
        System.out.println(wordForGuess);
        //System.out.println("*".repeat(wordForGuess.length()));
        word = wordForGuess.toCharArray();
        secretWord = makeSecretWord(wordForGuess);
        usedLetters = new ArrayList<>();


        while (!isGameOver()) {
            printState();
            char letter = readLetter();
            if (letter == '0') {
                System.out.println("Вы ввели некорректный символ или ввели несколько букв подряд\n");
                continue;
            }

            //boolean isUsedLetterAgain;
            if (isLetterUsedAgain(letter)) {
                System.out.println("Эта буква уже была введена, попробуйте ввести другую букву");
                continue;
            }

            if (!letterFound(letter) && !isLetterUsedAgain(letter)) {
                counterOfMistake++;
            }

            letterOpen(letter);

            printUsedLetters();

            collectUsedLetter(letter);

            if (isLose()) {
                printState();
                printLoseMessage();
            } else if (isWin()) {
                printState();
                printWinMessage();
            }
        }
    }
}