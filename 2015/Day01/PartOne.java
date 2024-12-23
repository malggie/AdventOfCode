import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        String content = getFileContent();
        System.out.println(getResult(content));
    }

    private static String getFileContent() {
        String content = "";
        try {
            content = Files.readString(Paths.get("C:/Code/text.txt"));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return content;
    }

    private static int getResult(String content) {
        int floor = 0;
        for (char c : content.toCharArray()) {
            if (c == '(') {
                floor++;
            }
            else {
                floor--;
            }
        }
        return floor;
    }
}
