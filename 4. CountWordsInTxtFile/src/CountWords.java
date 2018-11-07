import java.util.Scanner;
import java.io.File;

public class CountWords {
    public static void main (String [] args) throws Exception {
        File file = new File("LoremIpsum_10000words.txt");
        Scanner scanner = new Scanner(file);
        int wordsCounter = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            wordsCounter += (line.split(" ").length);
        }
        System.out.printf("Total number of words in the txt file is : %s",(wordsCounter));
        }
    }

