public class Board {
	public final Tile[] board;
	public Board(){
		board = new Tile[49];
		board[0] = new Tile("CHRISTMAS VACATION\nCOLLECT $1000 Christmas bonus.\nCollect years wage of $5000 as you pass", 1000);
		board[1] = new Tile("Pay 10% interest on Bank Notes on hand.", (player) -> player.subMoney(player.debt/10));
		board[2] = new Tile("Hibernate\nDraw O.T.B.", (player) -> player.drawOTB());
		board[3] = new Tile("Bitter cold spell.\nPAY $500 if you own cows", (player) -> {if (player.totalCows()>0){player.subMoney(500);}});
		board[4] = new Tile("Beautiful Days!\nDouble all your Hay Harvests this year.", (player) -> player.effects.add(Effect.doubleHay));
		board[5] = new Tile("Warm snap, you're in the fields 2 weeks early. COLLECT $1000", 1000);
		board[6] = new Tile("Stuck in a muddy corral. Draw Farmer's Fate", (player) -> player.drawFF());
		board[7] = new Tile("Ground thaws. Start plowing early. Go directly to Spring planting.", (player) -> player.position = 14);
		board[8] = new Tile("Rainy day. Draw O.T.B.", (player) -> player.drawOTB());
		board[9] = new Tile("Becomes obvious your wheat has winter killed. PAY %2000 to replant.", (player) -> player.subMoney(2000));
		board[10] = new Tile("Start plowing late. PAY $500", -500);
		board[11] = new Tile("Hurt your back. Go back to the second week of January.", (player) -> player.position = 2);
		board[12] = new Tile("Frost orces you to heat fruit. PAY $2000 if you own fruit.", (player) -> {if (player.totalCrop(Crop.fruit)>0){player.subMoney(2000);}});
		board[13] = new Tile("Done plowing. Take a day off. Draw O.T.B.", (player) -> player.drawOTB());
		board[14] = new Tile("SPRING PLANTING\nPlant corn on time. Double Grain yield this year", (player) -> player.effects.add(Effect.doubleGrain));
		board[15] = new Tile("More rain. Field work shut down. PAY $500", -500);
		board[16] = new Tile("Equipment breakdown. PAY $1000", -1000);
		board[17] = new Tile(null, null);
	}
}
