
public class ForestTracker {
	public static char[][] trackForestTerrain(char[][] forest, int years){
		if(years<0) {return forest;}
	
		 int row = forest.length;
		 int col = forest.length;
		for(int i=0;i<years;i++) {
			for(int j=0;j<row;j++) {
				for(int k=0;k<col;k++) {
					switch(forest[j][k]) {
						case 'R': continue;
						case 'S': continue;
						case 1: forest[j][k]=2;break;
						case 2: forest[j][k]=3;break;
						case 3: forest[j][k]=4;break;
						case 4: 
							if(j>0 && k>0) {
								int cnt=0;
							
								for(int m=j-1;m<=j+1;m++) {
									for(int n=k-1;n<=k+1;n++) {
										if(j!=m && k!= n && forest[m][n]==4) {cnt++;}
										if(cnt>=3) {
									      forest[j][k]=3;break;
								        }
									}
								}
								
							}
						
				}
			}
		}
	}
 return forest;
}
	public static void main(String[] args) {
		char R = 'R';
		char S='S';
		char[][] forest = {
				{R ,R, S, 1 ,4},
				{S, 2, 4 ,4 ,2},
				{1 ,3 ,S, 3, 4}
				};
		char[][] forest2= {
				{R ,R, S, 2 ,4},
				{S, 3, 4 ,3 ,3},
				{2 ,4 ,S, 4, 4}
		};
		int years=10;
		System.out.println(trackForestTerrain(forest,years).equals(forest2));
	}
}
