import java.util.*;

public class Main {
    private static final String START = "1";
    private static final String QUIT = "0";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Сыграем в \"Виселицу\"?");
            System.out.printf("Введите %s, если да, или %s, если нет.\n", START, QUIT);
            String response = scanner.nextLine();
            switch (response) {
                case START -> {
                    Game.gameLoop();
                }
                case QUIT -> {
                    System.out.println("До новых встреч!\n");
                    return;
                }
                default -> System.out.println("Вы ввели некорректную команду\n");
            }
        }
    }
}

