package stage603.ReverseWordsinaString;
public class Solution {
	public static void main(String args[]){
		System.out.println("|"+reverseWords2("")+"|");
	}
	
	
    /**
     * @param s : A string
     * @return : A string
     */
    public static String reverseWords(String s) {
        // write your code
    	String str = s.trim(); //ȥ����β�ո�
    	StringBuffer sb = new StringBuffer();
    	String[] arr = str.split("\\s+");
    	for(int i = 0 ;  i < arr.length ; i++){
    		sb.insert(0, arr[i]+" ");
    	}
    	return sb.toString().trim();
    	
    }
    
    public static String reverseWords2(String s) {
    	String str = s.trim(); //ȥ����β�ո�
    	StringBuffer solu = new StringBuffer();
    	StringBuffer sb = new StringBuffer();
    	
    	int len = str.length();
    	char curr ; 
    	if(len==0) return "";
    	char pre = str.charAt(0);
    	sb.append(pre);
    	for(int i = 1; i < len ; i++ ){
    		curr = str.charAt(i);
    		if(curr==' '){
    			if(pre==' ') continue;
    			else{ 
    				solu.append(sb.reverse()+" ");
    				sb = new StringBuffer();   			
    			}
    		}else
    			sb.append(curr);
    		pre = curr;
    	}
    	solu.append(sb.reverse());
    	return solu.reverse().toString();
    }
    
    
public String ReverseSentence(String str) {
        
    	StringBuffer solu = new StringBuffer();
    	StringBuffer sb = new StringBuffer();
    	
    	int len = str.length();
    	char curr ; 
    	if(len==0) return "";
    	sb.append(str.charAt(0));
    	for(int i = 1; i < len ; i++ ){
    		curr = str.charAt(i);
    		if(curr==' '){
    				solu.append(sb.reverse()+" ");
    				sb = new StringBuffer();   			
    		
    		}else
    			sb.append(curr);
    	}
    	solu.append(sb.reverse());
    	return solu.reverse().toString();
    }
}


/*
���ʵĹ��ɣ��޿ո���ĸ����һ������
�����ַ����Ƿ����ǰ������β��ո񣿿��԰��������Ƿ�ת����ַ����ܰ���
��δ����������ʼ�Ķ���ո��ڷ�ת�ַ����м�ո���ٵ�ֻ��һ��
*/