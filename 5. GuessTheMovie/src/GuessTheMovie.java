import java.util.Scanner;
import java.io.File;



public class GuessTheMovie {
    public static void main(String[] args) throws Exception {
        //variables:
        int i = 0;  //while loop iteration
        String title = "";   // randomly selected title
        String hiddenTitle = "";
        String tempHiddenTitle = "";
        char[] correctUserChoicesArray = new char[30];
        char[] wrongUserChoicesArray = new char[10];
        boolean isLetterInTitle;
        int turnsLeft = 10;
        int letterCorrectIndex = 0;
        int letterWrongIndex = 0;

        // pick up random title and print it
        int randomIndex = (int) ((Math.random() * 25) - 1);

        // use Scanner object to read txt file
        File file = new File("MoviesTitleList.txt");
        Scanner scanner = new Scanner(file);

        // welcome message and instructions for user
        System.out.println("----------------------------------------------");
        System.out.println("WELCOME TO THE \"GUESS THE MOVIE TITLE\" GAME");
        System.out.println("----------------------------------------------");
        System.out.println("I have randomly generated the movie title.\n" +
                "Try to guess that title in 10 rounds. \n\n");

        // while loop to get the title with index [i] == randomly created number "index" (from 0 till title.length)
        while (scanner.hasNextLine()) {
            title = scanner.nextLine();
            if (i == randomIndex) {
                break;
            }
            i++;
        }

        // creating the hidden title based on the selected title
        for (i = 0; i < title.length(); i++) {
            if (title.charAt(i) != ' ') {
                hiddenTitle += '*';
            } else {
                hiddenTitle += ' ';
            }
        }
        System.out.println("The \"*\" represent a letter or digit of the hidden title.\n");
        System.out.println(hiddenTitle + "\n");

        isLetterInTitle = false;
        while (turnsLeft > 0) {
            //get user input from user
            System.out.printf("Enter the letter or digit and hit Enter key.\nYou have %s rounds left:\n ", turnsLeft);
            Scanner userInput = new Scanner(System.in);
            char userChoice = userInput.nextLine().charAt(0);

            //check if the user input exist in the selected title and add chosen letter to correct char array
            for (i = 0; i < title.length(); i++)
                if (title.charAt(i) == userChoice) {
                    isLetterInTitle = true;
                    System.out.println("letter present in the hidden title");
                    break;
                } else {
                    isLetterInTitle = false;
                }

            // adds correct/wrong letter to one of arrays
            if (isLetterInTitle) {
                correctUserChoicesArray[letterCorrectIndex] = userChoice;
                letterCorrectIndex++;
            } else {
                wrongUserChoicesArray[letterWrongIndex] = userChoice;
                letterWrongIndex++;
                turnsLeft--;
            }

            //updates hidden title based on the input given
            for (i = 0; i < title.length(); i++) {
                if (title.charAt(i) == hiddenTitle.charAt(i) || title.charAt(i) == userChoice) {
                    tempHiddenTitle += title.charAt(i);
                } else {
                    tempHiddenTitle += '*';
                }
            }
            hiddenTitle = tempHiddenTitle;
            tempHiddenTitle = "";
            System.out.println(hiddenTitle);

            // check for WIN condition
            if (!hiddenTitle.contains("*")) {
                System.out.println("You WIN");
                break;
            }

            //checks for loose condition
            if (turnsLeft == 0) {
                System.out.println("You loose. Tra again");
            }
        }
    }
}






