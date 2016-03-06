package stage605.SearchforaRange;
public class Solution {
	public static void main(String args[]){
		int[] A = {1,10,1001,201,1001,10001,10007};
		new Solution().searchRange(A,10008);
	}
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public static int searchl(int[] A, int target) {
        // write your code here
    	int len = A.length;
    	int low = 0 ; 
    	int high = len-1;
    	int mid ;
    	while(low<=high){
    		mid = (low+high)/2;
    		if(A[mid]>=target) high = mid-1;
    		else low = mid+1;
    	}
    	
    	if(len==0||low>=len||A[low]!=target) return -1;
    	return low; 
    }
    
    public static int searchr(int[] A, int target) {
        // write your code here
    	int len = A.length;
    	int low = 0 ; 
    	int high = len-1;
    	int mid ;
    	while(low<=high){
    		mid = (low+high)/2;
    		if(A[mid]>target) high = mid-1;
    		else low = mid+1;
    	}
    	
    	if(len==0||high<0||A[high]!=target) return -1;
    	return high; 
    }
    
    public int[] searchRange(int[] A, int target) {
        // write your code here
    	
    	return new int[]{searchl(A,target),searchr(A,target)};
    }
}

