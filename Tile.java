import java.util.function.Consumer;

public class Tile {
	public final String text;
	private final Consumer<Player> action;
	public Tile(String text, Consumer<Player> action){
		this.text = text;
		this.action = action;
	}
	public Tile(String text, int money){
		this.text = text;
		this.action = (player) -> player.addMoney(money);
	}
	public void apply(Player player){
		action.accept(player);
	}
}
