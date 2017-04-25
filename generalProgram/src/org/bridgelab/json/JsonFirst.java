package org.bridgelab.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFirst {
	public static void main(String args[]) {

		// JSON String
		String jsonString = "[{\"name\":\"Manoj\",\"rollNo\":" + "\"Btech/07/01\",\"id\":10},{\"name\":\"jagdish\",\""
				+ "rollNo\":\"MCA/07/39\",\"id\":50}]";

		JSONParser parser = new JSONParser(); // Create JSON parser object.
		try {

			Object object = parser.parse(jsonString); // Parse JSON string using
														// JSON parser.
			JSONArray array = (JSONArray) object;
			System.out.println("First object:");
			System.out.println(array.get(0));
			System.out.println(array.get(1));

			JSONObject jsonObject = (JSONObject) array.get(1); // Get JSON
																// object from
																// JSON array.
			System.out.println("Second object:");
			System.out.println("Name  :" + jsonObject.get("name"));
			System.out.println("RollNo:  " + jsonObject.get("rollNo"));
			System.out.println("Id    :" + jsonObject.get("id"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
