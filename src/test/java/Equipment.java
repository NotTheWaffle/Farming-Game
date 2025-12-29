public class Equipment extends Item{
	public String type;
	public Equipment(String type){
		this.type = type;
	}
	@Override
	public int hashCode(){
		return type.hashCode()^67;
	}
	@Override
	public boolean equals(Object o){
		if (o == null || !(o instanceof Equipment)){
			return false;
		}
		Equipment e = (Equipment) o;
		return e.type.equals(type);
	}
	@Override
	public String toString(){
		return type;
	}
}
