
public class Sol 
{
	static int getColorNum(int[][] container, int col){
        int s = 0;
        for(int i = 0;i < container.length;i++)
            s += container[i][col];
        return s;
    }

    static int getContainerCap(int[][] container, int line)
    {
        int s = 0;
        for(int i = 0;i < container.length;i++)
            s += container[line][i];
        return s;
    }
    
    static String organizingContainers(int[][] container) 
    {
            int i, n = container.length;
            int[] caps = new int[n], colors = new int[n];
             
            for(i = 0;i < n;i++){
                caps[i] = getContainerCap(container,i); 
                colors[i] = getColorNum(container, i);
            }
            
            Arrays.sort(caps);
            Arrays.sort(colors);
            
            for(i = 0;i < n;i++)
                if(caps[i] < colors[i])
                    return "Impossible";
                    
            return "Possible";
    }