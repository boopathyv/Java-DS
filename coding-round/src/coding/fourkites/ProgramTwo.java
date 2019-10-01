package coding.fourkites;

public class ProgramTwo {
	
	public static void main(String[] args) {
		int m = 4;
		int n = 4;
		String[] grid = new String[m];
		grid[0] = ".**.";
		grid[1] = "*.**";
		grid[2] = "*..*";
		grid[3] = "****";
		volume_trapped(m,n,grid);
	}
	
	static int volume_trapped(int m, int n, String[] grid) {
        Node[][] inputArray = new Node[m][n];
        for(int i=0; i< m; i++){
            for(int j=0; j< n; j++){
                char character = grid[i].charAt(j);
                switch(character){
                    case '.' : 
                    	inputArray[i][j] = (i == 0 || i == m-1 || j == 0 || j == n-1) 
                    			? new Node(false,0) :new Node(true,0);
                        break;
                    case '*' : inputArray[i][j] = new Node(false,1);
                        break;
                    default  : break;
                }
            }
        }
        int count = 0;
        for(int i=1; i<= m-1; i++){
            for(int j=1; j<= n-1; j++){
                if(inputArray[i][j].type == 0){
                    if(inputArray[i-1][j].type == 1){
                        count++;
                    }
                }
            }
        }
        return 0;
    }
}

class Node{
	boolean canWaterFill;
	int type;
	public Node(boolean canWaterFill,int type) {
		this.canWaterFill = canWaterFill;
		this.type = type;
	}
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		return str.append("{canWaterFill=").append(this.canWaterFill).append(",type=")
				.append(this.type).append("}").toString();
	}
}