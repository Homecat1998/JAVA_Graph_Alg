package Floyd_Warshall;

public class FloydWarshall {

	int[][] widths;
	
	public FloydWarshall(int numV){
		widths = new int[numV][numV];
		for(int i = 0; i < numV; i++){
			for(int j = 0; j < numV; j++){
				widths[i][j] = -1;
			}
		}
		for(int i = 0; i < numV; i++){
			widths[i][i] = 0;
		}
	}
	
	public void solve(){
		for(int k = 0; k < widths.length; k++){
			for(int i = 0; i < widths.length; i++){
				for(int j = 0; j < widths.length; j++){
					if(widths[i][j] < Math.min(widths[i][k],widths[k][j])){
						widths[i][j] = Math.min(widths[i][k],widths[k][j]);
					}
				}
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FloydWarshall sample1 = new FloydWarshall(4);
		
		sample1.widths[0][1] = 4;
		sample1.widths[1][2] = 5;
		sample1.widths[2][3] = 3;
		sample1.widths[0][3] = 2;

		
		sample1.solve();
		
		System.out.println("Width from 1 to 4: " + sample1.widths[0][3]);
		System.out.println("Width from 1 to 3: " + sample1.widths[0][2]);
		System.out.println("Width from 2 to 1: " + sample1.widths[1][0]);
	}

}
