import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean play = true;
        while (play) {
            System.out.println("Сыграем в \"Виселицу\"?");
            System.out.println("Введите 1, если да, или 0, если нет.\n");
            String response = scanner.nextLine();
            switch (response) {
                case "1" -> {
                    for (int i = 0; i<35; i++) System.out.println();
                    Game.gameLoop();
                }
                case "0" -> {
                    System.out.println("До новых встреч!\n");
                    play = false;
                    return;
                }
                default -> System.out.println("Вы ввели некорректную команду\n");
            }
        }
    }
}

