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
		if (crop == null || player.lastHarvest == null || !player.lastHarvest.equals(cropName)){
			if (crop == null){
				for (CardOTB cardOTB : player.otbs){
					player.game.output.display(cardOTB);
				}
				int choice = player.game.input.choice(player.otbs.size());
				if (choice > 0){
					player.otbs.get(choice-1).apply(player);
				}
			} else {
				if (!player.effects.garnished)
					player.addMoney((int)(coefficient * Harvests.getProfit(crop, Game.roll(), player.acreage(crop))));
				player.game.deck.drawOE().apply(player);
			}
			player.lastHarvest = cropName;
		}
		if (action == null){
			return;
		}
		action.accept(player);
	}
	public String toString(){
		StringBuilder str = new StringBuilder();
		if (week > 0){
			str.append(switch (week){
				case 1 -> "1st";
				case 2 -> "2nd";
				case 3 -> "3rd";
				case 4 -> "4th";
				default -> "err";
			}
			);
			str.append(" week of ");
		}
		str.append(month);
		str.append('\n');
		str.append(text);
		return str.toString();
	}
}
