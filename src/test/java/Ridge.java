public class Ridge extends Item{
	public String name;
	public int capacity;
	public Ridge(String name, int capacity){
		this.name = name;
		this.capacity = capacity;
	}
	public boolean equals(Object o){
		if (o == null || !(o instanceof Ridge)){
			return false;
		}
		Ridge r = (Ridge) o;
		return r.name.equals(this.name) && r.capacity == this.capacity;
	}
}
