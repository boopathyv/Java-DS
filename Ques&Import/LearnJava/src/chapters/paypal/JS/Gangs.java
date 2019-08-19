package chapters.paypal.JS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Gangs {
	
	public static int primeGang = 0;
	public static int compositeGang = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter M & N");
		int rows = sc.nextInt();
		int columns = sc.nextInt();
//		int[][] arr = {{3,6,8,5,6,7,8},{2,4,2,7,8,5,5},
//					   {3,7,6,4,9,7,2},{9,6,5,3,5,4,2},
//					   {4,6,3,4,5,2,8},{3,3,2,4,7,9,2},
//					   {6,2,9,4,6,4,7},{9,4,9,2,8,5,9}}; // 8,7
		int[][] arr = {{6,8,6,2,2,3,4,5,5,6,3,8,8,5,3,2,5,8,7}, //20,19
				{8,4,2,2,9,9,9,5,2,7,4,3,9,5,4,3,2,4,9},
				{6,8,7,8,7,7,7,4,6,3,7,4,9,9,6,4,7,4,3},
				{5,4,9,4,7,5,5,7,6,8,9,5,7,3,4,8,6,4,8},
				{5,5,7,8,5,4,4,5,4,9,9,7,7,8,5,9,9,3,5},
				{5,9,8,9,6,3,9,6,4,2,3,8,9,7,4,7,7,9,8},
				{5,4,3,3,6,8,9,7,2,2,8,6,2,3,6,8,9,8,8},
				{8,7,7,4,9,5,2,4,7,7,2,6,3,4,7,2,5,7,6},
				{3,5,6,9,5,7,5,4,8,6,4,7,6,9,7,8,5,5,7},
				{9,6,6,3,2,8,7,2,6,7,8,4,7,5,9,4,3,8,6},
				{4,4,7,3,4,4,4,8,2,3,2,9,4,8,9,9,3,5,6},
				{5,9,4,6,7,5,6,2,6,7,8,5,3,6,7,2,9,9,2},
				{4,7,5,4,4,7,3,5,7,4,5,6,2,8,7,3,5,6,9},
				{6,7,9,2,6,7,3,8,4,6,5,7,3,9,7,6,6,3,2},
				{9,5,9,4,7,6,6,2,8,2,7,8,6,9,7,5,7,6,9},
				{8,3,3,6,5,9,7,9,3,6,7,9,4,9,3,9,9,9,8},
				{7,3,9,5,8,4,5,9,3,8,8,6,3,6,7,8,2,8,3},
				{9,7,7,8,4,2,3,6,3,9,7,8,6,5,4,9,2,9,6},
				{8,4,6,2,3,7,8,8,6,4,2,6,7,8,8,2,6,9,9},
				{8,7,5,2,5,5,7,9,4,2,4,2,5,9,2,2,5,5,5}};
		Node[][] array = new Node[rows][columns];
		System.out.println("Enter Nos.");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				int number = arr[i][j];
				boolean isPrime = isPrimeNumber(number);
				array[i][j] = new Node(number,isPrime);
			}
		}
		
		
		System.out.println(array);
		checkForCompositeGangs(array,rows,columns);
		System.out.println("primeGang..."+primeGang);
		System.out.println("compositeGang..."+compositeGang);
	}

	private static void checkForCompositeGangs(Node[][] array,int rows, int columns) {
		Boolean checkFor = null;
		List<String> checkList = new ArrayList<>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				Node node = array[i][j];
				if(node != null) {
					boolean isPrime = node.isPrime();
					if(checkFor == null) {
						checkFor = isPrime;
					}
					if(checkFor == isPrime) {
						node.setChecked(true);
						checkList.add(i+","+j);
						checkForEight(array,checkFor,checkList,rows,columns);
					}
					if(checkFor == true) {
						primeGang++;
					}else {
						compositeGang++;
					}
					if(checkFor != null) {
						doNull(array,rows,columns);
						checkForCompositeGangs(array,rows,columns);
					}
				}
			}
		}
	}

	private static void doNull(Node[][] array, int rows, int columns) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				Node node = array[i][j];
				if(node != null && node.checked) {
					array[i][j] = null;
				}
			}
		}
	}

	private static void checkForEight(Node[][] array,boolean checkFor,List<String> checkList,int rows,int columns) {
		for (int k = 0; k < checkList.size(); k++) {
			int i = Integer.parseInt(checkList.get(k).split(",")[0]);
			int j = Integer.parseInt(checkList.get(k).split(",")[1]);
//			if(i-1 >= 0 && j-1 >= 0 && array[i-1][j-1] != null) {
//				Node node = array[i-1][j-1];
//				if(checkFor == node.isPrime() && !node.checked) {				
//					node.setChecked(true);
//					String number = (i-1)+","+(j-1);
//					if(!checkList.contains(number)) {
//						checkList.add(number);
//					}
//				}
//			}
			if(i-1 >= 0 && j >= 0 && array[i-1][j] != null) {
				Node node = array[i-1][j];
				if(checkFor == node.isPrime() && !node.checked) {				
					node.setChecked(true);
					String number = (i-1)+","+(j);
					if(!checkList.contains(number)) {
						checkList.add(number);
					}
				}
			}
//			if(i-1 >= 0 && j+1 < columns && array[i-1][j+1] != null) {
//				Node node = array[i-1][j+1];
//				if(checkFor == node.isPrime() && !node.checked) {				
//					node.setChecked(true);
//					String number = (i-1)+","+(j+1);
//					if(!checkList.contains(number)) {
//						checkList.add(number);
//					}
//				}
//			}
			if(i >= 0 && j-1 >= 0 && array[i][j-1] != null) {
				Node node = array[i][j-1];
				if(checkFor == node.isPrime() && !node.checked) {				
					node.setChecked(true);
					String number = (i)+","+(j-1);
					if(!checkList.contains(number)) {
						checkList.add(number);
					}
				}
			}
			if(i >= 0 && j+1 < columns && array[i][j+1] != null) {
				Node node = array[i][j+1];
				if(checkFor == node.isPrime() && !node.checked) {				
					node.setChecked(true);
					String number = (i)+","+(j+1);
					if(!checkList.contains(number)) {
						checkList.add(number);
					}
				}
			}
//			if(i+1 < rows && j-1 >= 0 && array[i+1][j-1] != null) {
//				Node node = array[i+1][j-1];
//				if(checkFor == node.isPrime() && !node.checked) {				
//					node.setChecked(true);
//					String number = (i+1)+","+(j-1);
//					if(!checkList.contains(number)) {
//						checkList.add(number);
//					}
//				}	
//			}
			if(i+1 < rows && j >= 0 && array[i+1][j] != null) {
				Node node = array[i+1][j];
				if(checkFor == node.isPrime() && !node.checked) {				
					node.setChecked(true);
					String number = (i+1)+","+(j);
					if(!checkList.contains(number)) {
						checkList.add(number);
					}
				}
			}
//			if(i+1 < rows && j+1 < columns && array[i+1][j+1] != null) {
//				Node node = array[i+1][j+1];
//				if(checkFor == node.isPrime() && !node.checked) {				
//					node.setChecked(true);
//					String number = (i+1)+","+(j+1);
//					if(!checkList.contains(number)) {
//						checkList.add(number);
//					}
//				}
//			}
			checkList.remove(i+","+j);
			if(checkList.size() != 0) {
				checkForEight(array,checkFor,checkList,rows,columns);
			}
		}
	}

	private static boolean isPrimeNumber(int number) {
		if(number == 2) {
			return true;
		}
		if(number % 2 == 0) {
			return false;
		}
		for (int i = 2; i < number/2+1; i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}
}

class Node{
	int number;
	boolean isPrime;
	boolean checked;

	public Node(int number,boolean isPrime) {
		this.number = number;
		this.isPrime = isPrime;
		this.checked = false;
	}
	
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	public boolean getChecked() {
		return this.checked;
	}
	
	public boolean isPrime() {
		return this.isPrime;
	}
}
