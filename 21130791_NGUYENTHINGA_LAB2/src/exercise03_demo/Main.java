package exercise03_demo;


import java.util.List;

import exercise03_entity.State;
import exercise03_handler.StateTheStreamingAPI;

/**
 * @author Nguyen Thi Nga
 * @date Feb 22, 2024
 */
public class Main {
	public static void main(String[] args) {
//		List<State> states = StateTheStreamingAPI.findByYear(1899);
//		states.forEach(st -> System.out.println(st));
		
//		List<State> states = StateTheStreamingAPI.getStates();
//		states.forEach(st -> System.out.println(st));
		
		State st = StateTheStreamingAPI.findByAb("al");
    	System.out.println(st);
		
	}
}
