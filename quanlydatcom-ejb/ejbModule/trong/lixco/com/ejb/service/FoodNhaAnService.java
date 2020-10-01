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
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import trong.lixco.com.jpa.entity.FoodByDay;
import trong.lixco.com.jpa.entity.FoodNhaAn;
import trong.lixco.com.jpa.entity.OrderAndFoodByDate;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class FoodNhaAnService extends AbstractService<FoodNhaAn> {
	@Inject
	private EntityManager em;
	@Resource
	private SessionContext ct;

	@Override
	protected Class<FoodNhaAn> getEntityClass() {
		return FoodNhaAn.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@Override
	protected SessionContext getUt() {
		return ct;
	}

	public List<FoodNhaAn> findByDate(Date dateSearch, int shifts) {
		// primary
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<FoodNhaAn> cq = cb.createQuery(FoodNhaAn.class);
		Root<FoodNhaAn> root = cq.from(FoodNhaAn.class);
		List<Predicate> queries = new ArrayList<>();
		if (dateSearch != null) {
			Predicate dateQuery = cb.equal(root.get("food_date"), dateSearch);
			queries.add(dateQuery);
		}
		if (shifts != 0) {
			Predicate shiftsQuery = cb.equal(root.get("shifts"), shifts);
			queries.add(shiftsQuery);
		}

		Predicate data[] = new Predicate[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			data[i] = queries.get(i);
		}
		Predicate finalPredicate = cb.and(data);
		cq.where(finalPredicate);
		TypedQuery<FoodNhaAn> query = em.createQuery(cq);
		List<FoodNhaAn> results = query.getResultList();
		if (!results.isEmpty()) {
			return results;
		} else {
			return new ArrayList<FoodNhaAn>();
		}
	}

	// find theo ngay, ca, mon an
	public List<FoodNhaAn> find(Date dateSearch, long shifts, long categoryFoodId) {
		// primary
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<FoodNhaAn> cq = cb.createQuery(FoodNhaAn.class);
		Root<FoodNhaAn> root = cq.from(FoodNhaAn.class);
		List<Predicate> queries = new ArrayList<>();
		if (dateSearch != null) {
			Predicate dateQuery = cb.equal(root.get("food_date"), dateSearch);
			queries.add(dateQuery);
		}
		if (shifts != 0) {
			Predicate shiftsQuery = cb.equal(root.get("shifts"), shifts);
			queries.add(shiftsQuery);
		}
		if (categoryFoodId != 0) {
			Predicate shiftsQuery = cb.equal(root.get("category_food").get("id"), categoryFoodId);
			queries.add(shiftsQuery);
		}

		Predicate data[] = new Predicate[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			data[i] = queries.get(i);
		}
		Predicate finalPredicate = cb.and(data);
		cq.where(finalPredicate);
		TypedQuery<FoodNhaAn> query = em.createQuery(cq);
		List<FoodNhaAn> results = query.getResultList();
		if (!results.isEmpty()) {
			return results;
		} else {
			return new ArrayList<FoodNhaAn>();
		}
	}

	// find tu ngay den ngay
	public List<FoodNhaAn> findByDayToDaySortByDateAndShifts(java.util.Date firstDay, java.util.Date lastDay,
			String departmentCode) {
		// primary
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<FoodNhaAn> cq = cb.createQuery(FoodNhaAn.class);
		Root<FoodNhaAn> root = cq.from(FoodNhaAn.class);
		List<Predicate> queries = new ArrayList<>();
		if (firstDay != null) {
			Predicate resultQueryFirst = cb.greaterThanOrEqualTo(root.get("food_date"), firstDay);
			queries.add(resultQueryFirst);
		}
		if (lastDay != null) {
			Predicate resultQueryLast = cb.lessThanOrEqualTo(root.get("food_date"), lastDay);
			queries.add(resultQueryLast);
		}
		if (departmentCode != null) {
			Predicate resultQueryDepartCode = cb.equal(root.get("department_code"), departmentCode);
			queries.add(resultQueryDepartCode);
		}
		Predicate data[] = new Predicate[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			data[i] = queries.get(i);
		}
		Predicate finalPredicate = cb.and(data);
		cq.select(root).where(finalPredicate).orderBy(cb.asc(root.get("food_date")),
				cb.asc(root.get("shifts").get("id")));
		TypedQuery<FoodNhaAn> query = em.createQuery(cq);
		List<FoodNhaAn> results = query.getResultList();
		if (!results.isEmpty()) {
			return results;
		} else {
			return new ArrayList<FoodNhaAn>();
		}
	}

	// find tu ngay den ngay
	public List<FoodNhaAn> findByDayToDaySortByDateAndFoodName(java.util.Date firstDay, java.util.Date lastDay,
			String departmentCode) {
		// primary
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<FoodNhaAn> cq = cb.createQuery(FoodNhaAn.class);
		Root<FoodNhaAn> root = cq.from(FoodNhaAn.class);
		List<Predicate> queries = new ArrayList<>();
		if (firstDay != null) {
			Predicate resultQueryFirst = cb.greaterThanOrEqualTo(root.get("food_date"), firstDay);
			queries.add(resultQueryFirst);
		}
		if (lastDay != null) {
			Predicate resultQueryLast = cb.lessThanOrEqualTo(root.get("food_date"), lastDay);
			queries.add(resultQueryLast);
		}
		if (departmentCode != null) {
			Predicate resultQueryDepartCode = cb.equal(root.get("department_code"), departmentCode);
			queries.add(resultQueryDepartCode);
		}
		Predicate data[] = new Predicate[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			data[i] = queries.get(i);
		}
		Predicate finalPredicate = cb.and(data);
		cq.select(root).where(finalPredicate).orderBy(cb.asc(root.get("food_date")),
				cb.asc(root.get("category_food").get("name")));
		TypedQuery<FoodNhaAn> query = em.createQuery(cq);
		List<FoodNhaAn> results = query.getResultList();
		if (!results.isEmpty()) {
			return results;
		} else {
			return new ArrayList<FoodNhaAn>();
		}
	}

}
