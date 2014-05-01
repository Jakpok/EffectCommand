package pl.minefun.effectcommand;

public class MathUtil {
	
    public static boolean isInt(String s) {
        try {
            int i = Integer.parseInt(s);
            if(i > 0){
                return true;
            }
        } catch (NumberFormatException nfe) {
            return false;
        }
        return false;
    }
    
    public static int toInt(String s){
    	int i = Integer.parseInt(s);
    	return i;
    }

}
