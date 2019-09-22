public class Sol
{
	static int nonDivisibleSubset(int k, int[] S) 
    {
		    if(k == 2)		// a subset divisible by 2, bigger than 2( a even + a odd number), doesn't exist
		        return 2;
		        			// to get non divisible subsets, divide the input into k variables 
		    int[] occ = new int[k];	// which will represent the number of occurences sorted by reminder
		    int i,total = 0, par = k%2 == 0? 1 : 0, fin = k/2 - par;
		    				// arranging the input array by reminder because adding any 2 elements together
		    for(i = 0; i<S.length;i++)	// will be divisible by k, ONLY IF their reminders add to k :
		        occ[S[i] % k]++;	// (ex. given k = 12, anything divided by k with reminder 2, added with 
		    				// something div. by k with reminder 10, will be divisible, so this pairing must be avoided.
		                  				
		    for(i = 1; i<=fin;i++)	// Excluding the first element(number of divisible by k occurences, must appear only once) 
		    {				// and the middle element(k/2, which also can't appear more than 
		        if(occ[i] > occ[k-i])	// once in a subset because adding this (or the divisible occurences) twice, will cause pairing).
		            total += occ[i];	// This FOR gets the maximum occurences of the current position(i) which paired with the 
		        else 			// opposite(k - i) would result in a divisible addition. So by getting ONLY the maximum
		            total += occ[k-i];	// between the 2, until the middle, will result in the partial number of 
		    }   			// non divisible subsets.
		     
		    if(par == 1)              
		        return total + (occ[k/2]>0? 1 : 0) + (occ[0]>0? 1 : 0);	// partial because it is needed to add the excluded elements
		    								// to the total. Add 1 element divisible by k, if available.
		     return total + (occ[0]>0? 1 : 0);				// Add 1 element divisible by k/2, if available.
		   
    }
}
