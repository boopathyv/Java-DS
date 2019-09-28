package coding.AllyIndia;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ProgramOne {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(solve(new int[]{1,4,3,8,12,24}));
	}
	
	
	public static int solves(int[] p) {
        int sum = p[0];
        int currentIndex = 0;
        for(int i=1; i<p.length; i++){
            if(p[currentIndex] < p[i] && p[i]%p[currentIndex] == 0){
                currentIndex = i;
                sum += p[i];
            }
        }
        return sum;
    }
	
	static int solve(int[] p) {
        Integer[] tempArray = new Integer[p.length];
        int sum = 0;
        for(int i=0; i<p.length; i++){
            tempArray[i] = p[i];
        }
        for(int i=1; i<p.length; i++){
            for(int j=0; j<i; j++){
             if(p[i]%p[j] ==0){
                 tempArray[i] = tempArray[j] + p[i];
             }   
            }
        }
        sum = Collections.max(Arrays.asList(tempArray));
        return sum;
    }
}
