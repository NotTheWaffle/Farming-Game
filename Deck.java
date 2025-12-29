import java.util.ArrayList;

public class Deck {
	private ArrayList<Card> otbDeck;
	private ArrayList<Card> ffDeck;
	private ArrayList<Card> oeDeck;

	public Deck(){
		initotbDeck();
		initffDeck();
		initoeDeck();
	}
	private final void initotbDeck(){
		otbDeck = new ArrayList<>();
		otbDeck.add(new CardOTB("NEIGHBOR GOES BROKE\n5 acres Fruit\nat $5,000 per acre\nTotal $25,000",25_000,new CropAcre(Crop.fruit, 5)));
		otbDeck.add(new CardOTB("NEIGHBOR GOES BROKE\n5 acres Fruit\nat $5,000 per acre\nTotal $25,000",25_000,new CropAcre(Crop.fruit, 5)));
		otbDeck.add(new CardOTB("NEIGHBOR GOES BROKE\n5 acres Fruit\nat $5,000 per acre\nTotal $25,000",25_000,new CropAcre(Crop.fruit, 5)));
		otbDeck.add(new CardOTB("NEIGHBOR GOES BROKE\n5 acres Fruit\nat $5,000 per acre\nTotal $25,000",25_000,new CropAcre(Crop.fruit, 5)));

		otbDeck.add(new CardOTB("NEIGHBOR SELLS OUT\n10 acres Grain\nat $2,000 per acre\nTotal $20,000",20_000,new CropAcre(Crop.grain, 10)));
		otbDeck.add(new CardOTB("NEIGHBOR SELLS OUT\n10 acres Grain\nat $2,000 per acre\nTotal $20,000",20_000,new CropAcre(Crop.grain, 10)));
		otbDeck.add(new CardOTB("NEIGHBOR SELLS OUT\n10 acres Grain\nat $2,000 per acre\nTotal $20,000",20_000,new CropAcre(Crop.grain, 10)));
		otbDeck.add(new CardOTB("NEIGHBOR SELLS OUT\n10 acres Grain\nat $2,000 per acre\nTotal $20,000",20_000,new CropAcre(Crop.grain, 10)));
		otbDeck.add(new CardOTB("NEIGHBOR SELLS OUT\n10 acres Grain\nat $2,000 per acre\nTotal $20,000",20_000,new CropAcre(Crop.grain, 10)));
		
		otbDeck.add(new CardOTB("NEIGHBOR SELLS OUT\n10 acres Hay\nat $2,000 per acre\nTotal $20,000",20_000,new CropAcre(Crop.hay, 10)));
		otbDeck.add(new CardOTB("NEIGHBOR SELLS OUT\n10 acres Hay\nat $2,000 per acre\nTotal $20,000",20_000,new CropAcre(Crop.hay, 10)));
		otbDeck.add(new CardOTB("NEIGHBOR SELLS OUT\n10 acres Hay\nat $2,000 per acre\nTotal $20,000",20_000,new CropAcre(Crop.hay, 10)));
		otbDeck.add(new CardOTB("NEIGHBOR SELLS OUT\n10 acres Hay\nat $2,000 per acre\nTotal $20,000",20_000,new CropAcre(Crop.hay, 10)));
		
		otbDeck.add(new CardOTB("Lease\nAhtanum Ridge\nfor lifetime at $10,000\nand buy 20 cows\nat $500 each\nTotal $20,000",20_000,new Ridge("Ahtanum Ridge",20)));
		otbDeck.add(new CardOTB("Lease\nAhtanum Ridge\nfor lifetime at $10,000\nand buy 20 cows\nat $500 each\nTotal $20,000",20_000,new Ridge("Ahtanum Ridge",20)));

		otbDeck.add(new CardOTB("Lease\nRattlesnake Ridge\nfor lifetime at $15,000\nand buy 30 cows\nat $500 each\nTotal $30,000",30_000,new Ridge("Rattlesnake Ridge",30)));
		otbDeck.add(new CardOTB("Lease\nRattlesnake Ridge\nfor lifetime at $15,000\nand buy 30 cows\nat $500 each\nTotal $30,000",30_000,new Ridge("Rattlesnake Ridge",30)));
		
		otbDeck.add(new CardOTB("Lease\nCascade Ridge\nfor lifetime at $20,000\nand buy 40 cows\nat $500 each\nTotal $40,000",40_000,new Ridge("Cascade Ridge",40)));
		otbDeck.add(new CardOTB("Lease\nCascade Ridge\nfor lifetime at $20,000\nand buy 40 cows\nat $500 each\nTotal $40,000",40_000,new Ridge("Cascade Ridge",40)));
		
		otbDeck.add(new CardOTB("Lease\nToppenish Ridge\nfor lifetime at $25,000\nand buy 50 cows\nat $500 each\nTotal $50,000",50_000,new Ridge("Toppenish Ridge",50)));
		otbDeck.add(new CardOTB("Lease\nToppenish Ridge\nfor lifetime at $25,000\nand buy 50 cows\nat $500 each\nTotal $50,000",50_000,new Ridge("Toppenish Ridge",50)));
		
		otbDeck.add(new CardOTB("LIVESTOCK AUCTION\n10 cows at $500 each\nTotal $5,000",5_000,new CropAcre(Crop.livestock, 10)));
		otbDeck.add(new CardOTB("LIVESTOCK AUCTION\n10 cows at $500 each\nTotal $5,000",5_000,new CropAcre(Crop.livestock, 10)));
		otbDeck.add(new CardOTB("LIVESTOCK AUCTION\n10 cows at $500 each\nTotal $5,000",5_000,new CropAcre(Crop.livestock, 10)));
		otbDeck.add(new CardOTB("LIVESTOCK AUCTION\n10 cows at $500 each\nTotal $5,000",5_000,new CropAcre(Crop.livestock, 10)));
		otbDeck.add(new CardOTB("LIVESTOCK AUCTION\n10 cows at $500 each\nTotal $5,000",5_000,new CropAcre(Crop.livestock, 10)));
		
		otbDeck.add(new CardOTB("EQUIPMENT SALE\nHARVESTER\nTotal $10,000",10_000,new Equipment("Harvester")));
		otbDeck.add(new CardOTB("EQUIPMENT SALE\nHARVESTER\nTotal $10,000",10_000,new Equipment("Harvester")));
		otbDeck.add(new CardOTB("EQUIPMENT SALE\nHARVESTER\nTotal $10,000",10_000,new Equipment("Harvester")));
		
		otbDeck.add(new CardOTB("EQUIPMENT SALE\nTractor\nTotal $10,000",10_000,new Equipment("Tractor")));
		otbDeck.add(new CardOTB("EQUIPMENT SALE\nTractor\nTotal $10,000",10_000,new Equipment("Tractor")));
		otbDeck.add(new CardOTB("EQUIPMENT SALE\nTractor\nTotal $10,000",10_000,new Equipment("Tractor")));
		
	}
	private final void initffDeck(){
		ffDeck.add(new CardFF("Cut worms eat sprouting fishbuds. EPA bans control spray.\nPay $300 per Fruit acre",(player -> {
			int fruitAcreage = 0;
			for (Item item : player.items){
				if (item instanceof CropAcre){
					if ((((CropAcre)item).type == Crop.fruit)){
						fruitAcreage += ((CropAcre) item).acreage;
					}
				}
			}
			player.subMoney(fruitAcreage*300);
		})));
		ffDeck.add(new CardFF("The Apple Maggot Fly, cousin of the dreaded Medfly, is found in an insect trap in your orchard. Your orchard is quaranteened and you lose lucrative export contract.\nPay $500 per Fruit acre.",(player -> {
			int fruitAcreage = 0;
			for (Item item : player.items){
				if (item instanceof CropAcre){
					if ((((CropAcre)item).type == Crop.fruit)){
						fruitAcreage += ((CropAcre) item).acreage;
					}
				}
			}
			player.subMoney(fruitAcreage*500);
		})));
		ffDeck.add(new CardFF("Truckers strike delays Fruit in transport, lots of spoilage.\nPay $1,000 per Fruit acre.",(player -> {
			int fruitAcreage = 0;
			for (Item item : player.items){
				if (item instanceof CropAcre){
					if ((((CropAcre)item).type == Crop.fruit)){
						fruitAcreage += ((CropAcre) item).acreage;
					}
				}
			}
			player.subMoney(fruitAcreage*1000);
		})));
		ffDeck.add(new CardFF("The President slaps on a Grain Embargo while you're waiting for the custom harvester to show up. Instant market collapse.\nPay $2,500 if you do not own your own Harvester",(player -> {
			int amt = 2_500;
			for (Item item : player.items){
				if (item instanceof Equipment){
					if (((Equipment)item).type.equals("Harvester")){
						amt = 0;
					}
				}
			}
			player.subMoney(amt);
		})));
		ffDeck.add(new CardFF("Custom hire bill due.\nIf you have no Tractor pay $3,000.",(player -> {
			int amt = 3_000;
			for (Item item : player.items){
				if (item instanceof Equipment){
					if (((Equipment)item).type.equals("Tractor")){
						amt = 0;
					}
				}
			}
			player.subMoney(amt);
		})));
		ffDeck.add(new CardFF("Custom hire bill due.\nIf you have no Tractor pay $3,000.",(player -> {
			int amt = 3_000;
			for (Item item : player.items){
				if (item instanceof Equipment){
					if (((Equipment)item).type.equals("Tractor")){
						amt = 0;
					}
				}
			}
			player.subMoney(amt);
		})));
		ffDeck.add(new CardFF("Income taxes due.\nPay $7,000.",(player -> {
			player.subMoney(7_000);
		})));
		//TODO
		ffDeck.add(new CardFF("Custom hire out with your Harvester.\nIf you have a Harvester, collect $2,000 from each player who has none.",(player -> {
			
		})));
		ffDeck.add(new CardFF("IRS garnishes your income after finding errors on your tax return.\nFor the rest of the year draw Operating Expense cards during Harvests but do not roll for Harvest checks.\nPay $7,000.",(player -> {
			player.effects.add(Effect.garnished);
		})));
		ffDeck.add(new CardFF("Windy spring, don't get your wheat sprayed.\nWeeds cut your wheat crop in half. (Hold Card thru wheat Harvest for this year)",(player -> {
			player.effects.add(Effect.halfGrain);
		})));
		//TODO
		ffDeck.add(new CardFF("Uncle Bert dies and leaves you 10 Acres of Hay, if you can raise the $10,000 cash to pay Inheritance Tax and small remaining mortgage.",(player -> {
			
		})));
		//TODO
		ffDeck.add(new CardFF("Natural Disaster - Mt. St. Helens Blows. You were luckily out of the Ash Path.\nYour ash-free Hay jumps in price. Collect $500 per Hay Acre.\nOther players must roll a die to see if they escaped.\nOdd-escaped; Even-hit\nAsh hit players pay $100 per Acre to clean up mess",(player -> {
			
		})));
		ffDeck.add(new CardFF("Marketing C-op holds out for higher price.\nProcessor gives in. Collect $1,000.",(player -> {
			player.addMoney(1_000);
		})));
		ffDeck.add(new CardFF("Russian sale boosts wheat Prices.\nCollect $2,000.",(player -> {
			player.addMoney(2_000);
		})));
		ffDeck.add(new CardFF("Held some of your calves and the market jumped.\nCollect $2,000 if you have cows.",(player -> {
			for (Item item : player.items){
				if (item instanceof Ridge || (item instanceof CropAcre && ((CropAcre) item).type == Crop.livestock)){
					player.addMoney(2_000);
					return;
				}
			}
		})));
		ffDeck.add(new CardFF("Drought year. Go to the 2nd week of January.\nDo not collect $5,000.",(player -> {
			player.position = 1;
		})));
		ffDeck.add(new CardFF("Drought year. Go to the 2nd week of January.\nDo not collect $5,000.",(player -> {
			player.position = 1;
		})));
		ffDeck.add(new CardFF("Oil Company pays you $100 per acre for Oil and Gas Lease on your farm.",(player -> {
			int acreage = 0;
			for (Item item : player.items){
				if (item instanceof CropAcre && ((CropAcre)item).type != Crop.livestock){
					acreage += ((CropAcre)item).acreage;
				}
			}
			player.addMoney(acreage*100);
		})));
		ffDeck.add(new CardFF("Federal Crop Disaster payment saves your bacon.\nCollect $100 per Grain acre.",(player -> {
			int acreage = 0;
			for (Item item : player.items){
				if (item instanceof CropAcre && ((CropAcre)item).type == Crop.grain){
					acreage += ((CropAcre)item).acreage;
				}
			}
			player.addMoney(acreage*100);
		})));
		ffDeck.add(new CardFF("A leaking electrical motor at the Feed Mill contaminates your load of feed with PCB.\nState Ag. Inspector requires you to slaughtor cows on your farm with no reimbursement.",(player -> {
			for (Item item : player.items){
				if (item instanceof CropAcre && ((CropAcre)item).type == Crop.livestock){
					player.items.remove(item);
				}
			}
		})));
		ffDeck.add(new CardFF("Oil Company pays you $100 per acre for Oil and Gas Lease on your farm.",(player -> {
			player.subMoney(player.debt/10);
		})));
	}
	private final void initoeDeck(){
		oeDeck.add(new CardOE("Pay your Fruit Pickers $400 per Fruit acre.",(player)->{
			int fruitAcreage = 0;
			for (Item item : player.items){
				if (item instanceof CropAcre && ((CropAcre) item).type == Crop.fruit){
					fruitAcreage += ((CropAcre)item).acreage;
				}
			}
			return 400 * fruitAcreage;
		}));
		oeDeck.add(new CardOE("Wire worm infects Grain acreage.\nPay $100 per Grain acre to fumigate.",(player)->{
			int grainAcreage = 0;
			for (Item item : player.items){
				if (item instanceof CropAcre && ((CropAcre) item).type == Crop.grain){
					grainAcreage += ((CropAcre)item).acreage;
				}
			}
			return 100 * grainAcreage;
		}));
		oeDeck.add(new CardOE("Feed bill due.\nPay $100 per cow.",(player)->{
			int cowCount = 0;
			for (Item item : player.items){
				if (item instanceof CropAcre && ((CropAcre) item).type == Crop.livestock){
					cowCount += ((CropAcre)item).acreage;
				} else if (item instanceof Ridge){
					cowCount += ((Ridge) item).capacity;
				}
			}
			return 100 * cowCount;
		}));
		oeDeck.add(new CardOE("Fertilizer bill due.\nPay $100 per acre.",(player)->{
			int acreage = 0;
			for (Item item : player.items){
				if (item instanceof CropAcre && ((CropAcre) item).type != Crop.livestock){
					acreage += ((CropAcre)item).acreage;
				}
			}
			return 100 * acreage;
		}));
		oeDeck.add(new CardOE("Fertilizer bill due.\nPay $100 per acre.",(player)->{
			int acreage = 0;
			for (Item item : player.items){
				if (item instanceof CropAcre && ((CropAcre) item).type != Crop.livestock){
					acreage += ((CropAcre)item).acreage;
				}
			}
			return 100 * acreage;
		}));
		oeDeck.add(new CardOE("Semi-annual interest due.\nPay 10% of Bank Notes on hand.",(player)->{
			return player.debt/10;
		}));
		oeDeck.add(new CardOE("Semi-annual interest due.\nPay 10% of Bank Notes on hand.",(player)->{
			return player.debt/10;
		}));

		
	}
}
