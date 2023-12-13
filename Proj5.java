/* <Proj5.java
 * <Preston Rottinghaus / Section: 02B/ Day: Thursday/ Time: 3:30-5:20pm>
 * "EXTRA CREDIT" for password check
 *<This program is designed to open a file containing a list of students and their exam grades. 
 *then takes the grades and check to make sure all are valid and calculate total grade.
 *then outputs students grades aslong they are in the valid range.>
*/
import java.io.*;
import java.util.*;
public class Proj5 {
	 
	public static void main(String[] args)throws IOException {
		Scanner s = new Scanner(System.in);
		
		final int MAXEXAMVALUE = 50;
		final int MAXFINALVALUE = 100;
		final int EXAMTOTAL = 3;
		final int FINAL = 1;
		final int CLASSSIZE = 50;
		int col = 3 + FINAL + EXAMTOTAL;
		final String [][]scores = new String [CLASSSIZE][col];
		final Double []finalgrade = new Double [CLASSSIZE];
		int e =0;
		double gradepg = 0;
		double scoreavg =0;
		int numA=0;
		int numB =0;
		int numC = 0;
		int numD =0;
		int numF = 0;
		int graded = 0;
		int coursetot = (FINAL*MAXFINALVALUE)+(EXAMTOTAL*MAXEXAMVALUE);
		
		String userFile;
		String score;
		boolean validFile = false;
		System.out.print("Filename of the file containing student data: ");
		userFile = s.nextLine();
		while(!validFile) {
			
				
				File file = new File(userFile);//check if file name entered is a vaild file
				if(file.isFile()) {
					validFile = true;
				}
				else{// tells user to renter a valid file name
					System.out.print("File name doesn't exist please try again: ");
					userFile = s.nextLine();
					validFile = false;
				}
			
		}
		
		Scanner InFile = new Scanner(new File(userFile));// reads in file
		String password = InFile.nextLine();
		System.out.print("Enter in File Password: ");// checks if password matches that in txt file
		String userPass = s.nextLine();
		int ctr = 1;
		//int spec =0;
		//int dig =0;
		
		while( ctr<3) {
			//boolean flag = true;
		/*
		if(userPass.length() <8) {
			flag = false;
			System.out.println("Invalid password  must be at least 8 characters: ");
		}
		*/
		//else if(flag == true){
		char [] userEn = new char[userPass.length()];// encrypts enterd password 
		
		for(int i = 0; i <userPass.length();i++) {
			userEn[i] = userPass.charAt(i);
			char let = userEn[i];
			int ASCIIval = (int)let;
			/*
			if(((ASCIIval ==33) || (ASCIIval ==35)|| (ASCIIval ==36) ||(ASCIIval==41) ||(ASCIIval ==64))){
				flag = false;
				spec++;
			}
			if((ASCIIval>47) && (ASCIIval<58)) {
				flag = false;
				dig++;
			}
			*/
			ASCIIval+=1;
			let = (char)ASCIIval;
			userEn[i] = let;
			
		}
		
		userPass = String.copyValueOf(userEn);
		//}
		if(!userPass.equals(password)) {
			ctr++;
			 System.out.print("Invalid password - Please enter a valid password:");
			userPass = s.nextLine();
			
		}
		/*
		 if (!flag) {
		        if (spec == 0) {
		            System.out.println("Invalid password  must contain at least one of the following characters: ! @ # $ *");
		            System.out.print("Please enter a valid password:");
			        ctr++;
			        userPass = s.nextLine();
			        char [] userEn = new char[password.length()];
					for(int i = 0; i <userPass.length();i++) {
						userEn[i] = userPass.charAt(i);
						char let = userEn[i];
						int ASCIIval = (int)let;ASCIIval+=1;
						let = (char)ASCIIval;
						userEn[i] = let;
					}
					userPass = String.copyValueOf(userEn);
		        } 
		        else if (!(dig == 0)) {
		            System.out.println("Invalid password  must contain at least one digit");
		            System.out.print("Please enter a valid password:");
			        ctr++;
			        userPass = s.nextLine();
			        char [] userEn = new char[password.length()];
					for(int i = 0; i <userPass.length();i++) {
						userEn[i] = userPass.charAt(i);
						char let = userEn[i];
						int ASCIIval = (int)let;ASCIIval+=1;
						let = (char)ASCIIval;
						userEn[i] = let;
					}
					userPass = String.copyValueOf(userEn);
		        } 
		        else {
		        	System.out.print("Please enter a valid password:");
			        ctr++;
			        userPass = s.nextLine();
			        char [] userEn = new char[password.length()];
					for(int i = 0; i <userPass.length();i++) {
						userEn[i] = userPass.charAt(i);
						char let = userEn[i];
						int ASCIIval = (int)let;ASCIIval+=1;
						let = (char)ASCIIval;
						userEn[i] = let;
					}
					userPass = String.copyValueOf(userEn);
		        }
		 */
		       
		 
	/*
			if(userPass.equals(password)) {
				boolean out = true;
						while(out) {
				char [] userEn = new char[password.length()];
				System.out.print("Please re-enter valid password: ");
				userPass = s.nextLine();
				for(int r = 0; r <userPass.length();r++) {
					userEn[r] = userPass.charAt(r);
					char let = userEn[r];
					int ASCIIval = (int)let;ASCIIval+=1;
					let = (char)ASCIIval;
					userEn[r] = let;
				}
				userPass = String.copyValueOf(userEn);
				if(!userPass.equals(password)) {
					System.out.println("\t**Passwords must match**");
				}
				if(userPass.equals(password)) {
					System.out.print("Password is valid and confirmed ");
					out=false;
				}
						}
			}
		
	*/
		else if(userPass.equals(password)) {
			ctr = 4;
			
		}
		
		else if(ctr == 3) {
			System.out.print("Invalid Password entered 3 times – Exiting");
			System.exit(3);
		}
		
		}
		
		System.out.println("\n***Class Results***");
		
		
		int i =0;
		while(InFile.hasNext()&&i<CLASSSIZE) {// reads student entries and fills array
			
			String line = InFile.nextLine();
			String []data = line.split(",");
			for(int j = 0; j < data.length; j++) {
					scores [i][j] = data[j];
					
				}
			i++;
		}
		
		
		
		
		for(int j = 0; j < i; j++) {// gathers students exam scores and checks for erros
			int pointScored = 0;
			for(int k = 3; k< col-1;k++) {
				int pt =0;
					score = scores[j][k];
					
					pt = Integer.parseInt(score);
					
					if(pt>=0 && pt<=MAXEXAMVALUE) {
					pointScored = pointScored + pt;
					}
					
					else {
					pointScored = -100001;
					}
					
			}
			for(int k = col -1; k<col; k++) {// checks final score  for erros
				int pt =0;
				
				score = scores[j][k];
				
				pt = Integer.parseInt(score);
				
				if(pt>=0 &&pt<=MAXFINALVALUE) {
					pointScored = pointScored + pt;
					}
					
					else {
						pointScored = -500000;
					}
					
			
			gradepg =(((double)pointScored/coursetot)*100);// calulates final grade percentage
			finalgrade[j] = gradepg;
			}
			
			
			}
		
	
	while(e< i){// converts name to uppercase
		for(int k =0;k<2;k++) {
			scores[e][k] = scores[e][k].toUpperCase();
		}
		e++;
	}
		for(int j = 0; j<i;j++) {
			
			if(finalgrade[j]<0) {
				System.out.println("****Course Exam score invalid for " + scores[j][0] + " " + scores[j][1] + "\n" );
			}
			if(finalgrade[j]==-200000) {
				System.out.println("***Final Exam score invalid for " + scores[j][0] + " " + scores[j][1] + "\n");
			}
		
		if(finalgrade[j]>0) {
			graded++;
			scoreavg += finalgrade[j];
			System.out.println(scores[j][1] + "," + scores[j][0]);
			System.out.println(scores[j][2]);
			double prt = finalgrade[j];
			System.out.printf("Exam Percentage: %.1f", prt);
			System.out.println();
			if(finalgrade[j]>=90 && finalgrade[j]<=100) {
				System.out.println("Final Grade: A");
				numA++;
			}
			else if(finalgrade[j]>=80 && finalgrade[j]<90) {
				System.out.println("Final Grade: B");
				numB++;
			}
			else if(finalgrade[j]>=70 && finalgrade[j]<80) {
				System.out.println("Final Grade: C");
				numC++;
			}
			else if(finalgrade[j]>=60 && finalgrade[j]<70) {
				System.out.println("Final Grade: D");
				numD++;
			}
			else {
				System.out.println("Final Grade: F");
				numF++;
			}
			System.out.print("Press enter to display next student...\r\n" );
			s.nextLine();
		}
		}
		
			System.out.println("***Class Summary***");
			System.out.println("Total number of students with valid scores: " + graded );
			System.out.println("\tTotal number of A's: " + numA);
			System.out.println("\tTotal number of B's: " + numB);
			System.out.println("\tTotal number of C's: " + numC);
			System.out.println("\tTotal number of D's: " + numD);
			System.out.println("\tTotal number of F's: " + numF);
			System.out.print("\n");
			System.out.println("Individual grade percentages...");
			
			System.out.printf("\tA: %.1f%%", ((double)numA/(double)graded)*100);
			System.out.print("\n");
			
			System.out.printf("\tB: %.1f%%", ((double)numB/(double)graded)*100);
			System.out.print("\n");
			
			System.out.printf("\tC: %.1f%%",((double)numC/(double)graded)*100);
			System.out.print("\n");
			
			System.out.printf("\tD: %.1f%%",((double)numD/(double)graded)*100);
			System.out.print("\n");
			
			System.out.printf("\tF: %.1f%%",((double)numF/(double)graded)*100 );
			System.out.print("\n");
			scoreavg = scoreavg/(double)graded;
			System.out.printf("Overall Average Score = %.1f%%", scoreavg) ;
			
			
			
		s.close();
		InFile.close();
		
	}
}