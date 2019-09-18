public class Sol 
{
	static String timeInWords(int h, int m) 
	 {
	        String[] hours = {"can't reach","one","two","three","four","five",
	                         "six","seven","eight","nine","ten",
	                         "eleven","twelve","thirteen","fourteen","quarter","sixteen",
	                         "seventeen","eighteen","nineteen","twenty","twenty one",
	                         "twenty two","twenty three","twenty four","twenty five",
	                         "twenty six","twenty seven","twenty eight","twenty nine"};
	        
	        if(m < 30){
	            if(m == 0){
	                return hours[h]+" o' clock";
	            }
	            if(m == 15){
	                return "quarter past "+hours[h];
	            }
	            if(m == 1)
	                return hours[m]+" minute past "+hours[h];            
	            return hours[m]+" minutes past "+hours[h];
	        }
	        if(m >= 30){           
	            if(m == 30){
	                return "half past "+hours[h];
	            }
	            if(h == 12)		// wrap time
	                h = 0;
	            if(m == 45){
	                return "quarter to "+hours[h+1];
	            }
	            return hours[60-m]+" minutes to "+hours[h+1];
	        }
	        return "can't reach";
	    }
}