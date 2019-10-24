import java.util.HashMap;

public class Sol 
{
    static int pairs(int k, int[] arr) 
    {
    	HashMap<Integer,Boolean> hm = new HashMap<Integer,Boolean>();
    	int i,total = 0,c = 0;
    	for(i = 0;i<arr.length;i++)
    	{
    		if(!hm.containsKey(arr[i]))
    			hm.put(arr[i], true);
    		if(hm.containsKey(arr[i]-k))
    			total++;
    		if(hm.containsKey(arr[i]+k))
    			total++;    		
    	}
    	return total;
    }
}
