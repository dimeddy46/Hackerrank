
public class Sol {
	
    static int[][] getSquare(int x, int[][] sq){
       int i,j;
       int[][] rez = new int[3][3];
       
       x *=3;       
       for(i = 0;i<3;i++)
           for(j = x;j<x+3;j++)
               rez[i][j-x] = sq[i][j];
       return rez;
   }
   static int getDifference(int[][] x, int[][] sq){
       int i,j, sum = 0;

       for(i = 0;i<3;i++) 
           for(j = 0;j<3;j++)
               sum += Math.abs(sq[i][j] - x[i][j]);
       
       return sum;
   }
    static int formingMagicSquare(int[][] s) {
	int i, j, min = 100,x;
        int[][] good = new int[3][3];      
        int[][] sq = {
               {8,1,6, 6,1,8, 2,9,4, 4,9,2, 4,3,8, 8,3,4, 6,7,2, 2,7,6},
               {3,5,7, 7,5,3, 7,5,3, 3,5,7, 9,5,1, 1,5,9, 1,5,9, 9,5,1},
               {4,9,2, 2,9,4, 6,1,8, 8,1,6, 2,7,6, 6,7,2, 8,3,4, 4,3,8}
        };

        for(i = 0;i<8;i++)
        {
          good = getSquare(i,sq);
          if((x = getDifference(s,good)) < min)
              min = x;          
        }
        return min;
    }
}
