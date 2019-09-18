package chapters.basic;

public class Lambda {

	
	public static void main(String[] args) {
		 Lambda lambda = new Lambda();
		 Basic basic = new Basic();
		 System.out.println(lambda.functionalInterface().getValue(basic, basic, basic, basic, basic, basic, basic));
	}

	private Common functionalInterface() {
		Common common = (a,b,c,d,e,f,g)->{
			return a.sendIntValue()+b.sendIntValue()+c.sendIntValue()+d.sendIntValue()
			+e.sendIntValue()+f.sendIntValue()+g.sendIntValue();
		};
		return common;
	}
}

interface Common{
	public int getValue(Basic basic,Basic basic1,Basic basic2,Basic basic3,Basic basic4,
			Basic basic5,Basic basic6);
}
