import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        String content = getFileContent();
        System.out.println(getResult(content) + 1);
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
        for (int i = 0; i < content.length(); i++) {
           if (content.charAt(i) == ')') {
               floor--;
               if (floor < 0) {
                   return i;
               }
           }
           else {
               floor++;
           }
        }
        return floor;
    }
}
