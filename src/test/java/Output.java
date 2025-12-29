public class Output {
	public void display(Tile tile){
		System.out.println(tile.toString());
		//just highlight the tile or point to it or smth
	}
	public void display(Card card){
		System.out.println(card.toString());
		//put the card in front of the screen
	}
	public void display(String string){
		System.out.println(string);
		//just text bro :sob:
	}
	public void display(int roll){
		System.out.println("rolled a "+roll);
		//just a text saying a roll, include a cool dice too :)
	}
}
