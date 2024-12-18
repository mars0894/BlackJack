import java.util.Scanner;

public class BlackJackConsole
{
	public BlackJackConsole()
	{
		System.out.println("Welcome to the BlackJack table. Let's play !");
		BlackJack blackjack = new BlackJack();
		System.out.println("The bank draw : "+blackjack.getBankHandString());
		System.out.println("Your draw : "+blackjack.getPlayerHandString());
		Scanner sc = new Scanner(System.in);
		while(!(blackjack.isGameFinished()))
		{
			System.out.println("Do you want another card ? [y/n]");
			String str = sc.nextLine();
			char answer = str.charAt(0);
			if(answer == 'y')
			{
				try
				{
					blackjack.playerDrawAnotherCard();
					System.out.println("Your new hand : "+blackjack.getPlayerHandString());
				}
				catch(EmptyDeckException ex)
				{
					System.err.println(ex.getMessage());
					System.exit(-1);
				}

			}
			else if(answer == 'n')
			{
				try
				{
					blackjack.bankLastTurn();
					System.out.println("The bank draw card. New hand : "+ blackjack.getBankHandString());
				}
				catch(EmptyDeckException ex)
				{
					System.err.println(ex.getMessage());
					System.exit(-1);
				}
			}
			else
				System.out.println("Wrong type, please enter y or n");
		}
		System.out.println("Player best : "+blackjack.getPlayerBest());
		System.out.println("Bank best : "+blackjack.getBankBest());
		if(blackjack.isPlayerWinner())
			System.out.println("You won !");
		else if(blackjack.isBankWinner())
			System.out.println("The bank won !");
		else
			System.out.println("Draw !");

	}
}