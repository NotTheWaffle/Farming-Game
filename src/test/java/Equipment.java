public class Equipment extends Item{
	public String type;
	public Equipment(String type){
		this.type = type;
	}
	public boolean equals(Object o){
		if (o == null || !(o instanceof Equipment)){
			return false;
		}
		Equipment e = (Equipment) o;
		return e.type.equals(type);
	}
}
