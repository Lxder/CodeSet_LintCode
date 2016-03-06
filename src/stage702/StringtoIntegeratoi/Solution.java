package stage702.StringtoIntegeratoi;
public class Solution {
	
	public static void main(String args[]){
		System.out.println(atoi("-111"));
		System.out.println(atoi("0000"));
		System.out.println(atoi("         15"));
		System.out.println(atoi("         1asdf67"));
		System.out.println(atoi("         2147483648"));
		System.out.println(atoi("         -2147483648"));
		System.out.println(atoi("         -2147483649"));
		System.out.println(atoi("+-5"));
		System.out.println(atoi("         010"));
		System.out.println(atoi("         -0121.10"));
		System.out.println(atoi(""));
	}
    /**
     * @param str: A string
     * @return An integer
     */
    public static int atoi(String str) {
        // write your code here
    	str = str.trim();
    	if(str.length() == 0) return 0;
    	boolean isPositive = true;
    	int start = 0;
    	long solu= 0;
    	if(str.charAt(0)=='-'){
    		isPositive = false;
    		start = 1; //修改起始位置
    	}else if(str.charAt(0)=='+'){
    		start = 1;
    	}
    	//先检查一遍，看有没有非数字的，
    	String[] arr = str.split("\\.");
    	if(arr.length>2) return 0;
    	
    	for(int i = start ; i < arr[0].length() ; i++){
    		char c = str.charAt(i);
    		if(c>'9' || c<'0') 
    				break;
    		solu = solu*10+(c-'0');
    		if(isPositive == true && solu>Integer.MAX_VALUE) return Integer.MAX_VALUE;
    		if(isPositive == false && solu>(long)(Integer.MAX_VALUE)+1) return Integer.MIN_VALUE;
    	}
    	if(isPositive==false) return -(int)solu;
    	return (int) solu;
    }
}
