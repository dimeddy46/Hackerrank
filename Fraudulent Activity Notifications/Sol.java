import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sol
{
	static void addAndRemove(List<Integer> med, int valRemove, int valAdd, int d)
	{
		int left = 0, right = d, i;
		
		// --------------------- remove element --------------
		while(left <= right)
		{
			i = (left+right)/2;
			if(med.get(i) == valRemove)
			{
				med.remove(i);
				break;
			}
			else if(valRemove > med.get(i))
				left = i+1;			 
			else 
				right = i-1;
		}
		
		// --------------------- add element ---------------
		left = 0;
		right = d - 1;		
		while(left <= right)
		{
			i = (left+right)/2;
			if(left == right)
			{
				med.add(i, valAdd);
				break;
			}
			else if(valAdd > med.get(i)) 
				left = i+1;			
			else 
				right = i;				
		}	
	}
	static double median(List<Integer> med, int d)
	{
		if(d % 2 == 1)
			return med.get(d / 2);
		else
			return (med.get(d / 2) + med.get(d / 2 -1)) / 2.0;
	}
	
	static int activityNotifications(int[] expenditures, int d){
		int notif = 0,i;
		List<Integer> sorted = new ArrayList<>();
		
		for(i = 0;i<d;i++)
			sorted.add(expenditures[i]);
		
		Collections.sort(sorted);
		for(i = d;i<expenditures.length;i++)
		{
			if(expenditures[i] >= median(sorted,d)*2)
				notif++;
			addAndRemove(sorted, expenditures[i-d], expenditures[i], d);
		}
		return notif;
	}
}