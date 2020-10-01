package trong.lixco.com.ejb.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import trong.lixco.com.jpa.entity.FoodByDay;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class FoodDayByDayService extends AbstractService<FoodByDay> {
	@Inject
	private EntityManager em;
	@Resource
	private SessionContext ct;

	@Override
	protected Class<FoodByDay> getEntityClass() {
		return FoodByDay.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@Override
	protected SessionContext getUt() {
		return ct;
	}

	public List<FoodByDay> findByDate(Date date, long shiftsId) {
		// primary
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<FoodByDay> cq = cb.createQuery(FoodByDay.class);
		Root<FoodByDay> root = cq.from(FoodByDay.class);
		List<Predicate> queries = new ArrayList<>();
		if (date != null) {
			Predicate dateQuery = cb.equal(root.get("food_date"), date);
			queries.add(dateQuery);
		}
		if (shiftsId != 0) {
			Predicate shiftsQuery = cb.equal(root.get("shifts").get("id"), shiftsId);
			queries.add(shiftsQuery);
		}

		Predicate data[] = new Predicate[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			data[i] = queries.get(i);
		}
		Predicate finalPredicate = cb.and(data);
		cq.where(finalPredicate);
		TypedQuery<FoodByDay> query = em.createQuery(cq);
		List<FoodByDay> results = query.getResultList();
		if (!results.isEmpty()) {
			return results;
		} else {
			return new ArrayList<FoodByDay>();
		}
	}

	public List<FoodByDay> findByDate(Date date, int shifts, long categoryFood_id) {
		// primary
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<FoodByDay> cq = cb.createQuery(FoodByDay.class);
		Root<FoodByDay> root = cq.from(FoodByDay.class);
		List<Predicate> queries = new ArrayList<>();
		if (date != null) {
			Predicate dateQuery = cb.equal(root.get("food_date"), date);
			queries.add(dateQuery);
		}
		if (shifts != 0) {
			Predicate shiftsQuery = cb.equal(root.get("shifts"), shifts);
			queries.add(shiftsQuery);
		}
		if (shifts != 0) {
			Predicate shiftsQuery = cb.equal(root.get("category_food").get("id"), categoryFood_id);
			queries.add(shiftsQuery);
		}

		Predicate data[] = new Predicate[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			data[i] = queries.get(i);
		}
		Predicate finalPredicate = cb.and(data);
		cq.where(finalPredicate);
		TypedQuery<FoodByDay> query = em.createQuery(cq);
		List<FoodByDay> results = query.getResultList();
		if (!results.isEmpty()) {
			return results;
		} else {
			return new ArrayList<FoodByDay>();
		}
	}

	public List<FoodByDay> findByDayToDaySortByDate(java.util.Date firstDay, java.util.Date lastDay) {
		// primary
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<FoodByDay> cq = cb.createQuery(FoodByDay.class);
		Root<FoodByDay> root = cq.from(FoodByDay.class);
		List<Predicate> queries = new ArrayList<>();
		if (firstDay != null) {
			Predicate resultQueryFirst = cb.greaterThanOrEqualTo(root.get("food_date"), firstDay);
			queries.add(resultQueryFirst);
		}
		if (lastDay != null) {
			Predicate resultQueryLast = cb.lessThanOrEqualTo(root.get("food_date"), lastDay);
			queries.add(resultQueryLast);
		}
		Predicate data[] = new Predicate[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			data[i] = queries.get(i);
		}
		Predicate finalPredicate = cb.and(data);
		cq.select(root).where(finalPredicate).orderBy(cb.asc(root.get("food_date")),
				cb.asc(root.get("shifts").get("id")));
		TypedQuery<FoodByDay> query = em.createQuery(cq);
		List<FoodByDay> results = query.getResultList();
		if (!results.isEmpty()) {
			return results;
		} else {
			return new ArrayList<FoodByDay>();
		}
	}

	// Native query
	public void deleteFoodByDayByDate(Date date) {
		try {
			String sql = "DELETE FROM FoodDayByDay WHERE FoodDayByDay_date = ?";
			Query query = em.createNativeQuery(sql, FoodByDay.class);
			query.setParameter(1, date);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
