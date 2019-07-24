
public class Sol 
{
	static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) 
	{
        int i,j, r,c, sum = 0;
        int[] fin = new int[8];

        fin[1] = fin[3] = n+1;       
        fin[0] = r_q+c_q > n + 1? n+1 : r_q+c_q;//r        
        fin[4] = r_q+c_q < n + 1? 0 : r_q - (n - c_q) -1;//r        
        fin[6] = r_q >= c_q? 0 : c_q - r_q;//c        
        fin[2] = r_q >= c_q? n - r_q + c_q + 1 : n+1;//c

        for(i = 0;i<k;i++)
        {
            r = obstacles[i][0];
            c = obstacles[i][1];
            if(c == c_q) // vert
            {   
                if(r > r_q && fin[1] > r)
                    fin[1] = r;
                else if(r < r_q && fin[5] < r)
                    fin[5] = r;
            }
           else if(r == r_q) // horiz
            {   
                if(c > c_q && fin[3] > c)
                    fin[3] = c;
                else if(c < c_q && fin[7] < c)
                    fin[7] = c;
            }
           else if(r + c == r_q + c_q) // diag princ
            { 
                if(r > r_q && fin[0] > r)
                    fin[0] = r;
                else if(r < r_q && fin[4] < r)
                    fin[4] = r;
            }
           else if(Math.abs(r - r_q) == Math.abs(c - c_q))  // diag sec
           {
                if(c < c_q && fin[6] < c)
                    fin[6] = c;
                else if(c > c_q && fin[2] > c)
                    fin[2] = c;
           }
        }
      sum = fin[1] - r_q + 
            fin[3] - c_q +
            r_q - fin[5] +
            c_q - fin[7] +
            Math.abs(r_q - fin[0]) +        
            Math.abs(r_q - fin[4]) +   
            Math.abs(c_q - fin[6]) +       
            Math.abs(c_q - fin[2]) - 8; 
        return sum;
    }
}
