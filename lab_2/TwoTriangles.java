public class TwoTriangles{
	
	public static void main(String [] args){
		
		String inputLenght=args[0];
		int n=Integer.parseInt(inputLenght); 
		System.out.println(n);
		
		/*int i, k, flag = 1;
     
    // Loop to handle number of rows and
    // columns in this case
    for(i = 1, k = 0; i <= 2 * n - 1; i++)
    {
         
        // Handles case 1
        if (i < n - k)
            System.out.print("#");
 
        // Handles case 2
        else
        {
            if (flag == 1)
                System.out.print("*");
            else
                System.out.print("#");
 
            flag = 1 - flag;
        }
 
        // Condition to check case 3
        if (i == n + k)
        {
			 k++;
            System.out.println();
             
            // Since for nth row we have
            // 2 * n- 1 columns
            if (i == 2 * n - 1)
                break;
 
            // Reinitializing i as 0,
            // for next row
            i = 0;
            flag = 1;
        }
    }*/
		
		
	/*	for(int i=0;i<lenghtTriangle;i++){
			
			for(int j=0;j<lenghtTriangle*3;j++){
				
				if(j<=i){
					
					System.out.print("*");
					
				}
				else if( (j>=((lenghtTriangle*2)-1)-i)&&(j<=((lenghtTriangle*2)-1)+i)){
					System.out.print("*");
					
				}
				else{
					System.out.print(" ");
					
				}
				
			}
			
			System.out.println("\n");
			
		}
		*/
		int i,j;
		for( i=0, j=n*2;j<=n*2;j--,i++){
			
			
			if(i==(j-(n*2))){System.out.print("*");}
			if(i<=n){System.out.print("#");}
			
			if(i==n*2){System.out.println();}
			//continue;
			
			
		}
		

		
	/*	for(int i=0;i<lenghtTriangle;i++){
			
			for(j){}
			for(int j=0;j<lenghtTriangle*3;j++){
				
				System.out.println(" ");
				
			}
			
			System.out.println("\n");
			
		}*/
		
		
		
		
	
		
		
	}
	
}