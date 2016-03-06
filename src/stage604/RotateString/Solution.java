package stage604.RotateString;
public class Solution {
	public static void main(String args[]){
		char[] str = {'a','b','c','d','e','f','g'};
		Solution s = new Solution();
		s.rotateString(str, 8);
	}
    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
    	int len = str.length;
    	if(len==0) return;
    	offset = offset%len;
    	if(offset==0) return;
    	myreverse(str,0,len-offset-1);
    	myreverse(str,len-offset,len-1);
    	myreverse(str,0,len-1);
    }
    
    public void myreverse(char[] str,int start , int end){
    	char temp;
    	for(int i = start , j = end ; i< j  ; i++ , j--){
    		temp = str[i];
    		str[i] = str[j];
    		str[j] = temp;
    	}
    }
}
