package exercise02_gson;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.json.*;

import exercise02_entity.Address;
import exercise02_entity.Person;
import exercise02_entity.PhoneNumbers;

public class ObjectToJson_OM {
	public static void main(String[] args) throws Exception {
		ObjectToJson_OM cj = new ObjectToJson_OM();
		Address a = new Address("21 2nd Street", "New York", "NY", 10021);
		PhoneNumbers pn1 = new PhoneNumbers("home", "212 555-1234");
		PhoneNumbers pn2 = new PhoneNumbers("fax", "646 555-4567");

		ArrayList<PhoneNumbers> pns = new ArrayList<PhoneNumbers>();
		pns.add(pn1);
		pns.add(pn2);
		Person p = new Person("John", "Smith", 25, a, pns);
		
		String js = cj.genjson(p);
		cj.export("json/person.json", js);
	}

	public String genjson(Person p) {
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
		
		return builder.build().toString();
	}
	
	public void export(String filePath, String json) throws Exception {
//		Writer out = new JsonWriter(new FileOutputStream(filePath), true);
//		out.println(json);
//		out.close();
	}
}
