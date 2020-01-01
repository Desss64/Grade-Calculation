import java.util.Scanner;
public class Grades {
	static int total;
	
	//Allows multiple grade entries and validation for those entries
	public static void enterGrade(String gradeType, int entryNum) {
		Scanner in = new Scanner(System.in);
		total = 0;
		int grade;
		
		while(entryNum < 0) {
			System.out.println("Invalid entry");
			System.out.println("Number of " + gradeType + " entries?");
			entryNum = in.nextInt();
		}
		
		for(int i = 0; i < entryNum; i++) {
		    do {
			System.out.println("Enter grade for " + gradeType + " #"+(i+1));
			grade = in.nextInt();
			if(grade > 100 || grade < 0) {
				System.out.println("Invalid Input. Value should be 0-100");
			}
		    }while(grade > 100 || grade < 0);
				total += grade;
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int finalExam, studentCount, numOfA, numOfB, numOfC, numOfD, numOfF, end;
		String firstName, lastName;
		char answer, letterGrade;
		double percentage;
		numOfA = numOfB = numOfC = numOfD = numOfF = studentCount = end = 0;
		
		//While loop to allow multiple grade entries
		while(end == 0){
		studentCount++;
		
		//Checks for invalid name
    	do {
    		System.out.println("Please enter first name");
    		firstName = in.next();
    		if(!firstName.matches("[a-zA-Z]*$")) {
    			System.out.println("Invalid Input. Name should contain only letters");
    		}
    	}while(!firstName.matches("[a-zA-Z]*$"));
		
    	do {
    		System.out.println("Please enter last name");
    		lastName = in.next();
    		if(!lastName.matches("[a-zA-Z]*$")) {
    			System.out.println("Invalid Input. Name should contain only letters");
    		}
    	}while(!lastName.matches("[a-zA-Z]*$"));
    	
		
		//Allows multiple exam entries & sums the entries
		System.out.println("Number of exam entries?");
		int examNum = in.nextInt();
		enterGrade("exam", examNum);
		int examTotal = total;
		
		//Allows multiple project entries & sums the entries
		System.out.println("Number of project entries?");
		int projNum = in.nextInt();
		enterGrade("project", projNum);
		int projTotal = total;
		
	    //Allows multiple quiz entries & sums the entries
	    System.out.println("Number of quiz entries?");
	    int quizNum = in.nextInt();
	    enterGrade("quiz", quizNum);
	    int quizTotal = total;
	    
	    //Allows multiple lab entries & sums the entries
		System.out.println("Number of lab entries?");
		int labNum = in.nextInt();
		enterGrade("lab", labNum);
		int labTotal = total;
	    
	    System.out.println("Please enter grade for final exam");
	    finalExam = in.nextInt();
	    
	    //Takes how much each assignment is worth towards final grade
	    System.out.println("Weight of each assignment? E.g 0.5 is 50%.");
	    System.out.println("Exams: ");
	    double examWeight = in.nextDouble();
	    System.out.println("Projects: ");
	    double projWeight = in.nextDouble();
	    System.out.println("Quizzes: ");
	    double quizWeight = in.nextDouble();
	    System.out.println("Labs: ");
	    double labWeight = in.nextDouble();
	    System.out.println("Final: ");
	    double finalWeight = in.nextDouble();
	
	    double finalGrade = (((examTotal)/examNum)*examWeight) + 
        (((projTotal)/projNum)*projWeight) + (((quizTotal)/quizNum)*quizWeight) +
        (((labTotal)/labNum)*labWeight) + (finalExam*finalWeight);
	    
	    //Checks & gives penalty for attendance
	    System.out.println("Are you going to give a penalty for attendance? Type Y for yes, N for no");
	    answer = in.next().charAt(0);
	    if(answer == 'Y' || answer == 'y') {
	    	System.out.println("How much of percentage? E.g 0.09 is 9%");
	    	percentage = in.nextDouble();
	    	finalGrade = finalGrade - (finalGrade*percentage);
	    }
	    
	    //Determines letter grade & keeps track of how many students got each one
	    if(finalGrade >= 90 && finalGrade <= 100) {
	    	letterGrade = 'A';
	    	numOfA++;
	    }
	    else if(finalGrade >= 80 && finalGrade < 90) {
	    	letterGrade = 'B';
	    	numOfB++;
	    }
	    else if(finalGrade >= 70 && finalGrade < 80) {
	    	letterGrade = 'C';
	    	numOfC++;
	    }
	    else if(finalGrade >= 60 && finalGrade < 70) {
	    	letterGrade = 'D';
	    	numOfD++;
	    }
	    else {
	    	letterGrade = 'F';
	    	numOfF++;
	    }
	    
		System.out.println("Your name is " + firstName + " " + lastName);
		System.out.println("Your final grade is " + finalGrade);
		System.out.println("Your letter grade is " + letterGrade);
		
		//Determines whether any more students' grades will be entered
		System.out.println("Do you want to exit? (Yes/No)");
		String response = in.next();
		if(response.equalsIgnoreCase("yes")) {
			end = 1;
		}
		}
		System.out.println("Number of students surveyed is " + studentCount);
		System.out.println("Number of students with a A: " + numOfA);
		System.out.println("Number of students with a B: " + numOfB);
		System.out.println("Number of students with a C: " + numOfC);
		System.out.println("Number of students with a D: " + numOfD);
		System.out.println("Number of students with a F: " + numOfF);
	}
}