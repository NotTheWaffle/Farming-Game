import java.util.function.Consumer;

public class Board {
	public final Tile[] board;
	public Board(){
		board = new Tile[49];
		Consumer<Player> drawFF = (player) -> player.drawFF();
		Consumer<Player> drawOTB = (player) -> player.drawOTB();
		board[0] = new Tile("CHRISTMAS VACATION\nCOLLECT $1000 Christmas bonus.\nCollect years wage of $5000 as you pass", 1000);
		board[1] = new Tile("Pay 10% interest on Bank Notes on hand.", (player) -> player.subMoney(player.debt/10));
		board[2] = new Tile("Hibernate\nDraw O.T.B.", drawOTB);
		board[3] = new Tile("Bitter cold spell.\nPAY $500 if you own cows", (player) -> {if (player.totalCows()>0){player.subMoney(500);}});
		board[4] = new Tile("Beautiful Days!\nDouble all your Hay Harvests this year.", (player) -> player.effects.add(Effect.doubleHay));
		board[5] = new Tile("Warm snap, you're in the fields 2 weeks early. COLLECT $1000", 1000);
		board[6] = new Tile("Stuck in a muddy corral. Draw Farmer's Fate", drawFF);
		board[7] = new Tile("Ground thaws. Start plowing early. Go directly to Spring planting.", (player) -> player.position = 14);
		board[8] = new Tile("Rainy day. Draw O.T.B.", drawOTB);
		board[9] = new Tile("Becomes obvious your wheat has winter killed. PAY %2000 to replant.", (player) -> player.subMoney(2000));
		board[10] = new Tile("Start plowing late. PAY $500", -500);
		board[11] = new Tile("Hurt your back. Go back to the second week of January.", (player) -> player.position = 2);
		board[12] = new Tile("Frost orces you to heat fruit. PAY $2000 if you own fruit.", (player) -> {if (player.totalCrop(Crop.fruit)>0){player.subMoney(2000);}});
		board[13] = new Tile("Done plowing. Take a day off. Draw O.T.B.", drawOTB);
		board[14] = new Tile("SPRING PLANTING\nPlant corn on time. Double Grain yield this year", (player) -> player.effects.add(Effect.doubleGrain));
		board[15] = new Tile("More rain. Field work shut down. PAY $500", -500);
		board[16] = new Tile("Equipment breakdown. PAY $1000", -1000);
		board[17] = new Tile("The whole Valley is green. COLLECT $500", 500);
		board[18] = new Tile("Windstorm makes you replant CORN. PAY $500", -500);
		
		board[19] = new Tile(Crop.hay, "1st Hay Cutting", "Cut your hay just right. COLLECT $1000 bonus.", 1000);
		board[20] = new Tile(Crop.hay, "1st Hay Cutting", "Memorial Day weekend. Draw O.T.B.", drawOTB);
		board[21] = new Tile(Crop.hay, "1st Hay Cutting", "Rain storm ruins unbaled hay. Cut your harvest check in half.", null/*TODO*/);
		board[22] = new Tile(Crop.hay, "1st Hay Cutting", "Good growing weather. COLLECT $500 bonus", 500);
		
		board[23] = new Tile(Crop.fruit, "Cherry Harvest", "Rain splits your cherries. Cut your harvest check in half.",null/*TODO*/);
		board[24] = new Tile(Crop.fruit, "Cherry Harvest", "Dust storm. Draw Farmer's fate", drawFF);
		board[25] = new Tile(Crop.fruit, "Cherry Harvest", "INDEPENDENCE DAY BASH",(player) -> {});
		
		board[26] = new Tile(Crop.hay, "2nd Hay Cutting", "Good weather for your second cutting of hay. Double Hay harvest check.",null);
		board[27] = new Tile(Crop.hay, "2nd Hay Cutting", "Hot! Wish you were in the mountains. Draw O.T.B.", drawOTB);
		board[28] = new Tile(Crop.hay, "2nd Hay Cutting", "It's a cooker! 114 in the shade. Wipe your brow and go to Harvest Moon after getting Hay check.", (player) -> player.position = 36);
		
		board[29] = new Tile(Crop.grain, "Wheat Harvest", "85, wheat heads filling out beautifully. Add $50 per acre to your harvest check.", (player) -> player.addMoney(player.totalCrop(Crop.grain)*50));
		board[30] = new Tile(Crop.grain, "Wheat Harvest", "You're right on time and farming like a pro. Go to the fourth week of February. Collect your years wage of $5000.", (player) -> {player.position = 0; player.addMoney(5000);});
		board[31] = new Tile(Crop.grain, "Wheat Harvest", "Storm clouds brewing. Collect $1000, if you have a Harvester", (player) -> {if (player.has(new Equipment("harvester"))){player.addMoney(1000);}});
		board[32] = new Tile(Crop.grain, "Wheat Harvest", "Finish wheat harvest with no break downs. COLLECT $500.", 500);
		board[33] = new Tile(Crop.grain, "Wheat Harvest", "Rain sprouts unharvested wheat. Cut price $50 per acre on harvest check.",null /*TODO*/);

		board[34] = new Tile(Crop.hay, "3rd Hay Cutting", "Tractor owners: bale Hay, then go to the third week of November. Collect your $1000 there, then harvest your Fruit.", (player) -> {player.position = 45;});
		board[35] = new Tile(Crop.hay, "3rd Hay Cutting", "Sunny skies at the County Fair. Draw O.T.B.", drawOTB);

		board[36] = new Tile(Crop.livestock, "Livestock Sales","HARVEST MOON\nsmiles on you\nCOLLECT $500",500);
		board[37] = new Tile(Crop.livestock, "Livestock Sales","Market collapses. Cut livestock check in half.",null/*TODO*/);
		board[38] = new Tile(Crop.livestock, "Livestock Sales","Codling Moth damage to apples lowers fruit grade. Pay $2000 if you own fruit.", (player) -> {if (player.totalCrop(Crop.fruit)>0){player.subMoney(2000);}});
		board[39] = new Tile(Crop.livestock, "Livestock Sales","Indian Summer. Collect $500",500);

		board[40] = new Tile(Crop.hay,"4th Hay Cutting","Good Pheasant Hunting. Draw Farmer's Fate", drawFF);
		board[41] = new Tile(Crop.hay, "4th Hay Cutting","Park your baler for the Winter. Draw O.T.B.", drawOTB);

		board[42] = new Tile(Crop.fruit, "Apple Harvest","Annual Deer Hunt. Draw Farmer's Fate", drawFF);
		board[43] = new Tile(Crop.fruit, "Apple Harvest","Irrigation Season over. Draw O.T.B.", drawOTB);
		board[44] = new Tile(Crop.fruit, "Apple Harvest","Good weather, harvest winding up. COLLECT $500", 500);
		board[45] = new Tile(Crop.fruit, "Apple Harvest","Good weather holding. COLLECT $1000",1000);
		
		board[46] = new Tile(Crop.grain, "Corn Harvest","Early freeze kills fruit buds. PAY $1000 if you have fruit.", (player) -> {if (player.totalCrop(Crop.fruit)>0){player.subMoney(1000);};});
		board[47] = new Tile(Crop.grain, "Corn Harvest", "Cold and dry, perfect Field Corn Harvesting. COLLECT $500.", 500);
		board[48] = new Tile(Crop.grain, "Corn Harvest", "First Snow. Draw Farmer's Fate.", drawFF);
	}
}
