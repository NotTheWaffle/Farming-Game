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
	public Effect effects;
	public List<Item> items;

	public String lastHarvest;

	public Player(){
		this(null,0,"Colorless");
	}
	public Player(Game game, int money, String color){
		this.game = game;
		this.cash = 0;
		addMoney(money);
		this.color = color;
		this.otbs = new ArrayList<>();
		this.effects = new Effect();
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
	public int acreage(){
		return acreage(Crop.hay)+acreage(Crop.grain)+acreage(Crop.fruit);
	}
	public int acreage(Crop crop){
		if (crop == Crop.livestock){
			return totalCows();
		}
		int totalCrop = 0;
		for (Item item : items){
			if (item instanceof CropAcre cropAcre){
				if (cropAcre.type == crop){
					totalCrop += cropAcre.acreage;
				}
			}
		}
		return totalCrop;
	}
	
	public boolean has(Item item){
		for (Item token : items){
			if (token.equals(item)){
				return true;
			}
		}
		return false;
	}
	
	public void drawOTB(){
		this.otbs.add(game.deck.drawOTB());
	}
	public void drawFF(){
		game.deck.drawFF().apply(this);
	}
	public void moveTo(int position, boolean forward){
		position = position%49;
		if (forward && position < this.position){
			addMoney(5000);
			effects = new Effect();
		}
		this.position = position;
		game.output.display(game.board.board[position]);
		game.board.board[position].apply(this);
	}
	
	public String toString(){
		return color+" player: "+getMoneyString()+"\n Items:"+items+"\n OTBs :"+otbs;
	}
}
