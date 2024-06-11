import java.io.PrintStream;
import java.util.Scanner;
public class Project1 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		final int MAX = 2, FEE = 52;
		final double TUITION = 236.45;
		String name_S[] = new String[MAX];
		String id_S[] = new String[MAX];
		double gpa[] = new double[MAX];
		int cred_hr[] = new int[MAX];
		String name_F[] = new String[MAX-1];
		String id_F[] = new String[MAX-1];
		String rank[] = new String[MAX-1];
		String depart[] = new String[MAX-1];
		int in, i, mod, ex1, ex2;
		boolean proc = true, prog = true;
		do {
			System.out.println("1.	Enter the information of the faculty\n" + 
					"2.	Enter the information of the two students\n" + 
					"3.	Print tuition invoice\n" + 
					"4.	Print faculty information\n" + 
					"5.	Exit Program\n"+
					"6. Mod Calc\n");
			in = scn.nextInt();
			if(in ==  1){
				addFalc(name_F, id_F, rank, depart);
			}else if(in == 2){
				addStudent(name_S, id_S, gpa, cred_hr);
			}else if(in == 3){
				if(name_S[0] == null) {
					System.out.println("No students currently registered");
				}else {
					System.out.print("Which student? ");
					for(i = 0; i < MAX; i++){
						System.out.printf("%d %s", i+1, name_S[i]);
						if(i+1 != MAX){
							System.out.print(" or ");
						}else {
							System.out.println();
						}
					}
					do {
						in = scn.nextInt();
						prog = true;
						for(i = 0; i < MAX; i++){
							if(in == i+1){
								System.out.println("---------------------------------------------------------------------------");
								System.out.printf("%s\t\t%s\n", name_S[i], id_S[i]);
								System.out.printf("Credit Hours: %d", cred_hr[i]);
								System.out.printf("\t(%.2f/credit hour)\nFee: %d\n", TUITION, FEE);
								System.out.println();
								if(gpa[i] >= 3.85){
									System.out.printf("Total Payment: %.2f\n", (double)TUITION*cred_hr[i]*.75);
									prog = false;
								}else {
									System.out.printf("Total Payment: %.2f\n", (double)TUITION*cred_hr[i]);
									prog = false;
								}
								System.out.println("---------------------------------------------------------------------------");
							}
						}
						if(prog){
							System.out.println("Invaild entry- try again");
						}
					}while(prog);
				}
			}else if(in == 4){
				System.out.println("---------------------------------------------------------------------------");
				System.out.printf("%s\n%s, %s\n", name_F[0], depart[0], rank[0]);
				System.out.println("---------------------------------------------------------------------------");
			}else if(in == 5) {
				System.out.println("Goodbye");
				proc = false;
			}else if(in == 6){
				do{
					System.out.printf("Enter 1 number:\n");
					ex1= scn.nextInt();
					System.out.printf("Enter 2 number:\n");
					ex2 = scn.nextInt();
					System.out.printf("Enter mod:\n");
					mod = scn.nextInt();
					System.out.printf("Result: %d\n", ((ex1*ex2)%mod));
				}while(mod >= 0);
			}else{
				System.out.println("Invaild entry - please try again");
			}
		}while(proc);
		
	}
	public static void addStudent(String[] name, String[] id, double[] gpa, int[] cred) {
		Scanner scn = new Scanner(System.in);
		String in, grb;
		double grdpa;
		int cred_hr, i;
		boolean prog = true;
		for(i = 0; i < 2; i++){
			prog =  true;
			System.out.print("Name of Student: ");
			in = scn.nextLine();
			name[i] = in;
			System.out.print("\nID: ");
			in = scn.nextLine();
			id[i] = in;
			do{
				System.out.print("\nGpa: ");
				grdpa = scn.nextDouble();
				if(grdpa >= 0 && grdpa <= 4){
					prog = false;
				}else {
					System.out.print("\nInvaild GPA - please try again");
				}
			}while(prog);
			prog = true;
			gpa[i] = grdpa;
			do{
				System.out.print("\nCredit Hours: ");
				cred_hr = scn.nextInt();
				if(cred_hr >= 0){
					prog = false;
				}else {
					System.out.print("\nInvaild Credit Hours - please try again");
				}
			}while(prog);
			cred[i] = cred_hr;
			grb = scn.nextLine();
			System.out.println("\nThanks!");
		}
		
	}
	public static void addFalc(String name[], String id[], String rank[], String depart[]){
		Scanner scn = new Scanner(System.in);
		int list = 0, i;
		boolean prog, check = false;
		String cha;
		String departs[] = new String[] {"Mathematics", "Engineering", "Arts", "Science"};
		String ranks[] = new String[] {"Professor", "Adjunct"};
		prog =  true;
		System.out.print("Name of Faculty: ");
		cha = scn.nextLine();
		name[list] = cha;
		System.out.print("\nID: ");
		cha = scn.nextLine();
		id[list] = cha;
		do{
			check = false;
			System.out.print("\nRank: ");
			cha = scn.nextLine();
			for(i = 0; i < ranks.length; i++) {
				if(cha.toLowerCase().equals(ranks[i].toLowerCase())){
					prog = false;
					check = true;
					cha = ranks[i];
					break;
				}
			}
			if(!check){
				System.out.println("\nInvaild Rank - please try again");
			}
		}while(prog);
		prog = true;
		rank[list] = cha;
		do{
			check = false;
			System.out.print("\nDepartment: ");
			cha = scn.nextLine();
			cha = cha.toLowerCase();
			for(i = 0; i < departs.length; i++){
				if(cha.toLowerCase().equals(departs[i].toLowerCase())){
					prog = false;
					check = true;
					cha = departs[i];
					break;
				}
			}
			if(!check){
				System.out.println("\nInvaild Rank - please try again");
			}
		}while(prog);
		depart[list] = cha;
		System.out.println("\nThanks!");
	}

}
