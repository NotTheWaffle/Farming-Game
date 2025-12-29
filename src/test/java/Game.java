import java.util.ArrayList;
import java.util.List;

public final class Game {
	public Input input;
	public Output output;
	
	public Deck deck;
	public List<Player> players;
	public int turn;

	public Game(Input input, Output output){
		this.input = input;
		this.output = output;
		this.players = new ArrayList<>();
		this.deck = new Deck();
		this.turn = -1;
	}
	public void update(Input input, Output output){
		this.input = input;
		this.output = output;
	}
	public void addPlayer(String color){
		System.out.println("added"+color);
		if (turn > -1){
			return;
		}
		players.add(new Player(this, 0, color));
	}
	public void start(){
		System.out.println("Roll to determine order");
		int max = 0;
		for (int i = 0; i < players.size(); i++){
			int roll = input.roll();
			if (roll > max){
				turn = i;
				max = roll;
			}
			System.out.println("player "+(i+1)+" rolled a "+roll);
		}
		for (int i = 0; i < players.size(); i++){
			players.get(i).drawOTB();
			players.get(i).drawOTB();
			System.out.println(players.get(i).toString());
		}
	}
	
	public void playTurn(){
		System.out.println("Player "+(turn+1)+"'s turn");
		Player player = players.get(turn);
		output.display(player);
		int roll = input.roll();
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
