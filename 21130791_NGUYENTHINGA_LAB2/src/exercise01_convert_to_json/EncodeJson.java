package exercise01_convert_to_json;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import jakarta.json.*;

public class EncodeJson {
	public static void main(String[] args) throws Exception {
		EncodeJson ej = new EncodeJson();
		Employee e = new Employee(10001, "Thân Thị Đẹt", 10000d);
		String js = ej.genjson(e);
		ej.export("emp.json", js);
	}

	private String genjson(Employee e) {
		JsonObjectBuilder builder = Json.createObjectBuilder();
		builder.add("id", e.getId());
		builder.add("name", e.getName());
		builder.add("salary", e.getSalary());
		JsonObject jo = builder.build();

		return jo.toString();
	}

	public void export(String filePath, String js) throws Exception {
		PrintWriter out = new PrintWriter(new FileOutputStream(filePath), true);
		out.print(js);
		out.close();

	}
}
