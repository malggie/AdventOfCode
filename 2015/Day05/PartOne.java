import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String filePath = "C:/Code/text.txt";
        ArrayList<String> expressions = getInput(filePath);
        System.out.println(countNiceString(expressions));
    }

    private static ArrayList<String> getInput(String filePath) {
        ArrayList<String> array = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))){
            while (scanner.hasNextLine()) {
                array.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    private static int countNiceString(ArrayList<String> array) {
        int counter = 0;
        for (String word : array) {
            if (word.matches(".*(?:[aeiou].*?){3}.*") && word.matches(".*([a-z])\\1.*")
            && !word.matches(".*(ab|cd|pq|xy).*")) {
                counter++;
            }
        }
        return counter;
    }
}