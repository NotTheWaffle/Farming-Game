import java.util.ArrayList;

public class Player {
	public Game game;
	public String color;

	public int position;

	public int cash;
	public int debt;

	public int money;

	public ArrayList<CardOTB> otbs;
	public ArrayList<Effect> effects;
	public ArrayList<Item> items;

	public void addMoney(int amt){
		money += amt;
		if (money>0){
			cash = money;
			debt = 0;
		} else {
			cash = money;
			while (cash < 0){
				cash += 1000;
				debt -= 1000;
			}
		}
	}
	public void subMoney(int amt){
		addMoney(-amt);
	}
	public int totalCows(){
		int totalCows = 0;
		for (Item item : items){
			if (item instanceof Ridge){
				totalCows += ((Ridge) item).capacity;
			} else if (item instanceof CropAcre){
				if (((CropAcre) item).type == Crop.livestock){
					totalCows += ((CropAcre) item).acreage;
				}
			}
		}
		return totalCows;
	}
}
