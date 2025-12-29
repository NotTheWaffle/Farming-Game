public final class Harvests{
	private Harvests(){}
	public static int getProfit(Crop crop, int roll, int acres){
		int[] profitPerAcre = switch (crop) {
			case hay -> 		new int[] {40,	60,		100,	150,	220,	300	};
			case grain -> 		new int[] {75,	150,	250,	375,	525,	700	};
			case fruit -> 		new int[] {400,	700,	1200,	1800,	2600,	3500};
			case livestock ->	new int[] {140,	200,	280,	380,	500,	750	};
			default -> 			new int[] {0,	0, 		0,		0,		0,		0	};
		};
		return profitPerAcre[roll-1] * acres;
	}
}