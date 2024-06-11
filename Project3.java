import java.io.*;
import java.util.*;
import java.lang.*;

public class Project3 {


	public static void main(String[] args) throws IOException{
			Scanner scn = new Scanner(System.in);
			FileOutputStream report = new FileOutputStream("Report.txt");
			PrintWriter outrep = new PrintWriter(report);
			ArrayList<Student> stu_list = new ArrayList<Student>();
			ArrayList<Faculty> falc_list = new ArrayList<Faculty>();
			Student entry;
			Faculty staff;
			char save;
			int in, cred_hr = 0, i, head_count = 1, p;
			String name, id = " ", rank = " ", depart = " ";
			String departs[] = {"mathematics","engineering","arts","science"};
			String ranks[] = {"professor","adjunct"};
			double gpa = 0;
			boolean prog = true, prod = false;
			do {
				System.out.printf("1- Add a new faculty member\n2- Add a new Student\n3- Print tuition invoice for a student\n4- Print information of a faculty\n5- Exit Program\n");
				System.out.print("\nEnter your selection ");
				prod = false;
				try {
					in = scn.nextInt();
					if(in == 2) {
						entry = new Student();
						System.out.print("Name of Student: ");
						scn.nextLine();
						name = scn.nextLine();
						System.out.println();
						do {
							try {
								System.out.print("ID: ");
								id = scn.nextLine();
								System.out.println();
								prod = true;
								if(id.length() > 6) {
									throw new Exception("Invaild id length- format LetterLetterDigitDigitDigitDigit");
								}else if(id.length() < 6){
									throw new Exception("Invaild id length- format LetterLetterDigitDigitDigitDigit");
								}else {
									for(i = 0; i < id.length(); i++) {
										if(i < 2) {
											if(!Character.isLetter(id.charAt(i))) {
												throw new Exception("Invaild id- format LetterLetterDigitDigitDigitDigit");
											}
										}else {
											if(!Character.isDigit(id.charAt(i))) {
												throw new Exception("Invaild id- format LetterLetterDigitDigitDigitDigit");
											}
										}
									}
								}
							}catch (Exception ixcpt){
								System.out.println();
								System.out.println(id.length());
								System.out.println(ixcpt.getMessage());
								System.out.println();
								prod = false;
							}
							
						}while(!prod);
						prod = false;
						do {
							try {
								System.out.print("Gpa: ");
								gpa = scn.nextDouble();
								prod = true;
								if(gpa < 0) {
									throw new Exception();
								}
								if(gpa > 4) {
									throw new Exception();
								}
							}catch (Exception excpt) {
								System.out.println();
								System.out.println("Invaild Gpa");
								System.out.println();
								scn.nextLine();
								prod = false;
							}
						}while(!prod);
						prod = false;
						do {
							try {
								System.out.println();
								System.out.print("Credit hours: ");
								cred_hr = scn.nextInt();
								prod = true;
								if(cred_hr > 1000)throw new Exception();
							}catch (Exception excpt) {
								System.out.println();
								System.out.println("Invaild Credit Hour");
								System.out.println();
								scn.nextLine();
								prod = false;
							}
						}while(!prod);	
						entry = new Student(name, id, gpa, cred_hr);
						stu_list.add(entry);
						System.out.println();
						scn.nextLine();
					}else if(in == 1){
						staff = new Faculty();
						System.out.print("Name of the Faculty: ");
						scn.nextLine();
						name = scn.nextLine();
						System.out.println();
						do {
							try {
								System.out.print("ID: ");
								id = scn.nextLine();
								System.out.println();
								prod = true;
								if(id.length() > 6) {
									throw new Exception("Invaild id length- format LetterLetterDigitDigitDigitDigit");
								}else if(id.length() < 6){
									throw new Exception("Invaild id length- format LetterLetterDigitDigitDigitDigit");
								}else {
									for(i = 0; i < id.length(); i++) {
										if(i < 2) {
											if(!Character.isLetter(id.charAt(i))) {
												throw new Exception("Invaild id- format LetterLetterDigitDigitDigitDigit");
											}
										}else {
											if(!Character.isDigit(id.charAt(i))) {
												throw new Exception("Invaild id- format LetterLetterDigitDigitDigitDigit");
											}
										}
									}
								}
							}catch (Exception ixcpt){
								System.out.println();
								System.out.println(ixcpt.getMessage());
								System.out.println();
								prod = false;
							}
							
						}while(!prod);
						prod = false;
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
						falc_list.add(staff);
						System.out.println();
					}else if(in == 3){
						System.out.println();
						scn.nextLine();
						try {
							if(stu_list.size() == 0) {
								throw new Exception("Not Data Entered");
							}
							System.out.print("Enter the student's id: ");
							id = scn.nextLine();
							for(i = 0; i < stu_list.size(); i++) {
								if(id.equals(stu_list.get(i).getID())) {
									stu_list.get(i).printInfo();
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
							if(falc_list.size() == 0) {
								throw new Exception("Not Data Entered");
							}
							System.out.println();
							System.out.print("Enter the faculty's id: ");
							id = scn.nextLine();
							for(i = 0; i < falc_list.size(); i++) {
								if(id.equals(falc_list.get(i).getID())) {
									falc_list.get(i).printInfo();
									prod = true;
								}
							}
							if(!prod) {
								throw new Exception("Sorry- faculty not found");
							}
						} catch(Exception enxcpt) {
							System.out.println();
							System.out.println(enxcpt.getMessage());
							System.out.println();
						}
						System.out.println();
					}else if(in == 5) {
						prog = false;
						System.out.println();
						prod = false;
						do {
							try {
								System.out.printf("Would you like to create the report? (Y/N): ");
								save = scn.next().charAt(0);
								switch (save) {
									case 'y':
										outrep.println("\tReport created on " + java.time.LocalDate.now());
										outrep.println("\t****************************");
										outrep.println();
										outrep.flush();
										if(falc_list.size() != 0) {
											outrep.println("Faculty Members (By Department)");
											outrep.println("_______________________________");
											outrep.println();
											outrep.flush();
											for(i = 0; i < falc_list.size(); i++) {
												if(falc_list.get(i).getDepartment().toLowerCase().equals(departs[2])) {
													outrep.printf("\t%d. %s", head_count, falc_list.get(i).getName());
													outrep.println();
													outrep.printf("\tID: %s", falc_list.get(i).getID());
													outrep.println();
													outrep.printf("\t%c%s,%c%s", Character.toUpperCase(falc_list.get(i).getRank().charAt(0)), falc_list.get(i).getRank().toLowerCase().substring(1, falc_list.get(i).getRank().length()), Character.toUpperCase(falc_list.get(i).getDepartment().charAt(0)),falc_list.get(i).getDepartment().toLowerCase().substring(1, falc_list.get(i).getDepartment().length()));
													outrep.println();
													outrep.println();
													++head_count;
													outrep.flush();
												}
											}
											for(i = 0; i < falc_list.size(); i++) {
												if(falc_list.get(i).getDepartment().toLowerCase().equals(departs[1])) {
													outrep.printf("\t%d. %s", head_count, falc_list.get(i).getName());
													outrep.println();
													outrep.printf("\tID: %s", falc_list.get(i).getID());
													outrep.println();
													outrep.printf("\t%c%s,%c%s", Character.toUpperCase(falc_list.get(i).getRank().charAt(0)), falc_list.get(i).getRank().toLowerCase().substring(1, falc_list.get(i).getRank().length()), Character.toUpperCase(falc_list.get(i).getDepartment().charAt(0)),falc_list.get(i).getDepartment().toLowerCase().substring(1, falc_list.get(i).getDepartment().length()));
													outrep.println();
													outrep.println();
													++head_count;
													outrep.flush();
												}
											}
											for(i = 0; i < falc_list.size(); i++) {
												if(falc_list.get(i).getDepartment().toLowerCase().equals(departs[0])) {
													outrep.printf("\t%d. %s", head_count, falc_list.get(i).getName());
													outrep.println();
													outrep.printf("\tID: %s", falc_list.get(i).getID());
													outrep.println();
													outrep.printf("\t%c%s,%c%s", Character.toUpperCase(falc_list.get(i).getRank().charAt(0)), falc_list.get(i).getRank().toLowerCase().substring(1, falc_list.get(i).getRank().length()), Character.toUpperCase(falc_list.get(i).getDepartment().charAt(0)),falc_list.get(i).getDepartment().toLowerCase().substring(1, falc_list.get(i).getDepartment().length()));
													outrep.println();
													outrep.println();
													++head_count;
													outrep.flush();
												}
											}
											for(i = 0; i < falc_list.size(); i++) {
												if(falc_list.get(i).getDepartment().toLowerCase().equals(departs[3])) {
													outrep.printf("\t%d. %s", head_count, falc_list.get(i).getName());
													outrep.println();
													outrep.printf("\tID: %s", falc_list.get(i).getID());
													outrep.println();
													outrep.printf("\t%c%s,%c%s", Character.toUpperCase(falc_list.get(i).getRank().charAt(0)), falc_list.get(i).getRank().toLowerCase().substring(1, falc_list.get(i).getRank().length()), Character.toUpperCase(falc_list.get(i).getDepartment().charAt(0)),falc_list.get(i).getDepartment().toLowerCase().substring(1, falc_list.get(i).getDepartment().length()));
													outrep.println();
													outrep.println();
													++head_count;
													outrep.flush();
												}
											}
										}
										System.out.println();
										head_count = 1;
										if(stu_list.size() != 0) {
											outrep.println("Students");
											outrep.println("________");
											outrep.println();
											for(i = 0; i < stu_list.size(); i++) {
												outrep.printf("\t%d. %s", head_count, stu_list.get(i).getName());
												outrep.println();
												outrep.printf("\tID: %s", stu_list.get(i).getID());
												outrep.println();
												outrep.printf("\tGpa: %.2f", stu_list.get(i).getGPA());
												outrep.println();
												outrep.printf("\tCredit Hours: %d", stu_list.get(i).getCreditHour());
												outrep.println();
												outrep.println();
												++head_count;
												outrep.flush();
											}
										}
										System.out.println("Your file has been created!");
										System.out.println();
										report.close();
										prod = true;
										break;
									case 'Y':
										outrep.println("\tReport created on " + java.time.LocalDate.now());
										outrep.println("\t**************************");
										outrep.flush();
										prod = true;
										if(falc_list.size() != 0) {
											outrep.println("Faculty Members (By Department)");
											outrep.println("_______________________________");
											outrep.println();
											for(i = 0; i < falc_list.size(); i++) {
												if(falc_list.get(i).getDepartment().toLowerCase().equals(departs[2])) {
													outrep.printf("\t%d. %s", head_count, falc_list.get(i).getName());
													outrep.println();
													outrep.printf("\tID: %s", falc_list.get(i).getID());
													outrep.println();
													outrep.printf("\t%c%s,%c%s", Character.toUpperCase(falc_list.get(i).getRank().charAt(0)), falc_list.get(i).getRank().toLowerCase().substring(1, falc_list.get(i).getRank().length()), Character.toUpperCase(falc_list.get(i).getDepartment().charAt(0)),falc_list.get(i).getDepartment().toLowerCase().substring(1, falc_list.get(i).getDepartment().length()));
													outrep.println();
													outrep.println();
													++head_count;
													outrep.flush();
												}
											}
											for(i = 0; i < falc_list.size(); i++) {
												if(falc_list.get(i).getDepartment().toLowerCase().equals(departs[1])) {
													outrep.printf("\t%d. %s", head_count, falc_list.get(i).getName());
													outrep.println();
													outrep.printf("\tID: %s", falc_list.get(i).getID());
													outrep.println();
													outrep.printf("\t%c%s,%c%s", Character.toUpperCase(falc_list.get(i).getRank().charAt(0)), falc_list.get(i).getRank().toLowerCase().substring(1, falc_list.get(i).getRank().length()), Character.toUpperCase(falc_list.get(i).getDepartment().charAt(0)),falc_list.get(i).getDepartment().toLowerCase().substring(1, falc_list.get(i).getDepartment().length()));
													outrep.println();
													outrep.println();
													++head_count;
													outrep.flush();
												}
											}
											for(i = 0; i < falc_list.size(); i++) {
												if(falc_list.get(i).getDepartment().toLowerCase().equals(departs[0])) {
													outrep.printf("\t%d. %s", head_count, falc_list.get(i).getName());
													outrep.println();
													outrep.printf("\tID: %s", falc_list.get(i).getID());
													outrep.println();
													outrep.printf("\t%c%s,%c%s", Character.toUpperCase(falc_list.get(i).getRank().charAt(0)), falc_list.get(i).getRank().toLowerCase().substring(1, falc_list.get(i).getRank().length()), Character.toUpperCase(falc_list.get(i).getDepartment().charAt(0)),falc_list.get(i).getDepartment().toLowerCase().substring(1, falc_list.get(i).getDepartment().length()));
													outrep.println();
													outrep.println();
													++head_count;
													outrep.flush();
												}
											}
											for(i = 0; i < falc_list.size(); i++) {
												if(falc_list.get(i).getDepartment().toLowerCase().equals(departs[3])) {
													outrep.printf("\t%d. %s", head_count, falc_list.get(i).getName());
													outrep.println();
													outrep.printf("\tID: %s", falc_list.get(i).getID());
													outrep.println();
													outrep.printf("\t%c%s,%c%s", Character.toUpperCase(falc_list.get(i).getRank().charAt(0)), falc_list.get(i).getRank().toLowerCase().substring(1, falc_list.get(i).getRank().length()), Character.toUpperCase(falc_list.get(i).getDepartment().charAt(0)),falc_list.get(i).getDepartment().toLowerCase().substring(1, falc_list.get(i).getDepartment().length()));
													outrep.println();
													outrep.println();
													++head_count;
													outrep.flush();
												}
											}
										}
										System.out.println();
										head_count = 1;
										if(stu_list.size() != 0) {
											outrep.println("Students");
											outrep.println("________");
											outrep.println();
											for(i = 0; i < stu_list.size(); i++) {
												outrep.printf("\t%d. %s", head_count, stu_list.get(i).getName());
												outrep.println();
												outrep.printf("\tID: %s", stu_list.get(i).getID());
												outrep.println();
												outrep.printf("\tGpa: %.2f", stu_list.get(i).getGPA());
												outrep.println();
												outrep.printf("\tCredit Hours: %d", stu_list.get(i).getCreditHour());
												outrep.println();
												outrep.println();
												++head_count;
												outrep.flush();
											}
										}
										System.out.println("Your file has been created!");
										System.out.println();
										report.close();
										prod = true;
										break;
									case 'n':
										System.out.println("Report not created");
										prod = true;
										break;
									case 'N':
										System.out.println("Report not created");
										prod = true;
										break;
									default:
										throw new Exception("Invaild entry- y or n are the only vaild inputs");
								}
							}catch (Exception nxpct) {
								System.out.println();
								System.out.println(nxpct.getMessage());
								System.out.println();
							}	
						}while(!prod);
						System.out.println("Goodbye!");
					}
				}catch(InputMismatchException inny) {
					System.out.println();
					System.out.println("Invaild entry- try again");
					System.out.println();
					scn.nextLine();
				}
			}while(prog);
	}

}
