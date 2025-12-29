public class CardOTB extends Card{
	public final int cost;
	public final Item item;
	public CardOTB(){
		this("",0,new Item());
	}
	public CardOTB(String text, int cost, Item item){
		this.text = text;
		this.cost = cost;
		this.item = item;
	}
	public void apply(Player player){
		if (player.getMoney()-cost < -50_000){
			return;
		}
		player.subMoney(cost);
		if (item instanceof Equipment equipment){
			// set the effect flags when purchasing a harvester or tractor
			if (equipment.type.equals("Harvester")){
				player.effects.harvester = true;
			} else if (equipment.type.equals("Tractor")){
				player.effects.tractor = true;
			} else {
				System.out.println("ABD ABD BABD");
			}
		} else if (item instanceof Ridge ridge){
			// remove duplicate ridge otbs
			player.game.deck.remove(this);
			for (Player eachPlayer : player.game.players){
				eachPlayer.otbs.remove(this);
			}
		}
		player.items.add(item);
		player.otbs.remove(this);
		player.game.deck.insertOTB(this);
	}
	public String getText(){
		return text;
	}
	public String toString(){
		return "Option to buy "+item+" for $"+cost;
	}
}
