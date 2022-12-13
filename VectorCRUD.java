package Collection;
import java.util.*;

class Student1{
	int studentid;
	String fnmae;
	String lname;
	String mobno;
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getFnmae() {
		return fnmae;
	}
	public void setFnmae(String fnmae) {
		this.fnmae = fnmae;
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
		return "Student1 [studentid=" + studentid + ", fnmae=" + fnmae + ", lname=" + lname + ", mobno=" + mobno + "]";
	}
	
	public Student1() {}
	public Student1(int studentid, String fnmae, String lname, String mobno) {
		super();
		this.studentid = studentid;
		this.fnmae = fnmae;
		this.lname = lname;
		this.mobno = mobno;
	}

}
interface Student1DAO{
	void insert(Vector<Student1>student1);
	void fetch(Vector<Student1>student1);
	void delete(Vector<Student1>student1);
	int[] findStudentid(Vector<Student1> student1);
	void update(Vector<Student1>student1);
}

class Student1DAOImpl implements Student1DAO{

	@Override
	public void insert(Vector<Student1> student1) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Student1 std= new Student1();
		
		System.out.println("Enter student first name");
		std.setFnmae(sc.next());
		System.out.println("Enter student lirst name");
		std.setLname(sc.next());
		System.out.println("Enter student mobile no.");
		std.setMobno(sc.next());
		System.out.println("Enter student id");
		std.setStudentid(sc.nextInt());
		
		student1.add(std);
		System.out.println(std.getStudentid()+" inserted in collection");
	}

	@Override
	public void fetch(Vector<Student1> student1) {
		// TODO Auto-generated method stub
		if(student1.isEmpty()) {
			System.out.println("no records available");
		}
		Iterator<Student1> itr=student1.iterator();
		
		while(itr.hasNext()==true) {
			System.out.println(itr.next());
		}
		
	}

	@Override
	public void delete(Vector<Student1> student1) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		if(student1.isEmpty()==true) {
			System.out.println("collection is empty");
			return;
		}
		System.out.println("Enter student id you want tom delete");
		int studentid=sc.nextInt();
		int index=-1;
		for(int i=0; i<student1.size();i++) {
			Student1 student=student1.get(i);
			if(student.getStudentid()==studentid)
				index=i;
		}
		if(index==-1) 
			System.out.println("invalid student id given");
		else
		{
			student1.remove(index);
			System.out.println("student removed with id="+studentid);
		}
	}

	@Override
	public int[] findStudentid(Vector<Student1> student1) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("type existing student id to modify: ");
		int Studentid=sc.nextInt();

		int index=-1; 
		//search
		for(int i=0;i<student1.size();i++) {
			Student1 student2=student1.get(i);
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
	public void update(Vector<Student1> student1) {
		// TODO Auto-generated method stub
		if(student1.isEmpty()==true) {
			System.out.println("collection is empty");
			return;
		}
		int[] res=this.findStudentid(student1);
		if(res==null) {
			System.out.println("invalid id given");
			return;
		}
		Student1 student2=new Student1();
		Scanner sc=new Scanner(System.in);
		
		System.out.print("enter updated first name: ");
		student2.setFnmae(sc.nextLine());
		System.out.print("enter updated last name: ");;
		student2.setLname(sc.nextLine());
		System.out.println("enter updated mob no:");
		student2.setMobno(sc.nextLine());
		
		student2.setStudentid(res[1]);
		
		student1.set(res[0], student2);
		System.out.println("record modified with empid="+res[1]);
	}
}	

public class VectorCRUD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		Student1DAO dao=new Student1DAOImpl();
		Vector<Student1>vc= new Vector<>();
		
		while(true) {
			System.out.println("-------------------------------");
			System.out.println("1. insert");
			System.out.println("2. fetch all");
			System.out.println("3. delete by Student id");
			System.out.println("4. modify existing Student record by id");
			System.out.println("5. exit program");
			
			System.out.print("enter your choice? 1/2/3/4/5: ");
			int choice=sc.nextInt();
			System.out.println("-----------------------------");
			
			switch(choice) {
			case 1:
				dao.insert(vc);
				break;
			case 2:
				dao.fetch(vc);
				break;
			case 3:
				dao.delete(vc);
				break;
			case 4:
				dao.update(vc);
				break;
			case 5:
				System.out.println("-------THANK YOU-------");
				System.exit(0);
			}
		}
	}

}
