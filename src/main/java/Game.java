import java.util.*;

public class Game {
    static final int NUMBER_OF_MISTAKE = 6;
    static int counterOfMistake;

    public static boolean inputLetterIsCorrect(String s) {
        if (s.length() == 1) {
            char letter = s.charAt(0);
            if ((letter >= 'а' && letter <= 'я') || (letter >= 'А' && letter <= 'Я')) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    static boolean wordIsGuessed(char[] array) {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != '*') {
                counter++;
            }
        }
        if (counter == array.length) {
            return true;
        } else {
            return false;
        }
    }

    static char[] makeSecretWord(String word) {
        char[] charsOfWord = word.toCharArray();
        char[] wordWithStars = new char[charsOfWord.length]; // array to display the word with '*'
        for (int i = 0; i < wordWithStars.length; i++) {
            wordWithStars[i] = '*';
        }
        return wordWithStars;
    }

    static char readLetter () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите только одну букву русского алфавита");
        System.out.println();
        String attemptGuess = sc.nextLine();
        attemptGuess = attemptGuess.toLowerCase();
        char letter = '0';
        if (Game.inputLetterIsCorrect(attemptGuess)) {
            letter = attemptGuess.charAt(0);
        }
        return letter;
    }

    static boolean enterLetterAgain(char symbol, ArrayList <String> list) {

        if (list.contains(String.valueOf(symbol))) {
            return true;
        } else {
            list.add(String.valueOf(symbol));
            return false;
        }
    }

    static boolean letterFound(char symbol, char[] array, char[] secretArray) {
        int placeOfLetter;
        boolean found = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == symbol) {
                placeOfLetter = i;
                secretArray[placeOfLetter] = symbol;
                found= true;
            }
        }
        return found;
    }

    static void printState(char[] secretWord, ArrayList<String> list) {
        for (char symbol : secretWord) {
            System.out.print(symbol);
        }
        System.out.println();
        System.out.println("Допущено ошибок:" + counterOfMistake);
        System.out.println("Осталось ошибок:" + (NUMBER_OF_MISTAKE - counterOfMistake));
        System.out.println("Список букв, которые уже были введены:");
        for (String letters : list) {
            System.out.print(letters + " ");
        }
        System.out.println();
        PrintHangman.draw(counterOfMistake);
    }

    static void gameLoop() {
        counterOfMistake = 0;
        String wordForGuess = ChoiceOfWord.randomWord();
        //System.out.println(wordForGuess);
        char[] charsOfWord = wordForGuess.toCharArray();
        char[] wordWithStars = makeSecretWord(wordForGuess);
        ArrayList <String> listOfWrongLetters = new ArrayList<>();

        while (!wordIsGuessed(wordWithStars)) {
            char letter = readLetter();
            if (letter == '0') {
                System.out.println("Вы ввели некорректный символ или ввели несколько букв подряд\n");
                continue;
            }

            boolean again;
            if (enterLetterAgain(letter, listOfWrongLetters)) {
                System.out.println("Эта буква уже была введена, попробуйте ввести другую букву");
                again = true;
                continue;
            } else {
                again = false;
            }

            if (!letterFound(letter, charsOfWord, wordWithStars) && !again) {
                counterOfMistake++;
            }

            printState(wordWithStars, listOfWrongLetters);

            if (counterOfMistake == NUMBER_OF_MISTAKE) {
            System.out.println("Вы проиграли.\nБыло загадано слово: " + wordForGuess);
            System.out.println();
            return;
            }
            if (wordIsGuessed(wordWithStars)) {
            System.out.println("Вы выиграли! Поздравляю!!!\n");
            }

        }
    }
}
//
//static void gameLoop() {
//    String wordForGuess = ChoiceOfWord.randomWord();
//    System.out.println(wordForGuess);
//    char[] charsOfWord = wordForGuess.toCharArray();
//    char[] wordWithStars = new char[charsOfWord.length]; // array to display the word with '*'
//    for (int i = 0; i < wordWithStars.length; i++) {
//        wordWithStars[i] = '*';
//    }
//    Scanner sc = new Scanner(System.in);
//    System.out.println("Введите только одну букву русского алфавита");
//    System.out.println();
//    while (!wordIsGuessed(wordWithStars)) {
//        String attemptGuess = sc.nextLine();
//        char letter;
//        int placeOfLetter;
//        if (Game.inputLetterIsCorrect(attemptGuess)) {
//            letter = attemptGuess.charAt(0);
//        } else {
//            System.out.println("Вы ввели некорректный символ или ввели несколько букв подряд\n");
//            continue;
//        }
//        boolean foundLetter = false;
//        String wrongLetter = "";
//        ArrayList<String> listOfWrongLetters = new ArrayList<>();
//        for (int i = 0; i < charsOfWord.length; i++) {
//            if (charsOfWord[i] == letter) {
//                placeOfLetter = i;
//                wordWithStars[placeOfLetter] = letter;
//                foundLetter = true;
//            }
//        }
//        if (!foundLetter) {
//            counterOfMistake++;
//        }
//        for (char symbol : wordWithStars) {
//            System.out.print(symbol);
//        }
//        System.out.println();
//        System.out.println("Допущено ошибок:" + counterOfMistake);
//        System.out.println("Осталось ошибок:" + (NUMBER_OF_MISTAKE - counterOfMistake));
//        PrintHangman.draw(counterOfMistake);
//        if (counterOfMistake == NUMBER_OF_MISTAKE) {
//            System.out.println("Вы проиграли.\nБыло загадано слово: " + wordForGuess);
//            System.out.println();
//            return;
//        }
//        if (wordIsGuessed(wordWithStars)) {
//            System.out.println("Вы выиграли! Поздравляю!!!\n");
//        }
//    }
//}
