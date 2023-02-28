class DrawPattern{
	public static void main(String[] args)
	{
		String str = "    ";
		int x = 0;
		int y = 8;
		int index;
		for(index = 0 ; index<4 ; index++){
			
			str = str.substring(0, index) + "*"
              + str.substring(index + 1);
			
			str = str.substring(0, 4) + "        " ;
			
			switch (index){
			case 0:
				str = str.substring(0, y) + "*" + str.substring(y + 1); 
				
				
				
			break;
			case 1:
				str = str.substring(0, y-1) + "*" + str.substring(y-1 + 1);
				str = str.substring(0, y+1) + "*" + str.substring(y+1 + 1);
			break;
			case 2:
				str = str.substring(0, y) + "*" + str.substring(y + 1);
				str = str.substring(0, y-2) + "*" + str.substring(y-2 + 1);
				str = str.substring(0, y+2) + "*" + str.substring(y+2 + 1);
			break;
			case 3:
				str = str.substring(0, y-1) + "*" + str.substring(y-1 + 1);
				str = str.substring(0, y+1) + "*" + str.substring(y+1 + 1);
				str = str.substring(0, y-3) + "*" + str.substring(y-3 + 1);
				str = str.substring(0, y+3) + "*" + str.substring(y+3 + 1);
			break;
			}  
			
			System.out.println(str);
		} 
	}
}