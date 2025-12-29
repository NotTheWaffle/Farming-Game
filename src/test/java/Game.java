import java.util.ArrayList;
import java.util.List;

public final class Game {
	public static final int[] cashDenominations = {50,100,500,1000,5000,10_000};
	public static final int[] debtDenominations = {1000,5000,10_000};
	public Input input;
	public Output output;
	public Deck deck;
	public List<Player> players;
	public int turn;

	public Game(Input input, Output output){
		System.out.println("Making a game with "+input+" and "+output);
		this.input = input;
		this.output = output;
		this.players = new ArrayList<>();
		this.deck = new Deck();
		this.turn = -1;
	}
	public void addPlayer(String color){
		System.out.println("added"+color);
		if (turn > -1){
			return;
		}
		players.add(new Player(this, 0, color));
	}
	public void start(){
		output.display("Roll to determine turn order");
		int max = 0;
		for (int i = 0; i < players.size(); i++){
			int roll = input.roll();
			if (roll > max){
				turn = i;
				max = roll;
			}
			output.display(players.get(i));
			output.display(roll);
		}
		for (int i = 0; i < players.size(); i++){
			players.get(i).drawOTB();
			players.get(i).drawOTB();
			output.display(players.get(i));
		}
	}
	
	public void playTurn(){
		Player player = players.get(turn);
		output.display(player);
		int roll = input.roll();
		output.display(roll);
		player.moveTo(player.position+roll,true);
		turn = (turn+1)%players.size();
	}
	
	public static int roll(){
		return (int)(Math.random()*6)+1;
	}

	@Override
	public String toString(){
		StringBuilder outstr = new StringBuilder();
		outstr.append(players.size()).append(" player game").append(players);
		return outstr.toString();
	}
}
