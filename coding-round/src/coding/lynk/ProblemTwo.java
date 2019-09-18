package coding.lynk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ProblemTwo {

	static List<Denomination> denoList = new ArrayList<Denomination>();
	
	public static void main(String[] args) {
		//ATM problem with denominations 2000,500,200,100
		ProblemTwo problemTwo = new ProblemTwo();
		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter denominations");
//		int[] denominations = new int[4];
//		for (int i = 0; i < 4; i++) {
//			denominations[i] = sc.nextInt();
//		}
		System.out.println("Enter amount");
		int amount = sc.nextInt();
		denoList = problemTwo.getAllPossibilities(amount);
		Set<List<Integer>> denoSet = new HashSet<>();
		problemTwo.resolve(denoList,denoSet);
		System.out.println(denoSet);
	}

	private void resolve(List<Denomination> denoList,Set<List<Integer>> denoSet) {
		if(denoList.size() > 0) {
			Denomination denomination = denoList.get(0);
			int[] newList = denomination.getDenos().clone();
			boolean result = forwardPossibility(denomination,denomination.getDenos(),0,denomination.getAmount(),newList);
			if(result) {
				List<Integer> nos = new ArrayList<Integer>();
				for (int i = 0; i < denomination.getDenos().length; i++) {
					nos.add(denomination.getDenos()[i]);
				}
				denoSet.add(nos);
			}
			denoList.remove(0);
			resolve(denoList,denoSet);
		}
	}
	
	private static boolean forwardPossibility(Denomination denomination,
			int[] list, int index, int amount,int[] newList) {
		if(list[index] == 0) {
			if(index == list.length-1 && amount == 0) {
				return true;
			}else if(index < list.length-1){
				return forwardPossibility(denomination,list, ++index, amount,newList);
			}else {
				return false;
			}
		}else {
			int count = 0;
			while(amount >= list[index]) {
				amount -= list[index];
				count++;
				if(denomination.getIndex(list[index]) != Integer.MAX_VALUE && 
						denomination.getIndex(list[index]) == count) {
					break;
				}
			}
			if(count > 1 && list[index] > 100 && !denomination.getAltered()) {
				for (int i = count-1; i >= 1 && check(list,index); i--) {
					Denomination newDenomination = new Denomination(newList.clone(), denomination.getAmount(),true);
					newDenomination.changeIndex(list[index], i);
					denoList.add(newDenomination);
				}
			}
			list[index] = count;
			if(index+1 < list.length) {
				return forwardPossibility(denomination,list, ++index, amount,newList);
			}
			if(index == list.length-1 && amount == 0) {
				return true;
			}
		}
		return false;
	}

	private static boolean check(int[] list, int index) {
		switch(list[index]) {
		case 2000:
			return list[index+1] != 0 || list[index+2] != 0 || list[index+3] != 0;
		case 500:
			return list[index+2] != 0;
		case 200:
			return list[index+1] != 0;
		case 100:
			return false;
		default:
			return false;
		}
	}

	private List<Denomination> getAllPossibilities(int amount) {
		List<Denomination> denoList = new ArrayList<Denomination>();
		List<Integer> list = new ArrayList<>();
		int[] denos = {2000,500,200,100};
		int count = 0;
		for (int i = 0; i < denos.length; i++) {
			if(amount >= denos[i]) {
				count++;
				list.add(denos[i]);
			}else {
				list.add(0);
			}
		}
		double rows = Math.pow(2, count);
		for (int i = 1; i < rows; i++) {
			char[] binaryString = Integer.toBinaryString(i).toCharArray();
			int[] newArr = new int[4];
			count = 3;
			for (int j = binaryString.length-1; j >= 0; j--) {
				if(String.valueOf(binaryString[j]).equals("1")) {
					newArr[count] = list.get(count);
				}else {
					newArr[count] = 0;
				}
				count--;
			}
			denoList.add(new Denomination(newArr,amount,false));
		}
		return denoList;
	}

}


class Denomination{
	private boolean altered = false;
	private int[] denos = new int[4];
	private Map<Integer,Integer> denoIndexMap = new HashMap<Integer, Integer>();
	private int amount = 0;
	public Denomination(int[] denos,int amount,boolean altered) {
		this.denos = denos;
		this.altered = altered;
		this.amount = amount;
		for (int i = 0; i < this.denos.length; i++) {
			denoIndexMap.put(this.denos[i], Integer.MAX_VALUE);
		}
	}
	
	public boolean getAltered() {
		return this.altered;
	}
	
	public void changeIndex(int deno,int index) {
		denoIndexMap.put(deno, index);
	}
	
	public int getIndex(int deno) {
		return denoIndexMap.get(deno)!=null?denoIndexMap.get(deno):Integer.MAX_VALUE;
	}
	
	public int getAmount() {
		return this.amount;
	}
	
	public int[] getDenos() {
		return this.denos;
	}
	
	@Override
	public boolean equals(Object obj) {
			Denomination deno = (Denomination)obj;
			if(this.denos.equals(deno.getDenos())) {
				return true;
			};
			return false;
	}
	
	@Override
	public int hashCode() {
		return this.denos.hashCode();
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		StringBuilder denoStr = new StringBuilder();
		denoStr.append("[");
		for (int i = 0; i < this.denos.length; i++) {
			denoStr.append(this.denos[i]);
			if(i+1 < this.denos.length) {
				denoStr.append(",");
			}
		}
		denoStr.append("]");
		return str.append("{").append("denos=").append(denoStr.toString())
				.append("denoIndexMap=").append(denoIndexMap)
				.append("}").toString();
//		return str.append("{").append("amount=").append(this.amount).append(",")
//				.append("denos=").append(denoStr.toString()).append(",")
//				.append("denoIndexMap=").append(denoIndexMap)
//				.append("}").toString();
	}
}