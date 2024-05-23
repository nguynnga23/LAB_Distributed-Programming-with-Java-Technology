package dao.impl;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import dao.CandidateDao;
import entity.Candidate;
import entity.Certificate;
import entity.Position;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * @author Nguyen Thi Nga
 * @date May 3, 2024
 */
public class CandidateImpl implements CandidateDao {
	private EntityManager em;

	public CandidateImpl() {
		em = Persistence.createEntityManagerFactory("OnThiCuoiKi_Lan1_Server").createEntityManager();
	}

	@Override
	public Map<Candidate, Long> listCadidatesByCompanies() {
		Map<Candidate, Long> result = new LinkedHashMap<>();
		List<?> list = em.createNamedQuery("Cadidate.listCadidatesByCompanies").getResultList();
		list.stream().map(o -> (Object[]) o).forEach(a -> {
			String id = (String) a[0];
			Long n = Long.valueOf((Integer) a[1]);
			result.put(em.find(Candidate.class, id), n);
		});
		return result;
	}

	@Override
	public boolean addCandidate(Candidate candidate) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(candidate);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Map<Candidate, Set<Certificate>> listCandidatesAndCertificates() {
		Map<Candidate, Set<Certificate>> result = new LinkedHashMap<>();
		List<?> list = em.createNamedQuery("Cadidate.listCandidatesAndCertificates").getResultList();
		list.stream().map(o -> (Object[]) o).forEach(a -> {
			String candidateId = (String) a[0];
			String certificateId = (String) a[1];
					
			Candidate c = em.find(Candidate.class, candidateId);
			Certificate ce = em.find(Certificate.class, certificateId);
			
			 // If the candidate is not already in the map, add it with an empty set
	        result.putIfAbsent(c, new HashSet<>());

	        // Add the certificate to the set of certificates for the candidate
	        result.get(c).add(ce);
		});
		return result;
	}

	@Override
	public Map<Candidate, Position> listCandidatesWithLongestWorking() {
		Map<Candidate, Position> result = new LinkedHashMap<>();
		List<?> list = em.createNamedQuery("Cadidate.listCandidatesWithLongestWorking").getResultList();
		list.stream().map(o -> (Object[]) o).forEach(a -> {
			String candidateId = (String) a[0];
			String positionId = (String) a[1];
			result.put(em.find(Candidate.class, candidateId), em.find(Position.class, positionId));
		});
		return result;
	}

	public static void main(String[] args) {
		CandidateImpl candidateDao = new CandidateImpl();
		Set<Entry<Candidate, Position>> list = candidateDao.listCandidatesWithLongestWorking().entrySet();
		for (Entry<Candidate, Position> entry : list) {
			System.err.println(entry.getKey().getFullName() + "=" + entry.getValue().getId());
		}
		Candidate c = new Candidate("C239", "Nguyen Thi Nga", 2003, "Female", "nguyenga@gmail.com", "077-6466-141", "Sinh vien xuat sac");
		System.out.println(candidateDao.addCandidate(c));
		
		Set<Entry<Candidate, Set<Certificate>>> list2 = candidateDao.listCandidatesAndCertificates().entrySet();
		for (Entry<Candidate, Set<Certificate>> entry : list2) {
			System.out.println(entry);
		}
	}
}
