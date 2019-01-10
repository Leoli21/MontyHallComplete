import java.util.Random;
import java.util.Scanner;

public class MontyHallPart3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		int numGames;
		System.out.println("How many rounds of the game should be simulated: ");
		numGames = input.nextInt();
		while (numGames < 10 || numGames > 10000)
		{
			System.out.println("Must enter number between 10 and 10000");
			System.out.println("How many rounds of the game should be simulated: ");
			numGames = input.nextInt();
		}
		System.out.println("Should the player switch or stay? ");
		String switchStay = input.nextLine();
		while (!(switchStay.equals("switch") || switchStay.equals("stay")))
		{
			System.out.println("Must enter either switch or stay");
			System.out.println("Should the player switch or stay?");
			switchStay = input.nextLine();
		}
		
		double win = 0;
		for (int i = 1; i <= numGames; i++)
		{
			int winDoor, userDoor, goatDoor, switchDoor;
			winDoor = rand.nextInt(3) + 1;
			goatDoor = 0;
			switchDoor = 0;
			userDoor = rand.nextInt(3) + 1;
			
			if (switchStay.equals("switch"))
			{
				if (userDoor == winDoor)
				{
					if (userDoor == 1)
					{
						goatDoor = 2;
						switchDoor = 3;
						userDoor = switchDoor;
						if (switchDoor == winDoor)
						{
							win += 1;
						}
							
					}
					else if (userDoor == 2)
					{
						goatDoor = 3;
						switchDoor = 1;
						userDoor = switchDoor;
						if (switchDoor == winDoor)
						{
							win += 1;
						}
					}
					else
					{
						goatDoor = 1;
						switchDoor = 2;
						userDoor = switchDoor;
						if (switchDoor == winDoor)
						{
							win += 1;
						}
						
					}
				}
				else
				{
					if (userDoor == 1 && winDoor == 2)
					{
						goatDoor = 3;
						switchDoor = 2;
						userDoor = switchDoor;	
						if (switchDoor == winDoor)
						{
							win += 1;
						}
					}
					else if (userDoor == 1 && winDoor == 3)
					{
						goatDoor = 2;
						switchDoor = 3;
						userDoor = switchDoor;	
						if (switchDoor == winDoor)
						{
							win += 1;
						}
					}
					else if (userDoor == 2 && winDoor == 1)
					{
						goatDoor = 3;
						switchDoor = 1;
						userDoor = switchDoor;	
						if (switchDoor == winDoor)
						{
							win += 1;
						}
					}
					else if (userDoor == 2 && winDoor == 3)
					{
						goatDoor = 1;
						switchDoor = 3;
						userDoor = switchDoor;	
						if (switchDoor == winDoor)
						{
							win += 1;
						}
					}
					else if (userDoor == 3 && winDoor == 1)
					{
						goatDoor = 2;
						switchDoor = 1;
						userDoor = switchDoor;
						if (switchDoor == winDoor)
						{
							win += 1;
						}
					}
					else if (userDoor == 3 && winDoor == 2)
					{
						goatDoor = 1;
						switchDoor = 2;
						userDoor = switchDoor;
						if (switchDoor == winDoor)
						{
							win += 1;
						}
					}

				}
				
			}
			else if (switchStay.equals("stay"))
			{
				if (userDoor == winDoor)
				{
					win += 1;
				}

			}			
		}
		double winPercent = win/numGames * 100;
		System.out.println("The player won " + win + "/" + numGames + " games (" + winPercent + "%)!");
	}
}

