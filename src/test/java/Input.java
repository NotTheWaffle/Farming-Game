import java.util.Scanner;

public class Input {
	public int roll(){
		//just tell the player and pause the game to make sure they know its rolling
		return Game.roll();
	}
	public int choice(){
		Scanner scan = new Scanner(System.in);
		System.out.println("choice (int)");
		return scan.nextInt();
	}
	public String color(){
		return "racist cow";
	}
}
