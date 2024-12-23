import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> array = getFileContent();
        System.out.println(calculateRibbonNeeded(array));
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

    private static int calculateRibbonNeeded(ArrayList<String> array) {
        int ribbonNeeded = 0;
        for (String s : array) {
            String[] temp = s.split("x");
            int one = Integer.parseInt(temp[0]);
            int two = Integer.parseInt(temp[1]);
            int three = Integer.parseInt(temp[2]);
            ribbonNeeded += ribbonArea(one, two, three);
        }
        return ribbonNeeded;
    }

    private static int ribbonArea(int l, int w, int h) {
        int[] array = {l, w, h};
        Arrays.sort(array);
        return 2 * array[0] + 2 * array[1] + array[0] * array[1] * array[2];
    }
}