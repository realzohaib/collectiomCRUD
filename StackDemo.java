package Collection;
import java.util.*;

class Student{
	private int studentid;
	private String fname;
	private String lname;
	private String mobno;
	/**
	 * @return the studentid
	 */
	public int getStudentid() {
		return studentid;
	}
	/**
	 * @param studentid the studentid to set
	 */
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}
	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}
	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}
	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}
	/**
	 * @return the mobno
	 */
	public String getMobno() {
		return mobno;
	}
	/**
	 * @param mobno the mobno to set
	 */
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", fname=" + fname + ", lname=" + lname + ", mobno=" + mobno + "]";
	}
	public Student(int studentid, String fname, String lname, String mobno) {
		this.studentid = studentid;
		this.fname = fname;
		this.lname = lname;
		this.mobno = mobno;
	}
	
	public Student() {}
}
class MyStudentStack{
	
	private Stack<Student> students=new Stack<>();
	
	public void push(Student newelement) {
		students.push(newelement);
		System.out.println(newelement+" pushed to stack collection");
	}
	public void pop() {
		if(students.empty()==true) {
			System.out.println("stack is empty");
			return;
		}
		Student removedelement=students.pop();
		System.out.println(removedelement+" removed from stack collection");
	}
	public void show() {
		if(students.empty()==true) {
			System.out.println("stack is empty");
			return;
		}
		for(Iterator<Student> itr=students.iterator();
				itr.hasNext()==true;) {
			Student element=itr.next();
			System.out.println(element);
		}
	}
}
public class StackDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStudentStack studentstack= new MyStudentStack();
		
		while(true) {
			
			System.out.println("1. register new student");
			System.out.println("2. remove last student record in stack");
			System.out.println("3. display student stack");
			System.out.println("4. exit programme");
			
			Scanner sc=new Scanner(System.in);
			System.out.print("enter your choice? 1/2/3/4: ");
			int choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				Student student=new Student();
				Scanner sc1=new Scanner(System.in);
				System.out.print("enter student first name: ");
				student.setFname(sc1.nextLine());
				System.out.print("enter student last name");
				student.setLname(sc1.nextLine());
				System.out.print("enter student mobileno.");
				student.setMobno(sc1.nextLine());
				System.out.print("enter new student id");
				student.setStudentid(sc1.nextInt());
				studentstack.push(student);
				break;
			case 2:
				studentstack.pop();
				break;
			case 3:
				studentstack.show();
				break;
			case 4:
				System.out.println("-------THANKS YOU------");
				System.exit(0);
			}
			
		}
	}

}
