package exercise02_json_p;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jakarta.json.*;

import exercise02_entity.Address;
import exercise02_entity.Person;
import exercise02_entity.PhoneNumbers;

public class JsonToObject_Stream {
	public static void main(String[] args) throws Exception {

		InputStream in = new FileInputStream("json/person.json");
		JsonReader reader = Json.createReader(in);

		JsonObject jo = reader.readObject();
		String firstName = jo.getString("firstName");
		String lastName = jo.getString("lastName");
		JsonNumber age = jo.getJsonNumber("age");

		JsonObject addressObject = jo.getJsonObject("address");
		String streetAddress = addressObject.getString("streetAddress");
		String city = addressObject.getString("city");
		String state = addressObject.getString("state");
		int postalCode = addressObject.getInt("postalCode");
		Address address = new Address(streetAddress, city, state, postalCode);

		JsonArray phoneNumbersArray = jo.getJsonArray("phoneNumbers");
		List<PhoneNumbers> pnList = new ArrayList<>();
		for (int i = 0; i < phoneNumbersArray.size(); i++) {
			JsonObject phoneNumberObject = phoneNumbersArray.getJsonObject(i);
			String type = phoneNumberObject.getString("type");
			String number = phoneNumberObject.getString("number");
			pnList.add(new PhoneNumbers(type, number));
		}

		Person p = new Person(firstName, lastName, postalCode, address, pnList);
		System.out.println(p.toString());


	}
}
