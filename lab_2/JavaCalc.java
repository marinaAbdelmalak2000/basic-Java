public class JavaCalc{
	
	public static void main (String[] args){
		if(args.length==3){
		
			String operant1=args[0];
			String operator=args[1];
			String operant2=args[2];
			
			int number1=Integer.parseInt(operant1); 
			int number2=Integer.parseInt(operant2);  		
			
			int result=0;
			
			switch(operator){
				
				case "+":
					result=number1+number2;
					break;
				case "-":
					result=number1-number2;
					break;
				case "x":
					result=number1*number2;
					break;
					
				case "/":
					if(number2==0){
						System.out.println ("can dot divid into zero, try again.");
					}
					else
					{result=number1/number2;}
					break;
				default:
					System.out.println ("Please, try again.");
			}
			
			System.out.println(number1+" "+operator+" "+number2+" = "+result);
			}
			else{
				
				System.out.println ("Please, input 3 again.");
			}
		
	}
	
	
}