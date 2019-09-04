import java.util.Arrays;

public class Sol{
	static String biggerIsGreater(String w) {
        char[] s = w.toCharArray();
        char max = '~', c = 0, swp;
        int i, str, maxPoz = 0;
        
        for(i = s.length-1;i>0;i--)
        {            
            if(s[i] > s[i-1])
                break;
        }
        if(i == 0)
            return "no answer";
        else
        {
            str = i;
            char[] sub = new char[s.length-str];
            
            for(i = str;i<s.length;i++)
            {
                if(s[str-1] < s[i] && max > s[i])
                {
                    max = s[i];
                    maxPoz = (char)i;
                }                    
            }

            swp = s[maxPoz];
            s[maxPoz] = s[str-1];
            s[str-1] = swp;
            
            if(str != s.length-1)
            {
                for(i = str;i < s.length;i++)
                    sub[c++] = s[i];
                
                Arrays.sort(sub);
                c = 0;
                for(i = str;i < s.length;i++)
                {
                    s[i] = sub[c];
                    c++;
                }                
            }
            return new String(s);
        }
    }
}