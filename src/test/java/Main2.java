import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Game game = new Game(null, null);
		Window window = new Window(game, 1600, 1000);
		game.update(new Output() {
			public void display(Tile tile){update();}
			public void display(Card card){update();}
			public void display(String string){update();}
			public void display(int roll){update();}
			public void display(Player player){update();}
			public void update(){window.render();}
		});
		game.update(new Input() {
			public final Scanner scan = new Scanner(System.in);
			public int roll(){return Game.roll();}
			public int choice(int max){
				int value = -1;
				while (value < 0 || value > max){
					System.out.println("0-"+max);
					String line = scan.nextLine();
					try {value = Integer.parseInt(line);}catch(Exception _){}
				}
				return value;
			}
			public String toString(){return "Text input";}
		});
		game.addPlayer("red");
		game.addPlayer("blue");
		game.start();
		game.playTurn();
	}
}
