import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        String filePath = "C:/Code/text.txt";
        List<String> input = getInput(filePath);

        BoardInitialization board = new BoardInitialization(input);
        System.out.println(board.getSignal("a"));
    }

    private static List<String> getInput(String filePath) {
        List<String> array = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                array.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }
}
