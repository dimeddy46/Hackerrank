
public class Sol 
{
    static int surfaceArea(int[][] A) 
    {
        int i,j, sum = 0, n = A.length,m = A[i].length;
        for(i = 0;i<n;i++)
        {         
            for(j = 0;j<m;j++)
                sum += 2*(2*A[i][j] +1)- 
                2*(j+1<m ?Math.min(A[i][j+1],A[i][j]):0)- 
                2*(i+1<n ?Math.min(A[i+1][j],A[i][j]):0);
        }
        return sum;
    }
}
