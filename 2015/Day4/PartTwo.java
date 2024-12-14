import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) {

        String secretKey = "iwrupvqb";
        System.out.println(findLowestNumber(secretKey));
    }

    private static int findLowestNumber(String secretKey) {
        int number = 1;
        while (true) {
            String input = secretKey + number;
            String hash = calculateMD5(input);
            if (hash.startsWith("000000")) {
                return number;
            }
            number++;
        }
    }

    private static String calculateMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(input.getBytes());

            StringBuilder hex = new StringBuilder();
            for (byte b : hash) {
                hex.append(String.format("%02x", b));
            }
            return hex.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException();
        }
    }
}