import java.util.function.Consumer;

public class CardFF extends Card{
	private Consumer<Player> action;
	public CardFF(){
		this("",(Player -> {}));
	}
	public CardFF(String text, Consumer<Player> apply){
		this.text = text;
		this.action = apply;
	}
	public void apply(Player player){
		action.accept(player);
	}
}
