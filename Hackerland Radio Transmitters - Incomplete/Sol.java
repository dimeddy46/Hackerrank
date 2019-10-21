import java.util.Arrays;

public class Sol {
	static class Cover
	{
		int total, poz;
		
		public Cover(int t, int p){
			total = t;
			poz = p;
		}
		public String toString(){
			return "TOTAL:"+total+" POZ:"+poz;
		}		
	}
	
	static int[] removeCovered(int[] x, int p, int k){
		int i = p - 1, tot = 0;
		while(i >= 0 && x[i] != -1 && x[p] - x[i] <= k) // left check
		{	
			x[i] = -1; tot++;
			i--;
		}
		i = p + 1;
		while(i < x.length && x[i] != -1 && x[i] - x[p] <= k) // right check
		{	
			x[i] = -1; tot++;
			i++;
		}
		x[p] = -1;
		return new int[]{tot+1,i};
	}
	
	static Cover getCoverage(int[] x, int p, int k)
	{
		int i = p - 1,cov = 0;		
		while(i >= 0 && x[i] != -1 && x[p] - x[i] <= k) // left check
		{				
			i--; cov++;
		}
		i = p + 1;
		while(i < x.length && x[i] != -1 && x[i] - x[p] <= k) // right check
		{	
			i++; cov++;
		}		
		return new Cover(cov,p);
	}
	
    static int hackerlandRadioTransmitters(int[] x, int k) 
    {
		int i = 0, rem = 0, fn = 0;
		int[] exp = new int[2];
		Cover max,pr;
		Arrays.sort(x);
		
		while(rem != x.length)
		{
			max = new Cover(0,100001);
			for(i = 0;i<x.length;i++)
			{
				if(x[i] != -1)
				{
					pr = getCoverage(x,i,k);
					if(pr.total == 0) 
					{
						fn++;
						if(++rem == x.length)
							return fn;							
						x[pr.poz] = -1;												
					}
					else if(pr.total >= max.total)
					{
						if(pr.total != max.total)
							max = pr;
						else if(pr.poz < max.poz)
							max = pr;
						if(pr.total == 2*k)
							break;
					}
				}
			}			
			exp = removeCovered(x,max.poz,k);
			rem += exp[0];
			//i = exp[1];
			fn++;			
		}
		return fn;
    }
}
