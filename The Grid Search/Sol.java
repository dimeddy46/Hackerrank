public class Sol
{
	static boolean check(String[] G, String[] P, int line, int index){
		int i, len = P[0].length(), crt = 0;
		String test;
		for(i = line; i<line + P.length - 1;i++){
			test = G[i].substring(index, index+len);
			if(!test.equals(P[++crt]))
				return false;
		}
		return true;
	}
	static String gridSearch(String[] G, String[] P){
		int i,j, step = 0, from = 0, len = G[0].length();
		for(i = 0;i<=G.length-P.length;i++)
		{
			step = G[i].indexOf(P[0],from);
			if(step != -1)
			{
				if(check(G, P, i+1, step))
					return "YES";
				else 
				{
					from = step+1;
					if(from >= len-1)
						from = 0;
					else 
						i--;
				}
			}
			else from = 0;
		}
		return "NO";
	}
}