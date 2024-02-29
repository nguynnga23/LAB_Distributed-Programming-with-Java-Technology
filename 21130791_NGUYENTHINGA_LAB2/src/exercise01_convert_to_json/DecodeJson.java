package exercise01_convert_to_json;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.StringReader;

import jakarta.json.*;
import jakarta.json.stream.JsonParser;
import jakarta.json.stream.JsonParser.Event;

public class DecodeJson {
	public static void main(String[] args) throws FileNotFoundException {

//		InputStream in = new FileInputStream("json/emp.json");
//		JsonReader reader = Json.createReader(in);
//
//		JsonObject jo = ((javax.json.JsonReader) reader).readObject();
//		JsonNumber id = jo.getJsonNumber("id");
//		String name = jo.getString("name");
//		JsonNumber sal = jo.getJsonNumber("salary");
//		Employee emp = new Employee(id.longValue(), name, sal.doubleValue());
//		System.out.println(emp);

		// Sử dụng JSON-P Streaming API

		final String result = "{\"name\":\"Falco\",\"age\":3,\"bitable\":true}";
		final JsonParser parser = Json.createParser(new StringReader(result));
		String key = null;
		String value = null;
		while (parser.hasNext()) {
			final Event event = parser.next();
			switch (event) {
			case KEY_NAME:
				key = parser.getString();
				System.out.println("Name : " + key);
				break;
			case VALUE_STRING:
				value = parser.getString();
				System.out.println("String Value : " + value);
				break;
			case END_ARRAY:
				break;
			case END_OBJECT:
				break;
			case START_ARRAY:
				break;
			case START_OBJECT:
				break;
			case VALUE_FALSE:
				System.out.println("False Value : " + parser.getValue());
				break;
			case VALUE_NULL:
				break;
			case VALUE_NUMBER:
				System.out.println("Number Value : " + parser.getInt());
				break;
			case VALUE_TRUE:
				System.out.println("True Value : " + parser.getValue());
				break;
			default:
				break;
			}
		}
		parser.close();
	}
}
