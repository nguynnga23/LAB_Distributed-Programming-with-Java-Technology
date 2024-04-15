package util;

import java.net.URI;
import java.util.Map;

import org.neo4j.driver.AuthToken;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.types.Node;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author Nguyen Thi Nga
 * @date Mar 1, 2024
 */
public class AppUtil {
	public static Driver driverInit() {
		URI uri  = URI.create("neo4j://localhost:7687");
		String username = "neo4j";
		String password = "12345678";
		return GraphDatabase.driver(uri, AuthTokens.basic(username, password));
	}
	
	private static final Gson GSON = new GsonBuilder().create();
	public static <T> T nodeToPOJO(Node node, Class<T> clazz) {
		Map<String, Object> properties = node.asMap();
		String json = GSON.toJson(properties);
		T obj = GSON.fromJson(json, clazz);
		return obj;
	}
	
	public static <T> Map<String, Object> getProperties(T obj) {
        String json = GSON.toJson(obj);
        Map<String, Object> properties = GSON.fromJson(json, new TypeToken<Map<String, Object>>(){});
        return properties;
    }
}
