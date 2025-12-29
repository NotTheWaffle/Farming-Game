import java.util.function.Function;

public class CardOE extends Card {
	private Function<Player, Integer> getPrice;
	private Integer price;
	public CardOE(){
		this("",0);
	}
	public CardOE(String text, int price){
		this.text = text;
		this.price = price;
		this.getPrice = null;
	}
	public CardOE(String text, Function<Player, Integer> getPrice){
		this.text = text;
		this.getPrice = getPrice;
		this.price = null;
	}
	public void apply(Player player){
		if (price == null){
			player.subMoney(getPrice.apply(player));
		} else {
			player.subMoney(price);
		}
	}
}
