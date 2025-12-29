import java.util.ArrayList;
import java.util.List;

public class Player {
	public Game game;
	public String color;

	public int position;

	public int cash;
	public int debt;

	public int money;

	public List<CardOTB> otbs;
	public List<Effect> effects;
	public List<Item> items;

	public Player(){
		this(null,0,"Colorless");
	}
	public Player(Game game, int money, String color){
		this.game = game;
		this.cash = 0;
		addMoney(money);
		this.color = color;
		this.otbs = new ArrayList<>();
		this.effects = new ArrayList<>();
		this.items = new ArrayList<>();
	}

	public int getMoney(){
		return cash-debt;
	}
	public String getMoneyString(){
		if (debt == 0){
			return "$"+cash;
		}
		if (cash == 0){
			return "$-"+debt;
		}
		return "$"+cash+"-"+debt;
	}
	public void addMoney(int amt){
		money += amt;
		if (money > 0){
			cash = money;
			debt = 0;
		} else {
			cash = money;
			while (cash < 0){
				cash += 1000;
				debt += 1000;
			}
		}
	}
	public void subMoney(int amt){
		addMoney(-amt);
	}
	public int totalCows(){
		int totalCows = 0;
		for (Item item : items){
			if (item instanceof Ridge ridge){
				totalCows += ridge.capacity;
			} else if (item instanceof CropAcre cropAcre){
				if (cropAcre.type == Crop.livestock){
					totalCows += cropAcre.acreage;
				}
			}
		}
		return totalCows;
	}
	public int totalCrop(Crop crop){
		int totalFruit = 0;
		for (Item item : items){
			if (item instanceof CropAcre cropAcre){
				if (cropAcre.type == crop){
					totalFruit += cropAcre.acreage;
				}
			}
		}
		return totalFruit;
	}
	public void drawOTB(){
		this.otbs.add(game.deck.drawOTB());
	}
	public void drawFF(){
		game.deck.drawFF().apply(this);
	}
	public String toString(){
		return color+" player: "+getMoneyString()+"\n Items:"+items+"\n OTBs :"+otbs;
	}
}
