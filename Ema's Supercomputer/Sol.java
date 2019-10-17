import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sol 
{
	static class Max {
		int size,x,y;
		public Max(int s, int i, int j){
			size = s; x = i; y = j;
		}
		public int getSize(){
			return size;
		}
	}
	
	static boolean checkPlus(int tmp[][], int x2, int y2, int size2){
		int i;
		for(i = -size2;i<=size2;i++)	// vertical
			if(tmp[x2+i][y2] == 1)
				return false;
		for(i = -size2;i<=size2;i++)	// horizontal
			if(tmp[x2][y2+i] == 1)
				return false;
		return true;
	}
	
	static void drawPlus(int[][] tmp, int x, int y, int size){
		int i;
		for(i = -size;i<=size;i++)	// vertical
			tmp[x+i][y] = 1;
		for(i = -size;i<=size;i++) // horizontal
			tmp[x][y+i] = 1;		
	}
	
	static int plusGenerator(String[] grid, int x, int y, int n, int m){
		int step = 1;
		
		while(true)
		{
			if(!(x-step >= 0 && grid[x-step].charAt(y) == 'G'))
				break;
			if(!(x+step < n && grid[x+step].charAt(y) == 'G'))
				break;
			if(!(y-step >= 0 && grid[x].charAt(y-step) == 'G'))
				break;
			if(!(y+step < m && grid[x].charAt(y+step) == 'G'))
				break;
			step++;
		}
		return step-1;
	}

    static int twoPluses(String[] grid) 
    {
    	int i,j,n = grid.length, m = grid[0].length(),sides = 0,prod, fin = 0;
    	List<Max> max = new ArrayList<Max>();
    	
    	for(i = 0;i<n;i++)
    		for(j = 0;j<m;j++)
    			if(grid[i].charAt(j) == 'G')
    			{    			
    			     prod = plusGenerator(grid,i,j,n,m);
    			     Max mx;
    			     while(prod >= 0){
	    				 mx = new Max(prod--,i,j);
	    				 max.add(mx);
    			     }
    			}

    	max.sort(Comparator.comparing(Max::getSize).reversed());
    	sides = max.size();
    	for(i = 0;i<sides;i++)
    	{
    		int[][] tmp = new int[n][m];
    		Max p1 = max.get(i);
    		drawPlus(tmp,p1.x,p1.y,p1.getSize());
    		
    		for(j = i+1;j<sides;j++)
    		{    			
    			Max p2 = max.get(j);
    			if(checkPlus(tmp,p2.x,p2.y,p2.getSize()) ){
    				prod = (p1.getSize()*4+1) * (p2.getSize()*4+1);
    				if(fin < prod)
    					fin = prod;    	
    				if(prod == 1)
    					i = sides;			
    				j = sides;
    			}
    		}
    	}
    	return fin;
    }
}
