package coding.hackerrank;

public class RepeatedString {
	
	public static void main(String[] args) {
		System.out.println(repeatedString());
	}
	
	public static long repeatedString() {
		String str = "ert";
		String check = "a";
        long length = 10000L;
        if(str.equals("a")){
            return length;
        }else if(!str.contains("a")){
            return 0;
        }
        long count = 0;
        int strIndex = 0;
        for (long i = 0; i < length; i++) {
            if(String.valueOf(str.charAt(strIndex)).equals(check)) {
                count++;
            }
            strIndex++;
            if(strIndex >= str.length()) {
                strIndex = 0;
            }
        }
		System.out.println(count);
		return count;
	}
}
