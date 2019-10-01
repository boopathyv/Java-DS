package coding.fourkites;

import java.util.Scanner;

public class ProgramOne {

    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
//        int testCases = sc.nextInt();
//        for(int i=0; i< testCases; i++){
//            int arrayLength = sc.nextInt();
//            long[] inputArray = new long[arrayLength];
//            for(int j=0; j< arrayLength; j++){
//                   inputArray[j] = sc.nextInt();
//            }
            findResult(new long[] {99999,999999999,199999919,1199193193,3193193,1913193193});
//        }
    }
    
    private static void findResult(long[] inputArray){
        long amountOfWater = 0;
        int l = 0;
        int h = inputArray.length -1;
        while(l<h){
            long water = 0;
            long units = h-l-1;
            if(inputArray[l]<inputArray[h]){
                water = units*inputArray[l];
                l += 1;
            }else{
                water = units*inputArray[h];
                h -= 1;
            }
            if(amountOfWater < water){
                amountOfWater = water;
            }
        }
        System.out.println(amountOfWater);
    }
}
