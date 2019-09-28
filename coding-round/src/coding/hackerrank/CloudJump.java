package coding.hackerrank;

public class CloudJump {

	public static void main(String[] args) {
		int[] clouds = {0,0,1,0,0,1,0};
		int jump =0;
		for (int i = 0; i < clouds.length;) {
			if(i+2 < clouds.length && clouds[i+2]!=1) {
				jump++;
				i = i+2;
			}else if(i+1 < clouds.length && clouds[i+1] != 1) {
				jump++;
				i = i+1;
			}else {
				i++;
			}
		}
		System.out.println(jump);
	}
}
