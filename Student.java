import java.io.*;

public class Student implements Person{
	private String nam, ID;
	private double gpa;
	private int cred_hr;
	
	public Student() {
		nam = "None";
		ID = "na1111";
		gpa = 0.00;
		cred_hr = 0;
	}
	public Student(String nm, String id, double gp, int cred) {
		nam = nm;
		ID = id;
		gpa = gp;
		cred_hr = cred;
	}
	public void setName(String nm) {
		nam = nm;
	}
	public void setID(String id) {
		ID = id;
	}
	public void setGPA(double gp) {
		gpa = gp;
	}
	public void setCreditHour(int cred) {
		cred_hr = cred;
	}
	public String getName() {
		return nam;
	}
	public String getID() {
		return ID;
	}
	public double getGPA() {
		return gpa;
	}
	public int getCreditHour() {
		return cred_hr;
	}
	public void printInfo() {
		System.out.printf("Here is the tution invoice for %s:\n", nam);
		System.out.println("---------------------------------------------------------------------------");
		System.out.printf("%s\t\t%s\n", nam, ID);
		System.out.printf("Credit Hour: %d ($236.45/credit hour)\nFees: $52\n\n", cred_hr);
		if(gpa >= 3.85) {
			System.out.printf("Total Payment %.2f\n", ((236.45*cred_hr)+52)*.75);
		}else{
			System.out.printf("Total Payment %.2f\n", ((236.45*cred_hr)+52));
		}
		System.out.println("---------------------------------------------------------------------------");
	}
}
