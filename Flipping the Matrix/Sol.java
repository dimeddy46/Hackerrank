public class Sol
{
    static int max(int a, int b){
        return Math.max(a,b);
    }
    static int flippingMatrix(int[][] matrix) 
    {
        int i,j, sum = 0,n = matrix.length / 2, len = matrix.length-1;
        for(i = 0;i < n;i++)
            for(j = 0;j < n;j++)
                sum += max( max(matrix[i][j], matrix[i][len-j]), 
                            max(matrix[len-i][j], matrix[len-i][len-j])
                          );
        return sum;
    }
}