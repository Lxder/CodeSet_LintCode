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
		
		//���ڻ�û��
		for(int i = 0 ; i < k && i < nums.length ; i++){
			while(!idx.isEmpty() && nums[idx.get(idx.size()-1)]<nums[i]){
				idx.remove(idx.size()-1); 
			}
			idx.add(i);
		}

		//�����Ѿ�����
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
	
	//�������������ڵ����ֵ���Ǳ����ڶ����ײ�������������������ǴӴ�С����
    public static ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
    	ArrayList<Integer> solu = new ArrayList<Integer>();
    	
    	if(nums==null || nums.length==0 || k<1) return solu;
    	
    	//ע�� ���˫�˶��д�ŵ����±�
    	Deque<Integer> queue = new LinkedList<Integer>();
    	
    	//���ڻ�û�������������ֵ����
    	for(int i = 0 ; i < k && i < nums.length ; i++){
    		while(!queue.isEmpty() && nums[i]>nums[queue.getLast()]){
    			queue.removeLast(); //���
    		}    		
    		//�������
    		queue.addLast(i);    			
    	}
    	
    	//�����Ѿ�����
    	for(int i = k ; i < nums.length ; i++){
    		//�����һ�����ڵ����ֵ
    		solu.add(nums[queue.getFirst()]);
    		while(!queue.isEmpty()&&nums[i]>nums[queue.getLast()]){
    			queue.removeLast();
    		}
    		
    		//���������������ƣ�ɾ���ʼ��
    		if(!queue.isEmpty() && queue.getFirst()<=( i-k))
    			queue.pollFirst();
    		
    		//�µ������봰�ڣ���ʱ������ܱ�֤�����ڵ��±��Ӧ�����ǵݼ���
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

