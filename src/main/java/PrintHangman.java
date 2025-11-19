public class PrintHangman {
    public static void draw(int countOfErrors) {
        String[] positions = {
                "          +---+\n" +
                        "          |   |\n" +
                        "              |\n" +
                        "              |\n" +
                        "              |\n" +
                        "              |\n" +
                        "        =========",
                "          +---+\n" +
                        "          |   |\n" +
                        "          O   |\n" +
                        "              |\n" +
                        "              |\n" +
                        "              |\n" +
                        "        =========",
                "          +---+\n" +
                        "          |   |\n" +
                        "          O   |\n" +
                        "          |   |\n" +
                        "              |\n" +
                        "              |\n" +
                        "        =========",
                "          +---+\n" +
                        "          |   |\n" +
                        "          O   |\n" +
                        "         /|   |\n" +
                        "              |\n" +
                        "              |\n" +
                        "        =========",
                "          +---+\n" +
                        "          |   |\n" +
                        "          O   |\n" +
                        "         /|\\  |\n" +
                        "              |\n" +
                        "              |\n" +
                        "        =========",
                "          +---+\n" +
                        "          |   |\n" +
                        "          O   |\n" +
                        "         /|\\  |\n" +
                        "         /    |\n" +
                        "              |\n" +
                        "        =========",
                "          +---+\n" +
                        "          |   |\n" +
                        "          O   |\n" +
                        "         /|\\  |\n" +
                        "         / \\  |\n" +
                        "              |\n" +
                        "        ========="
        };
        switch (countOfErrors) {
            case 0, 1, 2, 3, 4, 5, 6 -> System.out.println(positions[countOfErrors]);
            default -> System.out.println("Некорректное значение");
        }

        }

    }


