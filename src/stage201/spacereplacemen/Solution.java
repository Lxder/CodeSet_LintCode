package stage201.spacereplacemen;
public class Solution {
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
	
	public static void main(String args[]){
		char[] string = new char[20];
		string[0] = 'M';
		string[1] = 'R';
		string[2] = ' ';
		string[3] = 'J';
		string[4] = 'O';
		string[5] = 'H';
		string[6] = 'N';
		string[7] = ' ';
		string[8] = 'S';
		string[9] = ' ';
		string[10] = 'I';
		string[11] = 'T';
		string[12] = 'H';
		
		System.out.println(replaceBlank(string,13));
	}
    public static int replaceBlank(char[] string, int length) {
        // Write your code here
    	int spacenum = 0;
    	for(int i = 0 ; i < length ; i++){
    		if(string[i]==' '){
    			spacenum++;
    		}
    	}
    	int prenum = spacenum*2;
    	int newlen = length+prenum;
    	for(int i = length-1 ; i>=0 ; i--){
    		if(string[i]==' '){
    			prenum-=2;
    			string[i+prenum]='%';
    			string[i+prenum+1]='2';
    			string[i+prenum+2]='0';    			
    		}
    		else string[i+prenum] = string[i];
    	}
    	
    	for(int i = 0 ; i < newlen ; i++){
    		System.out.print(string[i]);
    	}
  
    	return newlen;
    }
}
