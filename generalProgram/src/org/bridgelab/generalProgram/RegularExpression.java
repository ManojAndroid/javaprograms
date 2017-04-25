package org.bridgelab.generalProgram;

import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegularExpression {

	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);
		FileReader fileReader = new FileReader("/home/bridgeit/manojjava/regularExpression.txt");

		String message = "";
		String fullName;
		String fName = "";
		String mobile;

		int x = fileReader.read();

		while (x != -1) {
			message = message + (char) x;
			x = fileReader.read();
		}
		System.out.println(message);

		System.out.println("Enter your Full name");
		fullName = scanner.nextLine();

		boolean checkName = Pattern.matches("[A-Za-z][a-zA-Z]*[\\s][A-Za-z][a-zA-Z]*", fullName);

		if (checkName) {
			String[] name = fullName.split(" ");
			fName = name[0];
		}

		System.out.println("Enter your mobile Number");
		mobile = scanner.next();

		boolean checkNum = Pattern.matches("[789]{1}\\d{9}", mobile);

		if (!checkNum) {
			System.out.println("Incorrect Number");
			System.exit(0);
		}

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String date = dateFormat.format(new Date());

		System.out.println(date);
		message = message.replace("<<name>>", fName);
		message = message.replace("<<full name>>", fullName);
		message = message.replace("xxxxxxxxxx", mobile);
		message = message.replace("dd/mm/yyyy", date);
		System.out.println("\n" + message);
	}

}