import java.util.function.Consumer;

public class Tile {
	public final String text;
	private final Consumer<Player> action;
	private final Crop crop;
	private final String cropName;
	private final double coefficient;
	private final String month;
	private final int week;
	public Tile(String season, int week, String text, Consumer<Player> action){
		this(season, week, null, null, text, action);
	}
	public Tile(String season, int week, String text, int money){
		this(season, week, text, (player) -> player.addMoney(money));
	}
	public Tile(String season, int week, Crop crop, String cropName, String text, double harvestCoefficient){
		this.month = season;
		this.week = week;
		this.text = text;
		this.action = null;
		this.crop = crop;
		this.cropName = cropName;
		coefficient = harvestCoefficient;
	}
	public Tile(String season, int week, Crop crop, String cropName, String text, Consumer<Player> action){
		this.month = season;
		this.week = week;
		this.text = text;
		this.action = action;
		this.crop = crop;
		this.cropName = cropName;
		coefficient = 1;
	}
	public Tile(String season, int week, Crop crop, String cropName, String text, int money){
		this(season, week, crop, cropName, text, (player) -> player.addMoney(money));
	}
	public void apply(Player player){
		if (cropName == null || !player.lastHarvest.equals(cropName)){
			if (crop == null){
				
			} else {
				if (!player.effects.garnished)
					player.addMoney((int)(coefficient * Harvests.getProfit(crop, Game.roll(), player.acreage(crop))));
				player.game.deck.drawOE().apply(player);
			}
		}
		if (action == null){
			return;
		}
		action.accept(player);
	}
	public String toString(){
		return text;
	}
}
