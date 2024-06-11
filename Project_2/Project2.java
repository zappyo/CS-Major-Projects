import java.io.*;
import java.util.*;
import java.lang.*;

public class Project2 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		ArrayList<Person> list = new ArrayList<Person>();
		Student entry;
		Faculty staff;
		int in, cred_hr, i;
		String name, id, rank = " ", depart = " ";
		String departs[] = {"mathematics","engineering","arts","science"};
		String ranks[] = {"professor","adjunct"};
		double gpa = 0;
		boolean prog = true, prod = false;
		do {
			System.out.printf("1- Add a new faculty member\n2- Add a new Student\n3- Print tuition invoice for a student\n4- Print information of a faculty\n5- Exit Program\n");
			System.out.print("Enter your selection ");
			prod = false;
			try {
				in = scn.nextInt();
				if(in == 2) {
					entry = new Student();
					System.out.print("Name of Student: ");
					scn.nextLine();
					name = scn.nextLine();
					System.out.println();
					System.out.print("ID: ");
					id = scn.nextLine();
					System.out.println();
					do {
						try {
							System.out.print("Gpa: ");
							gpa = scn.nextDouble();
							prod = true;
							if(gpa < 0) {
								throw new Exception("Invalid Gpa");
							}
							if(gpa > 4) {
								throw new Exception("Invalid Gpa");
							}
						}catch (Exception excpt) {
							System.out.println();
							System.out.println(excpt.getMessage());
							System.out.println();
							prod = false;
						}
					}while(!prod);
					System.out.println();
					System.out.print("Credit hours: ");
					cred_hr = scn.nextInt();
					entry = new Student(name, id, gpa, cred_hr);
					list.add(entry);
					scn.nextLine();
				}else if(in == 1){
					staff = new Faculty();
					System.out.print("Name of the Faculty: ");
					scn.nextLine();
					name = scn.nextLine();
					System.out.println();
					System.out.print("ID: ");
					id = scn.nextLine();
					System.out.println();
					do {
						try {
							System.out.print("Rank: ");
							rank = scn.nextLine();
							for(String ins : ranks) {
								if(rank.toLowerCase().equals(ins)) {
									prod = true;
								}
							}
							if(!prod) {
								throw new Exception("Sorry entered rank ");
							}
						}catch (Exception xcpt){
							System.out.println();
							System.out.printf("%s (%s) is invaild\n", xcpt.getMessage(), rank);
							System.out.println();
							prod = false;
						}
					}while(!prod);
					prod = false;
					System.out.println();
					do {
						try {
							System.out.print("Department: ");
							depart = scn.nextLine();
							for(String ons : departs) {
								if(depart.toLowerCase().equals(ons)) {
									prod = true;
								}
							}
							if(!prod) {
								throw new Exception("Sorry entered department ");
							}
						}catch (Exception xcpt){
							System.out.println();
							System.out.printf("%s (%s) is invaild\n", xcpt.getMessage(), depart);
							System.out.println();
							prod = false;
						}
					}while(!prod);
					staff = new Faculty(name, id, rank, depart);
					list.add(staff);
				}else if(in == 3){
					System.out.println();
					scn.nextLine();
					try {
						if(list.size() == 0) {
							throw new Exception("Not Data Entered");
						}
						System.out.print("Enter the student's id: ");
						id = scn.nextLine();
						for(i = 0; i < list.size(); i++) {
							if(id.equals(list.get(i).getID())) {
								list.get(i).printInfo();
								prod = true;
							}
						}
						if(!prod) {
							throw new Exception("Sorry- student not found");
						}
					} catch(Exception inxcpt) {
						System.out.println(inxcpt.getMessage());
						System.out.println();
					}
				}else if(in == 4){
					System.out.println();
					scn.nextLine();
					try {
						if(list.size() == 0) {
							throw new Exception("Not Data Entered");
						}
						System.out.println();
						System.out.print("Enter the faculty's id: ");
						id = scn.nextLine();
						for(i = 0; i < list.size(); i++) {
							if(id.equals(list.get(i).getID())) {
								list.get(i).printInfo();
								prod = true;
							}
						}
						if(!prod) {
							throw new Exception("Sorry- faculty not found");
						}
					} catch(Exception enxcpt) {
						System.out.println(enxcpt.getMessage());
						System.out.println();
					}
				}else if(in == 5) {
					prog = false;
					System.out.println("Goodbye!");
				}
			}catch(InputMismatchException inny) {
				System.out.println("Invalid entry- please try again");
				scn.nextLine();
			}
		}while(prog);
	}

}

