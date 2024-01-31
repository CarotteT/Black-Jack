import java.util.Scanner;

public class BlackJackConsole {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BlackJack game = new BlackJack();

        System.out.println("Welcome to the BlackJack table. Let's play!");
        try {
            System.out.println("The bank draw : " + game.getBankHandString() + " : [" + game.getBankBest() + "]");
            System.out.println("You draw : " + game.getPlayerHandString() + " : [" + game.getPlayerBest() + "]");

            while (!game.isGameFinished()) {
                System.out.print("Do you want another card? [y/n]\n");
                String answer = scanner.nextLine();

                if ("y".equalsIgnoreCase(answer)) {
                    game.playerDrawAnotherCard();
                    System.out.println("Your new hand : " + game.getPlayerHandString() + " : " + game.getPlayerBest());
                } else {
                    game.bankLastTurn();
                    System.out.println("The bank draw cards. New hand : " + game.getBankHandString() + " : [" + game.getBankBest() + "]");
                    break;
                }
            }

            System.out.println("Player best : " + game.getPlayerBest());
            System.out.println("Bank best : " + game.getBankBest());

            if (game.isPlayerWinner()) {
                System.out.println("You win!");
            } else if (game.isBankWinner()) {
                System.out.println("The bank wins!");
            } else {
                System.out.println("Draw !");
            }
        } catch (EmptyDeckException e) {
            System.err.println("The deck is empty. The game cannot continue.");
        } finally {
            scanner.close();
        }
    }
}
