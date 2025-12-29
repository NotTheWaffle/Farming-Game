import java.util.function.Consumer;

public class Board {
	public static final Tile[] tiles = generateBoard();
	private Board(){}
	private static Tile[] generateBoard(){
		Tile[] board = new Tile[49];
		Consumer<Player> drawFF = (player) -> player.drawFF();
		Consumer<Player> drawOTB = (player) -> player.drawOTB();
		board[0]  = new Tile("Christmas Break",0,"CHRISTMAS VACATION\nCOLLECT $1000 Christmas bonus.\nCollect years wage of $5000 as you pass", 1000);
		board[1]  = new Tile("January",1,"Pay 10% interest on Bank Notes on hand.", (player) -> player.subMoney(player.debt/10));
		board[2]  = new Tile("January",2,"Hibernate\nDraw O.T.B.", drawOTB);
		board[3]  = new Tile("January",3,"Bitter cold spell.\nPAY $500 if you own cows", (player) -> {if (player.totalCows()>0) player.subMoney(500);});
		board[4]  = new Tile("January",4,"Beautiful Days!\nDouble all your Hay Harvests this year.", (player) -> player.effects.doubleHay = true);
		board[5]  = new Tile("February",1,"Warm snap, you're in the fields 2 weeks early. COLLECT $1000", 1000);
		board[6]  = new Tile("February",2,"Stuck in a muddy corral. Draw Farmer's Fate", drawFF);
		board[7]  = new Tile("February",3,"Ground thaws. Start plowing early. Go directly to Spring planting.", (player) -> player.moveTo(14,false));
		board[8]  = new Tile("February",4,"Rainy day. Draw O.T.B.", drawOTB);
		board[9]  = new Tile("March",1,"Becomes obvious your wheat has winter killed. PAY $2000 to replant.", -2000);
		board[10] = new Tile("March",2,"Start plowing late. PAY $500", -500);
		board[11] = new Tile("March",3,"Hurt your back. Go back to the second week of January.", (player) -> player.moveTo(2,false));
		board[12] = new Tile("March",4,"Frost orces you to heat fruit. PAY $2000 if you own fruit.", (player) -> {if (player.acreage(Crop.fruit)>0) player.subMoney(2000);});
		board[13] = new Tile("April",1,"Done plowing. Take a day off. Draw O.T.B.", drawOTB);
		board[14] = new Tile("April",2,"SPRING PLANTING\nPlant corn on time. Double Corn yield this year", (player) -> player.effects.doubleCorn = true);
		board[15] = new Tile("April",3,"More rain. Field work shut down. PAY $500", -500);
		board[16] = new Tile("April",4,"Equipment breakdown. PAY $1000", -1000);
		board[17] = new Tile("May",1,"The whole Valley is green. COLLECT $500", 500);
		board[18] = new Tile("May",2,"Windstorm makes you replant CORN. PAY $500", -500);
		
		board[19] = new Tile("May",3,Crop.hay, "1st Hay Cutting", "Cut your hay just right. COLLECT $1000 bonus.", 1000);
		board[20] = new Tile("May",4,Crop.hay, "1st Hay Cutting", "Memorial Day weekend. Draw O.T.B.", drawOTB);
		board[21] = new Tile("June",1,Crop.hay, "1st Hay Cutting", "Rain storm ruins unbaled hay. Cut your harvest check in half.", .5);
		board[22] = new Tile("June",2,Crop.hay, "1st Hay Cutting", "Good growing weather. COLLECT $500 bonus", 500);
		
		board[23] = new Tile("June",3,Crop.fruit, "Cherry Harvest", "Rain splits your cherries. Cut your harvest check in half.",.5);
		board[24] = new Tile("June",4,Crop.fruit, "Cherry Harvest", "Dust storm. Draw Farmer's fate", drawFF);
		board[25] = new Tile("4th of July",0,Crop.fruit, "Cherry Harvest", "INDEPENDENCE DAY BASH",null);
		
		board[26] = new Tile("July",1,Crop.hay, "2nd Hay Cutting", "Good weather for your second cutting of hay. Double Hay harvest check.",null);
		board[27] = new Tile("July",2,Crop.hay, "2nd Hay Cutting", "Hot! Wish you were in the mountains. Draw O.T.B.", drawOTB);
		board[28] = new Tile("July",3,Crop.hay, "2nd Hay Cutting", "It's a cooker! 114 in the shade. Wipe your brow and go to Harvest Moon after getting Hay check.", (player) -> player.moveTo(36, true));
		
		board[29] = new Tile("July",4,Crop.grain, "Wheat Harvest", "85, wheat heads filling out beautifully. Add $50 per acre to your harvest check.", (player) -> player.addMoney(player.acreage(Crop.grain)*50));
		board[30] = new Tile("August",1,Crop.grain, "Wheat Harvest", "You're right on time and farming like a pro. Go to the fourth week of February. Collect your years wage of $5000.", (player) -> {player.position = 0; player.addMoney(5000);});
		board[31] = new Tile("August",2,Crop.grain, "Wheat Harvest", "Storm clouds brewing. Collect $1000, if you have a Harvester", (player) -> {if (player.has(new Equipment("Harvester"))) player.addMoney(1000);});
		board[32] = new Tile("August",3,Crop.grain, "Wheat Harvest", "Finish wheat harvest with no break downs. COLLECT $500.", 500);
		board[33] = new Tile("August",4,Crop.grain, "Wheat Harvest", "Rain sprouts unharvested wheat. Cut price $50 per acre on harvest check.",null /*TODO*/);

		board[34] = new Tile("September",1,Crop.hay, "3rd Hay Cutting", "Tractor owners: bale Hay, then go to the third week of November. Collect your $1000 there, then harvest your Fruit.", (player) -> player.moveTo(45, true));
		board[35] = new Tile("September",2,Crop.hay, "3rd Hay Cutting", "Sunny skies at the County Fair. Draw O.T.B.", drawOTB);

		board[36] = new Tile("Harvest Moon",0,Crop.livestock, "Livestock Sales","HARVEST MOON\nsmiles on you\nCOLLECT $500",500);
		board[37] = new Tile("September",3,Crop.livestock, "Livestock Sales","Market collapses. Cut livestock check in half.",.5d);
		board[38] = new Tile("September",4,Crop.livestock, "Livestock Sales","Codling Moth damage to apples lowers fruit grade. Pay $2000 if you own fruit.", (player) -> {if (player.acreage(Crop.fruit)>0) player.subMoney(2000);});
		board[39] = new Tile("October",1,Crop.livestock, "Livestock Sales","Indian Summer. Collect $500",500);

		board[40] = new Tile("October",2,Crop.hay,"4th Hay Cutting","Good Pheasant Hunting. Draw Farmer's Fate", drawFF);
		board[41] = new Tile("October",3,Crop.hay, "4th Hay Cutting","Park your baler for the Winter. Draw O.T.B.", drawOTB);

		board[42] = new Tile("October",4,Crop.fruit, "Apple Harvest","Annual Deer Hunt. Draw Farmer's Fate", drawFF);
		board[43] = new Tile("November",1,Crop.fruit, "Apple Harvest","Irrigation Season over. Draw O.T.B.", drawOTB);
		board[44] = new Tile("November",2,Crop.fruit, "Apple Harvest","Good weather, harvest winding up. COLLECT $500", 500);
		board[45] = new Tile("November",3,Crop.fruit, "Apple Harvest","Good weather holding. COLLECT $1000",1000);
		
		board[46] = new Tile("November",4,Crop.grain, "Corn Harvest","Early freeze kills fruit buds. PAY $1000 if you have fruit.", (player) -> {if (player.acreage(Crop.fruit)>0)player.subMoney(1000);});
		board[47] = new Tile("December",1,Crop.grain, "Corn Harvest", "Cold and dry, perfect Field Corn Harvesting. COLLECT $500.", 500);
		board[48] = new Tile("December",2,Crop.grain, "Corn Harvest", "First Snow. Draw Farmer's Fate.", drawFF);
		return board;
	}
}
