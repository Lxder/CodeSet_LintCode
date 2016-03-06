package stage809.SlidingWindowMaximum;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
	
	public static void main(String args[]){
		int[] nums = {1,2,7,7,2,10,3,4,5};
		System.out.println(maxSlidingWindow2(nums,2));
		
	}
	
	public static ArrayList<Integer> maxSlidingWindow2(int[] nums, int k) {
		ArrayList<Integer> solu = new ArrayList<Integer> ();
		if(nums == null || nums.length == 0 || k <=0 ) return solu;

		ArrayList<Integer> idx = new ArrayList<Integer>();
		
		//窗口还没满
		for(int i = 0 ; i < k && i < nums.length ; i++){
			while(!idx.isEmpty() && nums[idx.get(idx.size()-1)]<nums[i]){
				idx.remove(idx.size()-1); 
			}
			idx.add(i);
		}

		//窗口已经满了
		for(int i = k ; i < nums.length ; i++){
			solu.add(nums[idx.get(0)]);
			while(!idx.isEmpty() && nums[idx.get(idx.size()-1)]<nums[i]){
				idx.remove(idx.size()-1);
			}

			if(!idx.isEmpty()&&idx.get(0)<=i-k)
				idx.remove(0);
			idx.add(i);
		}
		solu.add(nums[idx.get(0)]);
		return solu;

	}
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
	
	//方法：滑动窗口的最大值总是保存在队列首部，队列里面的数据总是从大到小排列
    public static ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
    	ArrayList<Integer> solu = new ArrayList<Integer>();
    	
    	if(nums==null || nums.length==0 || k<1) return solu;
    	
    	//注意 这个双端队列存放的是下标
    	Deque<Integer> queue = new LinkedList<Integer>();
    	
    	//窗口还没有填满，找最大值索引
    	for(int i = 0 ; i < k && i < nums.length ; i++){
    		while(!queue.isEmpty() && nums[i]>nums[queue.getLast()]){
    			queue.removeLast(); //如果
    		}    		
    		//添加索引
    		queue.addLast(i);    			
    	}
    	
    	//窗口已经填满
    	for(int i = k ; i < nums.length ; i++){
    		//保存第一个窗口的最大值
    		solu.add(nums[queue.getFirst()]);
    		while(!queue.isEmpty()&&nums[i]>nums[queue.getLast()]){
    			queue.removeLast();
    		}
    		
    		//数量超过窗口限制，删除最开始的
    		if(!queue.isEmpty() && queue.getFirst()<=( i-k))
    			queue.pollFirst();
    		
    		//新的数加入窗口，这时候加入能保证窗口内的下标对应数字是递减的
    		queue.add(i);
    	}
    	
    	solu.add(nums[queue.getFirst()]);
    	
    	int[] solu_arr = new int[solu.size()+1-k];
    	for(int i = 0 ; i< solu.size() ; i++){
    		solu_arr[i] = solu.get(i);
    	}
    	return solu;
    
    	
    }
}

