import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String content = getFileContent();
        System.out.println(getHouses(content));
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

    private static int getHouses(String content) {
        int santaX = 0;
        int santaY = 0;
        int roboX = 0;
        int roboY = 0;
        Set<String> visitedHouses = new HashSet<>();
        visitedHouses.add("0, 0");

        for (int i = 0; i < content.length(); i++) {
            if (i %2 == 0) {
                int[] newLocation = switchHouses(content.charAt(i), roboX, roboY);
                roboX = newLocation[0];
                roboY = newLocation[1];
                visitedHouses.add(roboX + ", " + roboY);
            }
            else {
                int[] newLocation = switchHouses(content.charAt(i), santaX, santaY);
                santaX = newLocation[0];
                santaY = newLocation[1];
                visitedHouses.add(santaX + ", " + santaY);
            }
        }
        return visitedHouses.size();
    }

    private static int[] switchHouses(char direction, int x, int y) {
        switch (direction) {
            case '^': y += 1; break;
            case '>': x += 1; break;
            case 'v': y -= 1; break;
            case '<': x -= 1; break;
        }
        return new int[] {x, y};
    }
}