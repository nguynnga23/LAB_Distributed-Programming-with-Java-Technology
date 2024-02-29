package exercise02_gson;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.json.*;

import exercise02_entity.Address;
import exercise02_entity.Person;
import exercise02_entity.PhoneNumbers;

public class ObjectSetToJson_OM {
	private static ObjectToJson_OM cj;
	private static String jsonArrayString;

	public static void main(String[] args) throws Exception {
		Address a = new Address("21 2nd Street", "New York", "NY", 10021);
		PhoneNumbers pn1 = new PhoneNumbers("home", "212 555-1234");
		PhoneNumbers pn2 = new PhoneNumbers("fax", "646 555-4567");

		ArrayList<PhoneNumbers> pns = new ArrayList<PhoneNumbers>();
		pns.add(pn1);
		pns.add(pn2);

		Person p1 = new Person("John-1", "Smith-1", 25, a, pns);
		Person p2 = new Person("John-2", "Smith-2", 25, a, pns);
		Person p3 = new Person("John-3", "Smith-3", 25, a, pns);

		List<Person> pList = new ArrayList<>();
		pList.add(p1);
		pList.add(p2);
		pList.add(p3);

		jsonArrayString = convertListToJSon(pList);
//		System.out.println("Converted JSON Array:\n" + jsonArrayString);
		cj.export("json/people.json", jsonArrayString);

	}

	public static String convertListToJSon(List<Person> pList) {
		JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
		try {
//			cj = new ObjectToJson_OM();
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Person p : pList) {
			JsonObjectBuilder builder = Json.createObjectBuilder();
			builder.add("firstName", p.getFirstName());
			builder.add("lastName", p.getLastName());
			builder.add("age", p.getAge());

			// Tạo đối tượng địa chỉ
			JsonObjectBuilder addressBuilder = Json.createObjectBuilder();
			addressBuilder.add("streetAddress", p.getAddress().getStreetAddress());
			addressBuilder.add("city", p.getAddress().getCity());
			addressBuilder.add("state", p.getAddress().getState());
			addressBuilder.add("postalCode", p.getAddress().getPostalCode());

			// Tạo mảng JSON cho danh sách số điện thoại
			JsonArrayBuilder pnArrayBuilder = Json.createArrayBuilder();
			for (PhoneNumbers pn : p.getPhoneNumber()) {
				JsonObjectBuilder pnBuilder = Json.createObjectBuilder();
				pnBuilder.add("type", pn.getType());
				pnBuilder.add("number", pn.getNumber());
				pnArrayBuilder.add(pnBuilder);
			}
			// Thêm address và phoneNumbers vào builder
			builder.add("address", addressBuilder);
			builder.add("phoneNumbers", pnArrayBuilder);

			jsonArrayBuilder.add(builder);

		}
		return jsonArrayBuilder.build().toString();
	}

	public static void export(String filePath, String json) throws Exception {
		PrintWriter out = new PrintWriter(new FileOutputStream(filePath), true);
		out.println(json);
		out.close();
	}
}
