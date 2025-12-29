import java.util.ArrayList;
import java.util.List;

public class Deck {
	private List<CardOTB> deckOTB;
	private List<CardFF> deckFF;
	private List<CardOE> deckOE;

	public Deck(){
		initDeckOTB();
		shuffle(deckOTB);
		initDeckFF();
		shuffle(deckFF);
		initDeckOE();
		shuffle(deckOE);
	}
	private <E> void shuffle(List<E> list){
		List<E> list2 = new ArrayList<>();
		while (!list.isEmpty()){
			list2.add(list.remove((int)(list.size()*Math.random())));
		}
		list.addAll(list2);
	}
	private void initDeckOTB(){
		deckOTB = new ArrayList<>();
		deckOTB.add(new CardOTB("NEIGHBOR GOES BROKE\n5 acres Fruit\nat $5,000 per acre\nTotal $25,000",25_000,new CropAcre(Crop.fruit, 5)));
		deckOTB.add(new CardOTB("NEIGHBOR GOES BROKE\n5 acres Fruit\nat $5,000 per acre\nTotal $25,000",25_000,new CropAcre(Crop.fruit, 5)));
		deckOTB.add(new CardOTB("NEIGHBOR GOES BROKE\n5 acres Fruit\nat $5,000 per acre\nTotal $25,000",25_000,new CropAcre(Crop.fruit, 5)));
		deckOTB.add(new CardOTB("NEIGHBOR GOES BROKE\n5 acres Fruit\nat $5,000 per acre\nTotal $25,000",25_000,new CropAcre(Crop.fruit, 5)));

		deckOTB.add(new CardOTB("NEIGHBOR SELLS OUT\n10 acres Grain\nat $2,000 per acre\nTotal $20,000",20_000,new CropAcre(Crop.grain, 10)));
		deckOTB.add(new CardOTB("NEIGHBOR SELLS OUT\n10 acres Grain\nat $2,000 per acre\nTotal $20,000",20_000,new CropAcre(Crop.grain, 10)));
		deckOTB.add(new CardOTB("NEIGHBOR SELLS OUT\n10 acres Grain\nat $2,000 per acre\nTotal $20,000",20_000,new CropAcre(Crop.grain, 10)));
		deckOTB.add(new CardOTB("NEIGHBOR SELLS OUT\n10 acres Grain\nat $2,000 per acre\nTotal $20,000",20_000,new CropAcre(Crop.grain, 10)));
		deckOTB.add(new CardOTB("NEIGHBOR SELLS OUT\n10 acres Grain\nat $2,000 per acre\nTotal $20,000",20_000,new CropAcre(Crop.grain, 10)));
		
		deckOTB.add(new CardOTB("NEIGHBOR SELLS OUT\n10 acres Hay\nat $2,000 per acre\nTotal $20,000",20_000,new CropAcre(Crop.hay, 10)));
		deckOTB.add(new CardOTB("NEIGHBOR SELLS OUT\n10 acres Hay\nat $2,000 per acre\nTotal $20,000",20_000,new CropAcre(Crop.hay, 10)));
		deckOTB.add(new CardOTB("NEIGHBOR SELLS OUT\n10 acres Hay\nat $2,000 per acre\nTotal $20,000",20_000,new CropAcre(Crop.hay, 10)));
		deckOTB.add(new CardOTB("NEIGHBOR SELLS OUT\n10 acres Hay\nat $2,000 per acre\nTotal $20,000",20_000,new CropAcre(Crop.hay, 10)));
		
		deckOTB.add(new CardOTB("Lease\nAhtanum Ridge\nfor lifetime at $10,000\nand buy 20 cows\nat $500 each\nTotal $20,000",20_000,new Ridge("Ahtanum Ridge",20)));
		deckOTB.add(new CardOTB("Lease\nAhtanum Ridge\nfor lifetime at $10,000\nand buy 20 cows\nat $500 each\nTotal $20,000",20_000,new Ridge("Ahtanum Ridge",20)));

		deckOTB.add(new CardOTB("Lease\nRattlesnake Ridge\nfor lifetime at $15,000\nand buy 30 cows\nat $500 each\nTotal $30,000",30_000,new Ridge("Rattlesnake Ridge",30)));
		deckOTB.add(new CardOTB("Lease\nRattlesnake Ridge\nfor lifetime at $15,000\nand buy 30 cows\nat $500 each\nTotal $30,000",30_000,new Ridge("Rattlesnake Ridge",30)));
		
		deckOTB.add(new CardOTB("Lease\nCascade Ridge\nfor lifetime at $20,000\nand buy 40 cows\nat $500 each\nTotal $40,000",40_000,new Ridge("Cascade Ridge",40)));
		deckOTB.add(new CardOTB("Lease\nCascade Ridge\nfor lifetime at $20,000\nand buy 40 cows\nat $500 each\nTotal $40,000",40_000,new Ridge("Cascade Ridge",40)));
		
		deckOTB.add(new CardOTB("Lease\nToppenish Ridge\nfor lifetime at $25,000\nand buy 50 cows\nat $500 each\nTotal $50,000",50_000,new Ridge("Toppenish Ridge",50)));
		deckOTB.add(new CardOTB("Lease\nToppenish Ridge\nfor lifetime at $25,000\nand buy 50 cows\nat $500 each\nTotal $50,000",50_000,new Ridge("Toppenish Ridge",50)));
		
		deckOTB.add(new CardOTB("LIVESTOCK AUCTION\n10 cows at $500 each\nTotal $5,000",5_000,new CropAcre(Crop.livestock, 10)));
		deckOTB.add(new CardOTB("LIVESTOCK AUCTION\n10 cows at $500 each\nTotal $5,000",5_000,new CropAcre(Crop.livestock, 10)));
		deckOTB.add(new CardOTB("LIVESTOCK AUCTION\n10 cows at $500 each\nTotal $5,000",5_000,new CropAcre(Crop.livestock, 10)));
		deckOTB.add(new CardOTB("LIVESTOCK AUCTION\n10 cows at $500 each\nTotal $5,000",5_000,new CropAcre(Crop.livestock, 10)));
		deckOTB.add(new CardOTB("LIVESTOCK AUCTION\n10 cows at $500 each\nTotal $5,000",5_000,new CropAcre(Crop.livestock, 10)));
		
		deckOTB.add(new CardOTB("EQUIPMENT SALE\nHARVESTER\nTotal $10,000",10_000,new Equipment("Harvester")));
		deckOTB.add(new CardOTB("EQUIPMENT SALE\nHARVESTER\nTotal $10,000",10_000,new Equipment("Harvester")));
		deckOTB.add(new CardOTB("EQUIPMENT SALE\nHARVESTER\nTotal $10,000",10_000,new Equipment("Harvester")));
		
		deckOTB.add(new CardOTB("EQUIPMENT SALE\nTractor\nTotal $10,000",10_000,new Equipment("Tractor")));
		deckOTB.add(new CardOTB("EQUIPMENT SALE\nTractor\nTotal $10,000",10_000,new Equipment("Tractor")));
		deckOTB.add(new CardOTB("EQUIPMENT SALE\nTractor\nTotal $10,000",10_000,new Equipment("Tractor")));
		
	}
	private void initDeckFF(){
		deckFF = new ArrayList<>();
		deckFF.add(new CardFF("Cut worms eat sprouting fishbuds. EPA bans control spray.\nPay $300 per Fruit acre",(player -> {player.subMoney(player.acreage(Crop.fruit)*300);})));
		deckFF.add(new CardFF("The Apple Maggot Fly, cousin of the dreaded Medfly, is found in an insect trap in your orchard. Your orchard is quaranteened and you lose lucrative export contract.\nPay $500 per Fruit acre.",(player -> player.subMoney(player.acreage(Crop.fruit)*500))));
		deckFF.add(new CardFF("Truckers strike delays Fruit in transport, lots of spoilage.\nPay $1,000 per Fruit acre.",(player -> player.subMoney(player.acreage(Crop.fruit)*1000))));
		deckFF.add(new CardFF("The President slaps on a Grain Embargo while you're waiting for the custom harvester to show up. Instant market collapse.\nPay $2,500 if you do not own your own Harvester",(player -> {if (!player.effects.harvester) player.subMoney(2500);})));
		deckFF.add(new CardFF("Custom hire bill due.\nIf you have no Tractor pay $3,000.",(player -> {if (!player.effects.tractor) player.subMoney(3000);})));
		deckFF.add(new CardFF("Custom hire bill due.\nIf you have no Tractor pay $3,000.",(player -> {if (!player.effects.tractor) player.subMoney(3000);})));
		deckFF.add(new CardFF("Income taxes due.\nPay $7,000.",(player -> {player.subMoney(7_000);})));
		deckFF.add(new CardFF("Custom hire out with your Harvester.\nIf you have a Harvester, collect $2,000 from each player who has none.",(player -> {
			if (player.effects.harvester){
				for (Player eachPlayer : player.game.players){
					if (!eachPlayer.effects.harvester){
						player.addMoney(2000);
					}
				}
			}
		})));
		deckFF.add(new CardFF("IRS garnishes your income after finding errors on your tax return.\nFor the rest of the year draw Operating Expense cards during Harvests but do not roll for Harvest checks.\nPay $7,000.",(player -> player.effects.garnished = true)));
		deckFF.add(new CardFF("Windy spring, don't get your wheat sprayed.\nWeeds cut your wheat crop in half. (Hold Card thru wheat Harvest for this year)",(player -> player.effects.halfWheat = true)));
		deckFF.add(new CardFF("Uncle Bert dies and leaves you 10 Acres of Hay, if you can raise the $10,000 cash to pay Inheritance Tax and small remaining mortgage.",(player -> {
			if (player.cash > 10_000){
				player.game.output.display("choose 0 (no) or 1(yes) to buy it");
				int choice = player.game.input.choice(1);
				if (choice == 1){
					player.subMoney(10000);
					player.items.add(new CropAcre(Crop.hay, 10));
				}
			}
		})));
		deckFF.add(new CardFF("Natural Disaster - Mt. St. Helens Blows. You were luckily out of the Ash Path.\nYour ash-free Hay jumps in price. Collect $500 per Hay Acre.\nOther players must roll a die to see if they escaped.\nOdd-escaped; Even-hit\nAsh hit players pay $100 per Acre to clean up mess",(player -> {
			player.addMoney(player.acreage()*500);
			for (Player eachPlayer : player.game.players){
				if (eachPlayer.equals(player)) continue;
				player.game.output.display(player);
				int roll = player.game.input.roll();
				if (roll%2 == 0){
					eachPlayer.subMoney(eachPlayer.acreage()*100);
				}
			}
		})));
		deckFF.add(new CardFF("Marketing Co-op holds out for higher price.\nProcessor gives in. Collect $1,000.",(player -> player.addMoney(1_000))));
		deckFF.add(new CardFF("Russian sale boosts wheat Prices.\nCollect $2,000.",(player -> player.addMoney(2_000))));
		deckFF.add(new CardFF("Held some of your calves and the market jumped.\nCollect $2,000 if you have cows.",(player -> {if (player.totalCows() > 0) player.addMoney(2000);})));
		deckFF.add(new CardFF("Drought year. Go to the 2nd week of January.\nDo not collect $5,000.",(player -> player.moveTo(2, false))));
		deckFF.add(new CardFF("Drought year. Go to the 2nd week of January.\nDo not collect $5,000.",(player -> player.moveTo(2, false))));
		deckFF.add(new CardFF("Oil Company pays you $100 per acre for Oil and Gas Lease on your farm.",(player -> player.addMoney(player.acreage()*100))));
		deckFF.add(new CardFF("Federal Crop Disaster payment saves your bacon.\nCollect $100 per Grain acre.",(player -> player.addMoney(player.acreage(Crop.grain)*100))));
		deckFF.add(new CardFF("A leaking electrical motor at the Feed Mill contaminates your load of feed with PCB.\nState Ag. Inspector requires you to slaughtor cows on your farm with no reimbursement.",(player -> {
			for (Item item : player.items){
				if (item instanceof CropAcre && ((CropAcre)item).type == Crop.livestock){
					player.items.remove(item);
				}
			}
		})));
		deckFF.add(new CardFF("Banks raise Prime Rate. Pay 10% of outstanding loan balance as additional interest.", player -> player.subMoney(player.debt/10)));
	}
	private void initDeckOE(){
		deckOE = new ArrayList<>();
		// acre based expenses
		deckOE.add(new CardOE("Pay your Fruit Pickers $400 per Fruit acre.",(player)->{
			return 400 * player.acreage(Crop.fruit);
		}));
		deckOE.add(new CardOE("Wire worm infects Grain acreage.\nPay $100 per Grain acre to fumigate.",(player)->{
			return 100 * player.acreage(Crop.grain);
		}));
		deckOE.add(new CardOE("Feed bill due.\nPay $100 per cow.",(player)->{
			return 100 * player.totalCows();
		}));
		deckOE.add(new CardOE("Fertilizer bill due.\nPay $100 per acre.",(player)->{
			return 100 * player.acreage();
		}));
		deckOE.add(new CardOE("Fertilizer bill due.\nPay $100 per acre.",(player)->{
			return 100 * player.acreage();
		}));
		deckOE.add(new CardOE("Veterinary bill due,\nPay $500 if you own cowns.",(player)->{
			if (player.totalCows()>0){return 500;} return 0;
		}));
		// debt based expenses
		deckOE.add(new CardOE("Semi-annual interest due.\nPay 10% of Bank Notes on hand.",(player)->{
			return player.debt/10;
		}));
		deckOE.add(new CardOE("Semi-annual interest due.\nPay 10% of Bank Notes on hand.",(player)->{
			return player.debt/10;
		}));
		// equipmental expenses
		deckOE.add(new CardOE("Custom hire bill due.\nPay $2,000 if you do not own a Tractor.",(player)->{
			if (player.effects.tractor) {return 0;} return 2000;
		}));
		deckOE.add(new CardOE("Custom hire bill due.\nPay $2,000 if you do not own a Tractor.",(player)->{
			if (player.effects.tractor) {return 0;} return 2000;
		}));
		deckOE.add(new CardOE("Custom hire bill due.\nPay $2,000 if you do not own a Harvester.",(player)->{
			if (player.effects.harvester) {return 0;} return 2000;
		}));
		deckOE.add(new CardOE("Custom hire bill due.\nPay $2,000 if you do not own a Harvester.",(player)->{
			if (player.effects.harvester) {return 0;} return 2000;
		}));
		// constant expenses
		deckOE.add(new CardOE("Equipment breakdown.\nPay $500.", 500));
		deckOE.add(new CardOE("Equipment breakdown.\nPay $500.", 500));
		deckOE.add(new CardOE("Parts bill due.\nPay $500.", 500));
		deckOE.add(new CardOE("Parts bill due.\nPay $500.", 500));
		deckOE.add(new CardOE("Monthly electric bill due for irrigation pumping.\nPay $500.", 500));
		deckOE.add(new CardOE("Gas bill due.\nPay $1,000.", 1000));
		deckOE.add(new CardOE("Gas bill due.\nPay $1,000.", 1000));
		deckOE.add(new CardOE("Equipment in shop. Delay costs.\nPay $1,000.", 1000));
		deckOE.add(new CardOE("Equipment in shop. Delay costs.\nPay $1,000.", 1000));
		deckOE.add(new CardOE("Farmowners Insurance due.\nPay $1,500.", 1500));
		deckOE.add(new CardOE("Farmowners Insurance due.\nPay $1,500.", 1500));
		deckOE.add(new CardOE("Seed bill due.\nPay $3,000.", 3000));
		deckOE.add(new CardOE("Seed bill due.\nPay $3,000.", 3000));
		
	}
	public CardOTB drawOTB(){
		return deckOTB.remove(0);
	}
	public void insertOTB(CardOTB cardOTB){
		deckOTB.add(cardOTB);
	}
	public void remove(CardOTB cardOTB){
		deckOTB.remove(cardOTB);
	}
	public CardOE drawOE(){
		return deckOE.remove(0);
	}
	public void insertOE(CardOE cardOE){
		deckOE.add(cardOE);
	}
	public CardFF drawFF(){
		return deckFF.remove(0);
	}
	public void insertFF(CardFF cardFF){
		deckFF.add(cardFF);
	}
}
