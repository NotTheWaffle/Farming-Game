import java.util.ArrayList;
import java.util.List;

public class Game {
	public Input input;
	public Output output;
	public Deck deck;
	public Board board;
	public List<Player> players;
	public int turn;

	public Game(Input input, Output output){
		this.input = input;
		this.output = output;
		this.players = new ArrayList<>();
		this.deck = new Deck();
		this.turn = -1;
	}
	public void addPlayer(String color){
		players.add(new Player(this, 0, color));
	}
	public void start(){
		System.out.println("Roll to determine turn order");
		int max = 0;
		for (int i = 0; i < players.size(); i++){
			int roll = input.roll();
			if (roll > max){
				turn = i;
				max = roll;
			}
			System.out.println("Player "+(i+1)+" rolled a "+roll);
		}
		for (int i = 0; i < players.size(); i++){
			players.get(i).drawOTB();
			players.get(i).drawOTB();
			System.out.println(players.get(i));
		}
	}
	
	public void playTurn(){
		output.display("Player "+(turn+1)+"\'s turn");
		Player player = players.get(turn);
		int roll = input.roll();
		
		output.display(player.color+" player rolled a "+roll);
		player.moveTo(player.position+roll,true);
	}
	public static int roll(){
		return (int)(Math.random()*6)+1;
	}

	@Override
	public String toString(){
		StringBuilder output = new StringBuilder();
		output.append(players.size()).append(" player game").append(players);
		return output.toString();
	}
}
