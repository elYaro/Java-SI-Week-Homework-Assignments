import java.util.Scanner;

public class RandomNumber {
    public static void main(String[] args) {
        int random = (int) ((Math.random() * 100) + 1);
        boolean gameWon = false;
        System.out.println("I have generated random number between 1 and 100 (included).\nTry to guess this number. You have 10 chances.\nType you guess and hit enter key:");
        Scanner scanner = new Scanner(System.in);
        for (int i = 10; i > 0; i--) {
            int guess = scanner.nextInt();
            if (guess > random) {
                System.out.println("The number is smaller then this");
            } else if (guess < random) {
                System.out.println("The number is bigger then this");
            } else {
                gameWon = true;
                break;
            }
        }
        if (gameWon) {
            System.out.println("Congrats. You WIN!!!");
        } else {
            System.out.println("You loose. You run out of tries:(");
        }
    }
}
