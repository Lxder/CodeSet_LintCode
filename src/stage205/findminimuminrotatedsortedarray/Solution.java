package stage205.findminimuminrotatedsortedarray;
public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
	public static void main(String args[]){
		int[] num = {0,1,2,3,4,5,6};
		System.out.println(findMin(num));
	}
    public static int findMin(int[] num) {
        // write your code here
    	int low = 0 ;
    	int len = num.length ;
    	if(len==1) return num[0];
    	int high = len-1;
    	if(num[low]<=num[high]) return num[low];
    	while(low<=high){
    		if(num[low]<=num[high]) break;    		
    		int mid = (low+high)/2;   		
    		System.out.println(num[low]+" "+num[mid]+" "+num[high]);
    		if(num[low]<num[mid]){
    			low = mid;
    		}else{
    			high = mid;
    		}
    		
    	}
    	return Math.min(num[low], num[low+1]);
    }
}
