public class PictureOfHangman {
    private static final String[] PICTURES = {
            """
   +-----+
   |     |
         |
         |
         |
         |
   =========
""",
            """
   +-----+
   |     |
   0     |
         |
         |
         |
   =========
""",
            """
   +-----+
   |     |
   0     |
   |     |
         |
         |
   =========
""",
            """
   +-----+
   |     |
   0     |
  /|     |
         |
         |
   =========
""",
            """
   +-----+
   |     |
   0     |
  /|\\    |
         |
         |
   =========
""",
            """
   +-----+
   |     |
   0     |
  /|\\    |
  /      |
         |
   =========
""",
            """
   +-----+
   |     |
   0     |
  /|\\    |
  / \\    |
         |
   =========
"""
    };

    static void draw(int countOfErrors) {
        String picture = PICTURES[countOfErrors];
        System.out.println(picture);

        }
}


