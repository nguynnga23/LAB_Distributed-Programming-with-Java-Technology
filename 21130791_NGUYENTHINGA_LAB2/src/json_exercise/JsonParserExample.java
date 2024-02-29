package json_exercise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.StringReader;

import jakarta.json.*;
import jakarta.json.stream.JsonParser;
public class JsonParserExample {
	public static void main(String[] args) throws FileNotFoundException {
		
		final String jsonData = "{\r\n" + "	\"restaurant_id\": \"40358429\",\r\n" + "	\"is_closed\": false,\r\n"
				+ "	\"name\": \"May May Kitchen\",\r\n" + "	\"address\": {\r\n" + "		\"building\": \"1269\",\r\n"
				+ "		\"coord\": [\r\n" + "			-73.871194,\r\n" + "			40.6730975\r\n" + "		],\r\n"
				+ "		\"street\": \"Sutter Avenue\",\r\n" + "		\"zipcode\": \"11208\"\r\n" + "	},\r\n"
				+ "	\"borough\": \"Brooklyn\",\r\n" + "	\"cuisine\": \"Chinese\",\r\n" + "	\"grades\": [\r\n"
				+ "		{\r\n" + "			\"date\": {\r\n" + "				\"year\": 2014,\r\n"
				+ "				\"month\": 9,\r\n" + "				\"day\": 16\r\n" + "			},\r\n"
				+ "			\"grade\": \"B\",\r\n" + "			\"score\": 21\r\n" + "		},\r\n" + "		{\r\n"
				+ "			\"date\": {\r\n" + "				\"year\": 2013,\r\n"
				+ "				\"month\": 8,\r\n" + "				\"day\": 28\r\n" + "			},\r\n"
				+ "			\"grade\": \"A\",\r\n" + "			\"score\": 7\r\n" + "		}\r\n" + "	]\r\n" + "}";

		final StringReader stringReader = new StringReader(jsonData);

		JsonParser jsonParser = Json.createParser(stringReader);

		while (jsonParser.hasNext()) {
			JsonParser.Event event = jsonParser.next();

			switch (event) {
			case START_ARRAY:
				System.out.println("*Start Array*");
				break;
			case END_ARRAY:
				System.out.println("*End Array*");
				break;
			case START_OBJECT:
                System.out.println("** Start Object **");
                break;
            case END_OBJECT:
                System.out.println("** End Object **");
                break;
            case KEY_NAME:
            	System.out.println("Key: " + jsonParser.getString());
            	break;
            case VALUE_STRING:
            	System.out.println("String Value: " + jsonParser.getString());
            	break;
            case VALUE_NUMBER:
            	System.out.println("Number Value: " + jsonParser.getBigDecimal());
            	break;
            case VALUE_TRUE:
            	System.out.println("True Value: " + jsonParser.getValue());
            	break;
            case VALUE_FALSE:
            	System.out.println("False Value: " + jsonParser.getValue());
            	break;
			}

		}
		stringReader.close();

		
	}

}
