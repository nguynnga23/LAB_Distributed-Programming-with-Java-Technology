package util;

import java.net.URI;
import java.util.Map;

import org.neo4j.driver.AuthToken;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.types.Node;

import com.google.gson.Gson;

public class AppUtil {
	static Gson GSON = new Gson();
	public static Driver unitDriver() {
		URI uri = URI.create("neo4j://localhost:7687");
		String us = "neo4j";
		String pw = "12345678";
		
		return GraphDatabase.driver(uri, AuthTokens.basic(us, pw));
	}
	
	public static <T> T convert(Node node, Class<T> clazz) {
		Map<String, Object> map = node.asMap();
		System.out.println(map);
		String json = GSON.toJson(map);
		System.out.println(json);
		return GSON.fromJson(json, clazz);
	}
}
