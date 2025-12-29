
import java.util.ArrayList;
import java.util.List;

public class Bill {
	public static final int[] cashDenominations = {10_000,5_000,1_000,500,100,50,25};
	public static final int[] debtDenominations = {-10_000,-5_000,-1_000};
	public boolean cash;
	public int index;
	private Bill(int index, boolean cash){
		this.index = index;
		this.cash = cash;
	}
	public static List<Bill> split(int money){
		List<Bill> bills = new ArrayList<>();
		for (int i = 0; i < debtDenominations.length; i++){
			while (money <= debtDenominations[i]){
				money -= debtDenominations[i];
				bills.add(new Bill(i,false));
			}
		}
		while (money < 0){
			money += 1000;
			bills.add(new Bill(2,false));
		}
		for (int i = 0; i < cashDenominations.length; i++){
			while (money >= cashDenominations[i]){
				money -= cashDenominations[i];
				bills.add(new Bill(i,true));
			}
		}
		return bills;
	}
	public static int getValue(List<Bill> bills){
		int sum = 0;
		for (Bill bill : bills){
			sum += bill.getValue();
		}
		return sum;
	}
	public int getValue(){
		if (cash){
			return cashDenominations[index];
		}
		return debtDenominations[index];
	}
	public String toString(){
		return ""+getValue();
	}
}