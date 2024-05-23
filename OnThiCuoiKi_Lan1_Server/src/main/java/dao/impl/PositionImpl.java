package dao.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import dao.PositionDao;
import entity.Position;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

/**
 * @author Nguyen Thi Nga
 * @date May 3, 2024
 */
public class PositionImpl implements PositionDao {

	private EntityManager em;
	
	
	public PositionImpl() {
		em = Persistence.createEntityManagerFactory("OnThiCuoiKi_Lan1_Server").createEntityManager();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Position> listPositions(String name, double salaryFrom, double salaryTo) {
		return em.createNamedQuery("Position.listPositionsByNameAndSalary", Position.class).setParameter(1, "%" + name + "%").setParameter(2, salaryFrom).setParameter(3, salaryTo).getResultList();
	}


	@Override
	public Map<Position, Integer> listYearsOfExperienceByPosition(String candidateID) {
		Map<Position, Integer> result = new LinkedHashMap<>();
		List<?> list = em.createNamedQuery("Position.listYearsOfExperienceByPosition").setParameter(1, candidateID).getResultList();
		list.stream().map(o->(Object[])o).forEach(a->{
			String positionId = (String) a[0];
			int count = (int) a[1];
			result.put(em.find(Position.class, positionId), count);
		});
		return result;
	}
	
	public static void main(String[] args) {
		PositionDao positionImpl = new PositionImpl();
		List<Position> list = positionImpl.listPositions("S", 10000, 15000);
		for (Position position : list) {
			System.out.println(position);
		}
		
		Set<Entry<Position, Integer>> result = positionImpl.listYearsOfExperienceByPosition("C102").entrySet();
		for (Entry<Position, Integer> entry : result) {
			System.err.println(entry);
		}
	}

}
