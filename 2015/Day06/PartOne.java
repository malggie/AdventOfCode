import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean lights[][] = new boolean[1000][1000];
        String filePath = "C:/Code/text.txt";
        ArrayList<String> input = getInput(filePath);

        for (String element : input) {
            getLightsState(element, lights);
        }

        System.out.println(countLights(lights));
    }

    private static ArrayList<String> getInput(String filePath) {
        ArrayList<String> array = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                array.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    private static void getLightsState(String input, boolean[][] lights) {
        String[] elements = input.split(" ");

        String[] partOne = elements[elements.length - 3].split(",");
        String[] partTwo = elements[elements.length - 1].split(",");

        int startX = Integer.parseInt(partOne[0]);
        int startY = Integer.parseInt(partOne[1]);
        int endX = Integer.parseInt(partTwo[0]);
        int endY = Integer.parseInt(partTwo[1]);

        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (input.contains("toggle")) {
                    lights[i][j] = !lights[i][j];
                } else if (input.contains("on")) {
                    lights[i][j] = true;
                } else if (input.contains("off")) {
                    lights[i][j] = false;
                }
            }
        }
    }

    private static int countLights(boolean[][] lights) {
        int counter = 0;
        for (int i = 0; i < lights.length - 1; i++) {
            for (int j = 0; j < lights[i].length - 1; j++) {
                if (lights[i][j] == true) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
