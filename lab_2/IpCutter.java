import java.util.StringTokenizer;

public class IpCutter{
	
	public static void main(String [] args){
		
		String wordByDot=args[0];
		
		//way 1: split 
		String[] wordSplit=wordByDot.split("[.]");
		
		for(int i=0;i<wordSplit.length;i++){
			
			System.out.println(wordSplit[i]);
			
		}
		
		System.out.println("\n");
		//way 2: subString
		
		
		int start=0;
		int end=1;
		int count=1;
		int flag=0;
		String ip;
		
		while(count>0){
			end=args[0].indexOf('.',start);

			if(end<flag){
			ip=args[0].substring(start);
			System.out.println(ip);
			count=0;
			}

			else if(end>flag){
			ip=args[0].substring(start,end);
			System.out.println(ip);}

			else if(end==flag){
			ip=args[0].substring(start);
			System.out.println(ip);
			count=0;
			}

			flag=end;
			start=end+1;
		
		}
		
		System.out.println(" ");
		
		//way 3: StringTokenizer 
		
        StringTokenizer st = new StringTokenizer(args[0], "[.]");
        for (int i = 0; st.hasMoreTokens(); i++)
            System.out.println(st.nextToken());
	
		
	}
	
}