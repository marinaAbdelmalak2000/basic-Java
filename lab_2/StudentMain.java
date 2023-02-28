class Student {
	
	private String name;
	private int age;
	private String track;
	
	Student (){
		name=" ";
		age=0;
		track="  ";
		System.out.println("Defult constructor is calling.");
		
	}
	
	Student (String name,int age,String track){
		this.name=name;
		this.age=age;
		this.track=track;
		System.out.println("constructor with three parameters is calling");
		
	}
	
	//setters
	public void setName(String name){
		
		this.name=name;
		
	}
	
	public void setAge(int age){
		
		this.age=age;
	}
	
	public void setTrack(String track){
		
		this.track=track;
	}
	
	//getters
	public String getName(){
		
		return name;
	}
	
	public int getAge(){
		
		return age;
	}
	
	public String getTrack(){
		
		return track;
	}
	
	
}

public class StudentMain{
	
	public static void main (String args[]){
		
		Student studentObj1=new Student();
		
		studentObj1.setName("sherry");
		studentObj1.setAge(26);
		studentObj1.setTrack("java");
		System.out.println("student 1--> name :"+studentObj1.getName()+", age :"+
		studentObj1.getAge()+", track :"+studentObj1.getTrack());
		
		Student studentObj2=new Student("marina",23,"mobile");
		System.out.println("student 2--> name :"+studentObj2.getName()+", age :"+
		studentObj2.getAge()+", track :"+studentObj2.getTrack());
		
	}
	
public static void helloStudent(String message){
	System.out.println("Hello");
	
}
	
}
