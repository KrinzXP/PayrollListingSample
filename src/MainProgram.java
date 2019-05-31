import java.util.*;
import java.math.*;
import java.text.*;
import java.time.*;

import enumLibrary.Gender;
import classLibrary.*;

public class MainProgram {
	
	private static Scanner scanner = new Scanner(System.in);
	private static String input;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mainMenuProcess(scanner);
		scanner.close();
	}
	
	public static boolean validateInput(String input, int maxMenu) {
		boolean validation = false;
		try {
			int numericInput = Integer.parseInt(input);
			if(numericInput <= maxMenu && numericInput >= 1) {
				validation = true;
			} else {
				System.out.printf("Tolong masukan antara 1 - %d\n", maxMenu);
			}
		}catch(Exception exception) {
			System.out.println("Format yang anda masukan salah, coba lagi.");
		}
		return validation;
	}
	//Main Menu
	public static void printMainMenu()
	{
		System.out.println("Payroll System");
		System.out.println("1. Employee Menu");
		System.out.println("2. Show Full Time Employee");
		System.out.println("3. Show Part Time Employee");
		System.out.println("4. Exit Application");
	}

	public static void mainMenuProcess(Scanner scanner)
	{
		printMainMenu();
		input = scanner.nextLine();
		boolean validateInput = validateInput(input, 4);
		if(validateInput == false)
		{
			mainMenuProcess(scanner);
		}
		
			switch (input)
			{
				case "1":
					employeeMenuProcess(scanner);
					break;
				case "2":
					Payroll.printFullTimeEmployeeList();
					Payroll.printDetailGajiFullTime();
					mainMenuProcess(scanner);
					break;
				case "3":
					Payroll.printPartTimeEmployeeList();
					Payroll.printDetailGajiPartTime();
					mainMenuProcess(scanner);
					break;
				case "4":
					System.exit(0);
				default:
					System.out.println("Ada masalah dengan program");
					break;
			}
		
	}

	//Employee Menu
	public static void printEmployeeMenu()
	{
		System.out.println("1. Add Employee");
		System.out.println("2. Set Employee Status");
		System.out.println("3. Back to Main Menu");
		System.out.println("4. Exit Application");
	}
	
	public static void employeeMenuProcess(Scanner scanner) {
		// TODO Auto-generated method stub
		Payroll.printEmployeeList();
		printEmployeeMenu();
		input = scanner.nextLine();
		boolean validateInput = validateInput(input, 3);
		if(validateInput == false)
		{
			employeeMenuProcess(scanner);
		}
		
		switch(input)
		{
			case "1":
				Payroll.addEmployee();
				employeeMenuProcess(scanner);
				break;
				
			case "2":
				Payroll.setEmployeeStatus();
				employeeMenuProcess(scanner);
				break;
				
			case "3":
				mainMenuProcess(scanner);
				break;
				
			case "4":
				System.exit(0);
				
			default:
				System.out.println("Ada masalah dengan program");
				break;
		}
	}

}
