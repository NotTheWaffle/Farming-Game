public class CropAcre extends Item{
	public Crop type;
	public int acreage;
	public CropAcre(Crop type, int acreage){
		this.type = type;
		this.acreage = acreage;
	}
	@Override
	public int hashCode(){
		return type.hashCode() ^ acreage;
	}
	@Override
	public boolean equals(Object o){
		if (o == null || !(o instanceof CropAcre)){
			return false;
		}
		CropAcre ca = (CropAcre) o;
		return ca.type.equals(type) && ca.acreage == acreage;
	}
	@Override
	public String toString(){
		if (type == Crop.livestock) {
			return acreage+" livestock";
		}
		return acreage+" acres of "+type;
	}
}