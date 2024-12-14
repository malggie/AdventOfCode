import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        ArrayList<String> array = getFileContent();
        System.out.println(calculatePaperNeeded(array));
    }

    private static ArrayList<String> getFileContent() {
        String filePath = "C:/Code/text.txt";
        ArrayList<String> array = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                array.add(scanner.nextLine());
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return array;
    }

    private static int calculatePaperNeeded(ArrayList<String> array) {
        int paperNeeded = 0;
        for (String s : array) {
            String[] temp = s.split("x");
            int one = Integer.parseInt(temp[0]);
            int two = Integer.parseInt(temp[1]);
            int three = Integer.parseInt(temp[2]);
            paperNeeded += surfaceArea(one, two, three);
        }
        return paperNeeded;
    }

    private static int surfaceArea(int l, int w, int h) {
        int[] array = {l, w, h};
        Arrays.sort(array);
        return 2 * l * w + 2 * w * h + 2 * h * l + array[0] * array[1];
    }
}