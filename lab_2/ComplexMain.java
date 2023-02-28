class Complex {
	
	private float real ;
	private float imag ;
	
	Complex (){
		
		real=imag=0;
		System.out.println("Defult constructor is calling.");
		
	}
	
	Complex(float r){
		
		real=imag=r;
		System.out.println("constructor with one parameters is calling");
		
	}
	
	Complex(float real,float imag){
		
		this.real=real;
		this.imag=imag;
		System.out.println("constructor with two parameters is calling");
		
	}
	
	//setters
	public void setReal(float real){
		this.real=real;
		
	}
	public void setImag(float imag){
		this.imag=imag;
		
	}
	
	//getters
	public float getReal(){
		
		return real;
	}
	
	public float getImag(){
		
		return imag;
	}
	
	//add
	public Complex add(Complex c){
		
		Complex temp=new Complex();
		temp.real=real+c.real;
		temp.imag=imag+c.imag;

		return temp;
	}
	
	//sub
	public Complex sub(Complex c){
		
		Complex temp=new Complex();
		temp.real=real-c.real;
		temp.imag=imag-c.imag;

		return temp;
	}
	
	//print 
	public void print(){
		
		if(imag<0){
			
			imag=-1*imag;
			System.out.println(real+" - "+imag+"i ");
			
		}
		else if(imag==0.0){
			
			System.out.println(real);
		}
		else{
			
			System.out.println(real+" + "+imag+"i ");
			
		}
		
	}
	
}

public class ComplexMain{
	
	public static void main (String []args){
		
		Complex complexObj1=new Complex();
		Complex complexObj2=new Complex(5);
		Complex complexObj3=new Complex(3,4);
		
		complexObj1.setReal(7);
		complexObj1.setImag(5);
		complexObj3=complexObj1.add(complexObj2);
		
		complexObj3.print();
		
		complexObj3=complexObj1.sub(complexObj2);
		
		complexObj3.print();
		
	}
	
}