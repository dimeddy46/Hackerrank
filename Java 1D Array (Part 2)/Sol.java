import java.util.EmptyStackException;
import java.util.Stack;

public class Sol {
	
	 static public class LeftToGo{
    	int left, right;
    	public LeftToGo(){
    		left = -1;
    		right = -1;
    	}
    }
    public static boolean canWin2(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
    	Stack<Integer> st = new Stack<Integer>(); 
    	int crt = 0, end = 0, i, n = game.length - 1, pm;
    	
        LeftToGo[] pasi = new LeftToGo[n+1];
        for(i = 0;i<=n;i++)
        	pasi[i] = new LeftToGo();
        
        while(end == 0)
        {	
        	if(pasi[crt].left == -1 && crt > 0 && game[crt-1] == 0)
        		pasi[crt].left = 1;
        		
        	if(pasi[crt].right == -1 && crt + 1 <= n && game[crt+1] == 0)
        		pasi[crt].right = 1;		       		        		        		        
        	
        	if(crt + leap > n || crt == n)return true;
        	else if(game[crt+leap] == 0 && leap != 0 && (pasi[crt].left != 0 || pasi[crt].right != 0)){
        		st.push(crt);
        		crt += leap;
        		st.push(crt);
        	}
        	else if(crt > 0 && pasi[crt].left == 1){
        		pasi[crt].left = 0;
        		pasi[--crt].right = 0;
        	}
        	else if(pasi[crt].right == 1){
        		pasi[crt].right = 0;
        		pasi[++crt].left = 0;
        	}
        	else {
        		try{	        			
        			while(true)
        			{	        				
        				pm = st.peek();
        				if(pasi[pm].left == 1){
        					pasi[pm].left = 0;
        					pasi[pm-1].right = 0;
        					crt = pm -1; 
        					break;
        				}
        				else if(pasi[pm].right == 1){
        					pasi[pm].right = 0;
        					pasi[pm+1].left = 0;
        					crt = pm +1;
        					break;
        				}	        				        				
        				st.pop();
        			}
        		}
        		catch(EmptyStackException ex){
        			return false;
        		}
        	}
        }
        return true;
    }
}
