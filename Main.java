public class Main {
	public static void main(String[] args) {
		Game game = new Game();
		game.addPlayer("Red");
		game.addPlayer("Stupid");
		game.start();
		game.playTurn();
	}
}
