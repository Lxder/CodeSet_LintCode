package stage213.FindMinimuminRotatedSortedArrayII160;
public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
	public static void main(String args[]){
		int[] num = {2,1,2,2,2};
		System.out.println(findMin(num));
	}
    public static int findMin(int[] num) {
        // write your code here
    	int len = num.length;
    	if(len==1) return num[0];
    	int low = 0 ;
    	int high = len-1;
    	if(num[low]<num[high]) return num[low];
    	while(low<high){
    		while(low<=high&&num[low]==num[low+1]) low++;
    		while(low<=high&&num[high]==num[high-1]) high--;
    		if(num[low]<num[high]) break;    		
    		int mid = (low+high)/2;   		
    		System.out.println(num[low]+" "+num[mid]+" "+num[high]);
    		if(num[low]<num[mid]){
    			low = mid;
    		}else{
    			high = mid;
    		}
    		
    	}
    	System.out.println(low+" "+high);
    	return Math.min(num[low], num[low+1]);
    }
}
