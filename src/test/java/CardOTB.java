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
		switch (item) {
			case Equipment equipment -> {
				// set the effect flags when purchasing a harvester or tractor
				switch (equipment.type) {
					case "Harvester" -> player.effects.harvester = true;
					case "Tractor" -> player.effects.tractor = true;
					default -> System.out.println("bad");
				}
			}
			case Ridge _ -> {
				// remove duplicate ridge otbs
				player.game.deck.remove(this);
				for (Player eachPlayer : player.game.players){
					eachPlayer.otbs.remove(this);
				}
			}
			default -> {}
		}
		player.items.add(item);
		player.otbs.remove(this);
		player.game.deck.insertOTB(this);
	}
	@Override
	public String toString(){
		return "Option to buy "+item+" for $"+cost;
	}
}
