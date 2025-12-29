public class CropAcre extends Item{
	public Crop type;
	public int acreage;
	public CropAcre(Crop type, int acreage){
		this.type = type;
		this.acreage = acreage;
	}
	public boolean equals(Object o){
		if (o == null || !(o instanceof CropAcre)){
			return false;
		}
		CropAcre ca = (CropAcre) o;
		return ca.type.equals(type) && ca.acreage == acreage;
	}
	public String toString(){
		return acreage+" "+type+"s";
	}
}
