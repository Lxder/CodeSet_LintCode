package stage204.singleton;
class Solution {
    /**
     * @return: The same instance of this class every time
     */
	static Solution mysingle ;
    public static Solution getInstance() {
        // write your code here
    	if(mysingle==null)
    		mysingle = new Solution();
    	return mysingle;
    }
};
