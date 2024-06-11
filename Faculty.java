import java.io.*;

public class Faculty implements Person {
	private String nam, ID, depart, rank;
	public Faculty() {
		nam = "None";
		ID = "na0000";
		depart = "None";
		rank = "None";
	}
	public Faculty(String nm, String id, String rnk, String dpt) {
		nam = nm;
		ID = id;
		depart = dpt;
		rank = rnk;
	}
	public void setName(String nm) {
		nam = nm;
	}
	public void setID(String id) {
		ID = id;
	}
	public void setDepartment(String dpt) {
		depart = dpt;
	}
	public void setRank(String rnk) {
		rank = rnk;
	}
	public String getName() {
		return nam;
	}
	public String getID() {
		return ID;
	}
	public String getDepartment() {
		return depart;
	}
	public String getRank() {
		return rank;
	}
	public void printInfo() {
		System.out.println("---------------------------------------------------------------------------");
		System.out.printf("%s\n%c%s Department, %c%s\n", nam, Character.toUpperCase(depart.charAt(0)), depart.toLowerCase().substring(1,depart.length()), Character.toUpperCase(rank.charAt(0)), rank.toLowerCase().substring(1,rank.length()));
		System.out.println("---------------------------------------------------------------------------");
	}
}
