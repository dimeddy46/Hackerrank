import java.util.Arrays;

public class Sol 
{
	static long checkMax(long a, long b, long m, long max)
	{
		long x = subMod(a,b,m);
		if(x == m-1)
			return -1;
		else 
			return max<x? x:max;
	}
	
	static long subMod(long a, long b, long m){
		return Math.floorMod(a-b, m);
	}
	
	static long maximumSum(long[] a, long m)
	{
		if(a.length == 1)
			return a[0] % m;
		long[] b = new long[a.length-1];
		long max = 0;
		int i,j;
		
		max = a[0] = checkMax(a[0],0,m,max); 
		b[0] = subMod(a[0],-a[1],m); // perform addition
		if((max = checkMax(b[0],0,m,max)) == -1)
			return m-1;
		
		for(i = 1;i<a.length-1;i++)
		{
			a[i] = subMod(a[i],0,m); 
			if((max = checkMax(a[i],0,m,max)) == -1)
				return m-1;
						
			b[i] = subMod(b[i-1],-a[i+1],m);  
			if((max = checkMax(b[i],0,m,max)) == -1)				
				return m-1;										
		}
		
		for(i = 1;i<b.length;i++)
		{		
			if((max = checkMax(b[i],a[0],m,max)) == -1)
				return m-1;	
			
			for(j = 0;j<i-1;j++)			
				if((max = checkMax(b[i],b[j],m,max)) == -1)
					return m-1;								
		}
		return max;
	}
}
