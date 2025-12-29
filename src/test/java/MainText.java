import java.util.Scanner;

public class MainText {
	public static void main(String[] args){
		Game game = new Game(
			new Input() {
				public int roll(){return Game.roll();}
				public int choice(int max){
					Scanner scan = new Scanner(System.in);
					int value = -1;
					while (value < 0 || value > max){
						System.out.println("0-"+max);
						String line = scan.nextLine();
						try {value = Integer.parseInt(line);}catch(Exception e){}
					}
					scan.close();
					return value;
				}
				public String toString(){return "Text input";}
			},
			new Output(){
				public void display(Tile tile){System.out.println(tile.toString());}
				public void display(Card card){System.out.println(card.toString());}
				public void display(String string){System.out.println(string);}
				public void display(int roll){System.out.println("Rolled a "+roll);}
				public void display(Player player){System.out.println(player.toString());}
				public String toString(){return "Text output";}
			}
		);
		game.addPlayer("Red");
		game.addPlayer("Blue");
		game.start();
		game.playTurn();
	}
}