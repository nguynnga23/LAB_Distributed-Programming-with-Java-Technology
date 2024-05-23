package dao;

import java.util.List;
import java.util.Map;

import entity.Position;

/**
 * @author Nguyen Thi Nga
 * @date May 3, 2024
 */
public interface PositionDao {
	public List<Position> listPositions(String name, double salaryFrom, double salaryTo);
	public Map<Position, Integer> listYearsOfExperienceByPosition(String candidateID);
}
