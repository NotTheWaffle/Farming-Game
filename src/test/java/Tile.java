import java.util.function.Consumer;

public class Tile {
	public final String text;
	private final Consumer<Player> action;
	private final Crop crop;
	private final String cropName;
	public Tile(String text, Consumer<Player> action){
		this(null, null, text, action);
	}
	public Tile(String text, int money){
		this(text, (player) -> player.addMoney(money));
	}
	public Tile(Crop crop, String cropName, String text, Consumer<Player> action){
		this.text = text;
		this.action = action;
		this.crop = crop;
		this.cropName = cropName;
	}
	public Tile(Crop crop, String cropName, String text, int money){
		this(crop, cropName, text, (player) -> player.addMoney(money));
	}
	public void apply(Player player){
		if (cropName == null || !player.lastHarvest.equals(cropName)){
			if (crop == null){
				
			} else {
				player.addMoney(Harvests.getProfit(crop, Game.roll(), player.totalCrop(crop)));
			}
		}
		action.accept(player);
	}
}
