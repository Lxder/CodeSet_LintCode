package stage606.TwoSum56;


public class Solution {
	public static void main(String args[]){
		int[] nums ={1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99};
		new Solution().twoSum(nums,-64);
	}
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
    	
    	int len = numbers.length;
    	int iarr[] = new int[len];
    	for(int i = 0 ; i < len ;i++){
    		iarr[i] = i+1;
    	}
    	MyQuickSort(numbers,iarr,0,len-1);
    	for(int i = 0 ; i < len ;i++){
    		System.out.println(iarr[i]);
    	}
    	int start = 0;
    	int end = numbers.length-1;
    	int sum = 0;
    	while(start<end){
    		sum = numbers[start]+numbers[end];
    		if(sum<target) start++;
    		else if(sum>target)end--;
    		else break;
    	}
    	System.out.println(iarr[start]+" "+iarr[end]);
    	return new int[]{Math.min(iarr[start],iarr[end]),Math.max(iarr[start],iarr[end])};
    }
    
    public void MyQuickSort(int[] a,int[] index,int left,int right){
        if(left>right)
            return;
        int key = a[left];    //设定最左边的元素为key
        int tempi = index[left];
        int low = left;
        int high = right;
        System.out.println(key);
        while(low<high){
            while(low<high && a[high]>key)    
                high--;
            a[low]=a[high];
            index[low] = index[high];
            while(low<high && a[low]<=key)
                low++;
            a[high]=a[low];
            index[high] = index[low];
            System.out.println(key);
        }
        a[low]=key;//将Key最终放在这个位置，左边的元素均比key小，右边的元素均比key大
        index[low] = tempi;
        MyQuickSort(a,index, left, low-1);
        MyQuickSort(a,index, low+1, right);
        
    }
}
