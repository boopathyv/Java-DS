package coding.round;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ATM {

	public static void main(String[] args) {
		ATM codingTest = new ATM();
		Scanner sc = new Scanner(System.in);
		int[] denominationNos = codingTest.getInputs(sc);
		int amount = getAmount(denominationNos,sc);
		List<List<Integer>> lists = getAllPossibilities(new int[]{2000,500,200,100},amount);
		Set<List<Integer>> resultSet = new HashSet<>();
		for (int i = 0; i < lists.size(); i++) {
			List<Integer> list = lists.get(i);
//			System.out.println(list);
			boolean result = forwardPossibility(list,0,amount);
			if(result) {
				resultSet.add(list);
			}
		}
		System.out.println(resultSet);
	}
	
	private static boolean reversePossibility(List<Integer> list, int index, int amount) {
		if(list.get(index) == 0) {
			if(index == 0 && amount == 0) {
				return true;
			}else if(index > 0){
				return reversePossibility(list, --index, amount);
			}else {
				return false;
			}
		}else {
			int count = 0;
			while(amount >= list.get(index)) {
				amount -= list.get(index);
				count++;
			}
			list.set(index, count);
			if(index-1 >= 0) {
				return reversePossibility(list, --index, amount);
			}
			if(index == 0 && amount == 0) {
				return true;
			}
		}
		return false;
	}

	private static boolean forwardPossibility(List<Integer> list, int index, int amount) {
		if(list.get(index) == 0) {
			if(index == list.size()-1 && amount == 0) {
				return true;
			}else if(index < list.size()-1){
				return forwardPossibility(list, ++index, amount);
			}else {
				return false;
			}
		}else {
			int count = 0;
			while(amount >= list.get(index)) {
				amount -= list.get(index);
				count++;
			}
			list.set(index, count);
			if(index+1 < list.size()) {
				return forwardPossibility(list, ++index, amount);
			}
			if(index == list.size()-1 && amount == 0) {
				return true;
			}
		}
		return false;
	}

	private static List<List<Integer>> getAllPossibilities(int[] denominations,int amount) {
		for (int i = 0; i < denominations.length; i++) {
			if(amount < denominations[i]) {
				denominations[i] = 0;
			}
		}
		
		List<List<Integer>> lists = new ArrayList<>();
		if(denominations[0] != 0) {
		lists.add(Arrays.asList(2000,500,200,100));
		lists.add(Arrays.asList(2000,500,200,0));
		lists.add(Arrays.asList(2000,500,0,0));
		lists.add(Arrays.asList(2000,500,0,100));
		lists.add(Arrays.asList(2000,0,200,0));
		lists.add(Arrays.asList(2000,0,200,100));
		lists.add(Arrays.asList(2000,0,0,100));
		lists.add(Arrays.asList(2000,0,0,0));
		}
		if(denominations[1] != 0) {
		lists.add(Arrays.asList(0,500,200,100));
		lists.add(Arrays.asList(0,500,200,0));
		lists.add(Arrays.asList(0,500,0,100));
		lists.add(Arrays.asList(0,500,0,0));
		}
		if(denominations[2] != 0) {
		lists.add(Arrays.asList(0,0,200,100));
		lists.add(Arrays.asList(0,0,200,0));
		}
		if(denominations[3] != 0) {
			lists.add(Arrays.asList(0,0,0,100));
		}
		return lists;
	}

	private static int getAmount(int[] denominationNos,Scanner sc) {
		System.out.println("Enter the amount");
		int amount = sc.nextInt();
		while(amount < 100) {
			System.out.println("Enter the amount greater than 100");
			amount = sc.nextInt();
		}
		return amount;
	}

	private int[] getInputs(Scanner sc) {
		System.out.println("Enter the no. of denominations");
		int[] denominationArray = new int[4];
		for (int i = 0; i < 4; i++) {
			int denominationNos = sc.nextInt();
			denominationArray[i] = denominationNos;
		}
		return denominationArray;
	}
}
