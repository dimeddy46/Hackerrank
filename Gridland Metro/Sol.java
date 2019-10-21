import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sol 
{
	static class Limits
	{
		int left, right;
		public Limits(int st, int dr){
			left = st;
			right = dr;
		}
	}
	
	static Long getSize(List<Limits> ls)
	{
		int i;
		Long sum = Long.valueOf(0);
		for(i = 0;i<ls.size();i++)
			sum += ls.get(i).right - ls.get(i).left + 1;
		return sum;
	}
	
	static void modifyLimits(int newSt, int newDr, List<Limits> ls)
	{		
		int i, left, right;
		for(i = 0;i<ls.size();i++)
		{
			left = ls.get(i).left;
			right = ls.get(i).right;
			if(newSt >= left && newDr <= right)
				return;				
			if(newSt >= left && newSt <= right){
				ls.get(i).right = newDr;	
				return;
			}
			else if(newDr >= left && newDr <= right){
				ls.get(i).left = newSt;
				return;
			}
			else if(newSt < left && newDr > right)
			{
				ls.get(i).right = newDr;
				ls.get(i).left = newSt;
				return;
			}
		}
		if(i == ls.size())
			ls.add(new Limits(newSt,newDr));
	}
	
	static Long gridlandMetro(int n, int m, int k, int[][] track) 
	{
		    if(k == 0)
			   return Long.valueOf(n)*Long.valueOf(m);
		    
	        int i,j,x, crt, left, right;
	        Long sum = Long.valueOf(0);
	        Arrays.sort(track, 
	            new Comparator<int[]>() 
	            {            
	                @Override              
	                public int compare(final int[] e1, final int[] e2) 
	                {      
 	                	if(e1[0] != e2[0]){
 	                		if(e1[0] > e2[0])
 	                			return 1;
 	                		return -1;
 	                	}
 	                	if(e1[2] - e1[1] > e2[2] - e2[1])
 	                		return -1;
 	                	else 
 	                		return 1;	                                            
	                }
	              });
	      //  System.out.println(Arrays.deepToString(track).replace("],", "]\n"));	
	        
	      	crt = track[0][0];
	        List<Limits> ls = new ArrayList<Limits>();
	        for(i = 0;i<k;i++)
	        {
	        	left = track[i][1]; 
	        	right = track[i][2];
	            if(track[i][0] == crt)
	            {
	            	if(ls.size() == 0)
	            		ls.add(new Limits(left, right));
	            	else {
	            		x = ls.size();	
	            		for(j = 0; j<x; j++)
	            			modifyLimits(left,right,ls);	            				
	            	}
	            }
	            else {
	                crt = track[i][0];
	                sum += getSize(ls);
	                ls.clear();
	                i--;
	            }	            
	        }
	        sum += getSize(ls);
	        return Long.valueOf(n)*Long.valueOf(m)-sum;
	    }
}
