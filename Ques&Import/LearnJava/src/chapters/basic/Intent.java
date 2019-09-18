package chapters.basic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Intent {

	public static void main(String[] args) throws Exception{
		Intent intent = new Intent();
		System.out.println(intent.getValue());
	}
	
	private int getValue(){
		try {
			getValue(0);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}catch(Error er) {
			System.out.println(er.getMessage());
		}finally {
			return -1;
		}
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize");
	}
	
	private void getValue(int index){
		System.out.println(index);
		getValue(++index);
	}
	public static int[] a = {10,10};
}


class parent{}

class childOne extends parent{}

class childTwo extends parent{}