public class Sol
{
	static String encryption(String s)
	{
		String pr = "";
		s = s.replaceAll(" ", "");
   
		int len = s.length(), r = 0, c = 0;
		int rows = (int)Math.floor(Math.sqrt(len));
		int cols = (int)Math.ceil(Math.sqrt(len));

		for(int i = 0;i < len;i++)
		{
		    pr += s.charAt(r);           
		    if((r += cols) >= len)
		    {
		        r = ++c;
		        pr += " ";
		    }
		}
		return pr;
	}
}