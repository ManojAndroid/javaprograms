package org.bridgelab.generalProgram;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class json {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		FileWriter fw = null;
		JSONObject job = new JSONObject();

		String name = null;

		try {
			fw = new FileWriter("/home/bridgeit/vinay/JSONFile/jsonFile.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Enter the number of Products you want to keep");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Enter the Product name");
			name = sc.next();

			System.out.println("Enter the Item name");
			String iName = sc.next();

			System.out.println("Enter the Quantity");
			double weight = sc.nextDouble();

			System.out.println("Enter the price of the item per Kg");
			double price = sc.nextDouble();

			JSONArray jar = new JSONArray();

			jar.add("Item Name:" + iName);
			jar.add("Weight:" + weight + "Kgs");
			jar.add("Price:" + price + " per Kg");

			job.put(name, jar);

		}

		try {
			fw.write(job.toString());
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n\nYour Product details as fallows!!!!!!!!!\n\n");
		

		try {
			FileReader fr = new FileReader("/home/bridgeit/vinay/JSONFile/jsonFile.txt");

			JSONParser par = new JSONParser();

			Object ob = par.parse(fr);

			JSONObject jo = (JSONObject) ob;
			System.out.println("Rice");
			JSONArray ja = (JSONArray) jo.get("Rice");

			Iterator i = ja.iterator();

			while (i.hasNext()) 
			{
				System.out.println(i.next());
			}
			
			
			
			
			System.out.println("\n\nPulse");
			ja = (JSONArray) jo.get("Pulse");

			i = ja.iterator();

			while (i.hasNext()) 
			{
				System.out.println(i.next());
			}
			
			
			
			System.out.println("\n\nWheat");
			ja = (JSONArray) jo.get("Wheat");

			i = ja.iterator();

			while (i.hasNext()) 
			{
				System.out.println(i.next());
			}
			
			

		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

	}
}
