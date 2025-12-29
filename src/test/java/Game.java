import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
	public Deck deck;
	public Board board;
	public Player[] players;
	public List<String> colors;
	public int playerCount;
	public int turn;

	public Game(){
		this.deck = new Deck();
		this.colors = new ArrayList<>();
		this.playerCount = 0;
		this.turn = -1;
	}
	public void addPlayer(String color){
		colors.add(color);
		playerCount++;
	}
	public void start(){
		players = new Player[playerCount];
		for (int i = 0; i < playerCount; i++){
			players[i] = new Player(this, 0, colors.get(i));
		}
		System.out.println("Roll to determine turn order");
		int max = 0;
		for (int i = 0; i < playerCount; i++){
			int roll = roll();
			if (roll > max){
				turn = i;
				max = roll;
			}
			System.out.println("Player "+(i+1)+" rolled a "+roll);
		}
		for (int i = 0; i < playerCount; i++){
			players[i].drawOTB();
			players[i].drawOTB();
			System.out.println(players[i]);
		}
	}
	
	public void playTurn(){
		System.out.println("Player "+(turn+1)+"\'s turn");
		Player player = players[turn];
		int roll = roll();
		System.out.println(player.color+" player rolled a "+roll);
		player.position += roll;
		//TODO find board size
		if (player.position > 40){
			
		}
	}
	public static int roll(){
		return (int)(Math.random()*6)+1;
	}

	@Override
	public String toString(){
		StringBuilder output = new StringBuilder();
		output.append(playerCount).append(" player game").append(Arrays.toString(players));
		return output.toString();
	}
}
