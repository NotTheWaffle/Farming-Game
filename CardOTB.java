
// option to buy

public class CardOTB extends Card{
	public int cost;
	public Item item;
	public CardOTB(){
		this("",0,new Item());
	}
	public CardOTB(String text, int cost, Item item){
		this.text = text;
		this.cost = cost;
		this.item = item;
	}
	public void apply(Player player){
		player.subMoney(cost);
		player.items.add(item);
	}
}
