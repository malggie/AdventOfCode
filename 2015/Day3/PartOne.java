import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String content = getFileContent();
        System.out.println(getUniqueAmount(content));
    }

    private static String getFileContent() {
        String filePath = "C:/Code/text.txt";
        String content = "";
        try {
            content = Files.readString(Paths.get(filePath));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return content;
    }

    private static int getUniqueAmount(String content) {
        int x = 0;
        int y = 0;
        Set<String> visitedHouses = new HashSet<>();
        visitedHouses.add(x + ", " + y);

        for (char c : content.toCharArray()) {
            switch (c) {
                case '^':
                    y += 1;
                    break;
                case '>':
                    x += 1;
                    break;
                case 'v':
                    y -= 1;
                    break;
                case '<':
                    x -= 1;
                    break;
            }
            visitedHouses.add(x + ", " + y);
        }
        return visitedHouses.size();
    }
}