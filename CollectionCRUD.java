package Collection;
import java.util.*;

class Student{
	private int studentid;
	private String fname;
	private String lname;
	private String mobno;
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", fname=" + fname + ", lname=" + lname + ", mobno=" + mobno + "]";
	}
	
	public Student() {}
	
	public Student(int studentid, String fname, String lname, String mobno) {
		this.studentid = studentid;
		this.fname = fname;
		this.lname = lname;
		this.mobno = mobno;
	}

}

interface StudentDao{
	void insert(List<Student>students);
	void fetch(List<Student>students);
	void delete(List<Student> students);
	void update(List<Student>students);
	int[] findStudentid(List<Student> students);
}
class StudentDaoImpl implements StudentDao{

	@Override
	public void insert(List<Student> students) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		Student student=new Student();
		
		System.out.println("Enter student first name");
		student.setFname(sc.nextLine());
		
		System.out.println("Enter student last name");
		student.setLname(sc.nextLine());
		
		System.out.println("Enter student mobile no.");
		student.setMobno(sc.nextLine());
		
		System.out.println("Enter student student id");
		student.setStudentid(sc.nextInt());
		
		students.add(student);
		System.out.println(student.getStudentid()+" inserted in collection");
	}
	

	@Override
	public void fetch(List<Student> students) {
		// TODO Auto-generated method stub
		if(students.isEmpty()==true) {
			System.out.println("collection is empty");
			return;
		}
		for(Iterator<Student> itr=students.iterator();
				itr.hasNext()==true;) {
			Student student=itr.next();
			System.out.println(student.toString());
		}
	}


	@Override
	public void delete(List<Student> students) {
		// TODO Auto-generated method stub
		if(students.isEmpty()==true) {
			System.out.println("collection is empty");
			return;
		}
		Scanner sc= new Scanner(System.in);
		System.out.print("enter student id to delete record: ");
		int studentid=sc.nextInt();
		int index=-1;
		for(int i=0;i<students.size();i++) {
			Student student=students.get(i);
			if(student.getStudentid()==studentid)
				index=i;
		}
		if(index==-1) 
			System.out.println("invalid student id given");
		else
		{
			students.remove(index);
			System.out.println("student removed with id="+studentid);
		}
	}
	
	@Override
	public int[] findStudentid(List<Student> students) {
		// TODO Auto-generated method stub
			Scanner sc=new Scanner(System.in);
		
		System.out.print("type existing student id to modify: ");
		int Studentid=sc.nextInt();

		int index=-1; 
		//search
		for(int i=0;i<students.size();i++) {
			Student student2=students.get(i);
			if(student2.getStudentid()==Studentid) {
				
				index=i;
				break;
			}
		}

		if(index==-1) {
			int[] res=null;
			return res;
		}
		
		int[] res=new int[2];
		res[0]=index;
		res[1]=Studentid;
		return res;
	}


	@Override
	public void update(List<Student> students) {
		// TODO Auto-generated method stub
		if(students.isEmpty()==true) {
			System.out.println("collection is empty");
			return;
		}

		int[] res=this.findStudentid(students);
		if(res==null) {
			System.out.println("invalid id given");
			return;
		}
		Student student=new Student();
		Scanner sc=new Scanner(System.in);
		
		System.out.print("enter updated first name: ");
		student.setFname(sc.nextLine());
		System.out.print("enter updated last name: ");;
		student.setLname(sc.nextLine());
		System.out.println("enter updated mob no:");
		student.setMobno(sc.nextLine());
		student.setStudentid(res[1]);
		
		students.set(res[0], student);
		System.out.println("record modified with empid="+res[1]);
	}

}
public class CollectionCRUD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		StudentDao dao=new StudentDaoImpl();
		List<Student> students=new ArrayList<>();

		while(true) {
			System.out.println("-------------------------------");
			System.out.println("1. insert");
			System.out.println("2. fetch all");
			System.out.println("3. delete by student id");
			System.out.println("4. modify existing student record by id");
			System.out.println("5. exit program");
			
			System.out.print("enter your choice? 1/2/3/4/5: ");
			int choice=sc.nextInt();
			System.out.println("-----------------------------");
			switch(choice) {
			case 1:
				dao.insert(students);
				break;
			case 2:
				dao.fetch(students);
				break;
			case 3:
				dao.delete(students);
				break;
			case 4:
				dao.update(students);
				break;
			case 5:
				System.out.println("-------Thank you--------");
				System.exit(0);
				}
			}
		}
	}



