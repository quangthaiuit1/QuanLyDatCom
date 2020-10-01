package trong.lixco.com.ejb.service;

import java.util.ArrayList;
import java.util.Date;
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

import trong.lixco.com.jpa.entity.OrderAndFoodByDate;
import trong.lixco.com.jpa.entity.OrderFood;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class OrderAndFoodByDateService extends AbstractService<OrderAndFoodByDate> {
	@Inject
	private EntityManager em;
	@Resource
	private SessionContext ct;

	@Override
	protected Class<OrderAndFoodByDate> getEntityClass() {
		return OrderAndFoodByDate.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@Override
	protected SessionContext getUt() {
		return ct;
	}

	public List<OrderAndFoodByDate> findByDate(java.sql.Date date, String employeeCode) {
		// primary
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<OrderAndFoodByDate> cq = cb.createQuery(OrderAndFoodByDate.class);
		Root<OrderAndFoodByDate> root = cq.from(OrderAndFoodByDate.class);
		List<Predicate> queries = new ArrayList<>();
		if (date != null) {
			Predicate resultQueryFirst = cb.equal(root.get("order_food").get("registration_date"), date);
			queries.add(resultQueryFirst);
		}
		if (employeeCode != null) {
			Predicate resultQuerySecond = cb.equal(root.get("order_food").get("employeeCode"), employeeCode);
			queries.add(resultQuerySecond);
		}
		Predicate data[] = new Predicate[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			data[i] = queries.get(i);
		}
		Predicate finalPredicate = cb.and(data);
		cq.select(root).where(finalPredicate).orderBy(cb.asc(root.get("food_by_day").get("shifts").get("id")));
		TypedQuery<OrderAndFoodByDate> query = em.createQuery(cq);
		List<OrderAndFoodByDate> results = query.getResultList();
		if (!results.isEmpty()) {
			return results;
		} else {
			return new ArrayList<OrderAndFoodByDate>();
		}
	}

	public List<OrderAndFoodByDate> find(java.sql.Date date, long shiftsId, String employeeCode) {
		// primary
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<OrderAndFoodByDate> cq = cb.createQuery(OrderAndFoodByDate.class);
		Root<OrderAndFoodByDate> root = cq.from(OrderAndFoodByDate.class);
		List<Predicate> queries = new ArrayList<>();
		if (date != null) {
			Predicate resultQueryFirst = cb.equal(root.get("order_food").get("registration_date"), date);
			queries.add(resultQueryFirst);
		}
		if (employeeCode != null) {
			Predicate resultQuerySecond = cb.equal(root.get("order_food").get("employeeCode"), employeeCode);
			queries.add(resultQuerySecond);
		}
		if (shiftsId != 0) {
			Predicate resultQuerySecond = cb.equal(root.get("food_by_day").get("shifts").get("id"), shiftsId);
			queries.add(resultQuerySecond);
		}
		Predicate data[] = new Predicate[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			data[i] = queries.get(i);
		}
		Predicate finalPredicate = cb.and(data);
		cq.select(root).where(finalPredicate);
		TypedQuery<OrderAndFoodByDate> query = em.createQuery(cq);
		List<OrderAndFoodByDate> results = query.getResultList();
		if (!results.isEmpty()) {
			return results;
		} else {
			return new ArrayList<OrderAndFoodByDate>();
		}
	}

	public List<OrderAndFoodByDate> findByShiftsId(long orderFoodId, long shiftsId) {
		// primary
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<OrderAndFoodByDate> cq = cb.createQuery(OrderAndFoodByDate.class);
		Root<OrderAndFoodByDate> root = cq.from(OrderAndFoodByDate.class);
		List<Predicate> queries = new ArrayList<>();
		if (orderFoodId != 0) {
			Predicate resultQuerySecond = cb.equal(root.get("order_food").get("id"), orderFoodId);
			queries.add(resultQuerySecond);
		}
		if (shiftsId != 0) {
			Predicate resultQueryFirst = cb.equal(root.get("food_by_day").get("shifts").get("id"), shiftsId);
			queries.add(resultQueryFirst);
		}
		Predicate data[] = new Predicate[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			data[i] = queries.get(i);
		}
		Predicate finalPredicate = cb.and(data);
		cq.select(root).where(finalPredicate);
		TypedQuery<OrderAndFoodByDate> query = em.createQuery(cq);
		List<OrderAndFoodByDate> results = query.getResultList();
		if (!results.isEmpty()) {
			return results;
		} else {
			return new ArrayList<OrderAndFoodByDate>();
		}
	}

	// find tu ngay den ngay
	public List<OrderAndFoodByDate> findByDayToDaySortByDateAndShifts(Date firstDay, Date lastDay,
			String employeeCode) {
		// primary
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<OrderAndFoodByDate> cq = cb.createQuery(OrderAndFoodByDate.class);
		Root<OrderAndFoodByDate> root = cq.from(OrderAndFoodByDate.class);
		List<Predicate> queries = new ArrayList<>();
		if (firstDay != null) {
			Predicate resultQueryFirst = cb.greaterThanOrEqualTo(root.get("order_food").get("registration_date"),
					firstDay);
			queries.add(resultQueryFirst);
		}
		if (lastDay != null) {
			Predicate resultQueryLast = cb.lessThanOrEqualTo(root.get("order_food").get("registration_date"), lastDay);
			queries.add(resultQueryLast);
		}
		if (employeeCode != null) {
			Predicate resultQueryEmployeeCode = cb.equal(root.get("order_food").get("employeeCode"), employeeCode);
			queries.add(resultQueryEmployeeCode);
		}

		Predicate data[] = new Predicate[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			data[i] = queries.get(i);
		}
		Predicate finalPredicate = cb.and(data);
		cq.select(root).where(finalPredicate).orderBy(cb.asc(root.get("order_food").get("registration_date")),
				cb.asc(root.get("food_by_day").get("shifts").get("id")));
		TypedQuery<OrderAndFoodByDate> query = em.createQuery(cq);
		List<OrderAndFoodByDate> results = query.getResultList();
		if (!results.isEmpty()) {
			return results;
		} else {
			return new ArrayList<OrderAndFoodByDate>();
		}
	}

	public List<OrderAndFoodByDate> find(Date firstDay, Date lastDay, String employeeCode) {
		// primary
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<OrderAndFoodByDate> cq = cb.createQuery(OrderAndFoodByDate.class);
		Root<OrderAndFoodByDate> root = cq.from(OrderAndFoodByDate.class);
		List<Predicate> queries = new ArrayList<>();
		if (firstDay != null) {
			Predicate resultQueryFirst = cb.greaterThanOrEqualTo(root.get("order_food").get("registration_date"),
					firstDay);
			queries.add(resultQueryFirst);
		}
		if (lastDay != null) {
			Predicate resultQueryLast = cb.lessThanOrEqualTo(root.get("order_food").get("registration_date"), lastDay);
			queries.add(resultQueryLast);
		}
		if (employeeCode != null) {
			Predicate resultQueryEmployeeCode = cb.equal(root.get("order_food").get("employeeCode"), employeeCode);
			queries.add(resultQueryEmployeeCode);
		}

		Predicate data[] = new Predicate[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			data[i] = queries.get(i);
		}
		Predicate finalPredicate = cb.and(data);
		cq.select(root).where(finalPredicate);
		TypedQuery<OrderAndFoodByDate> query = em.createQuery(cq);
		List<OrderAndFoodByDate> results = query.getResultList();
		if (!results.isEmpty()) {
			return results;
		} else {
			return new ArrayList<OrderAndFoodByDate>();
		}
	}

	// tim theo ngay va ca
	public List<OrderAndFoodByDate> findByDateSortByEmplName(Date dateSearch, int shiftsId) {
		// primary
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<OrderAndFoodByDate> cq = cb.createQuery(OrderAndFoodByDate.class);
		Root<OrderAndFoodByDate> root = cq.from(OrderAndFoodByDate.class);
		List<Predicate> queries = new ArrayList<>();
		if (dateSearch != null) {
			Predicate resultQueryFirst = cb.equal(root.get("order_food").get("registration_date"), dateSearch);
			queries.add(resultQueryFirst);
		}
		if (shiftsId != 0) {
			Predicate resultQueryShiftsId = cb.equal(root.get("food_by_day").get("shifts").get("id"), shiftsId);
			queries.add(resultQueryShiftsId);
		}

		Predicate data[] = new Predicate[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			data[i] = queries.get(i);
		}
		Predicate finalPredicate = cb.and(data);
		cq.select(root).where(finalPredicate);
		TypedQuery<OrderAndFoodByDate> query = em.createQuery(cq);
		List<OrderAndFoodByDate> results = query.getResultList();
		if (!results.isEmpty()) {
			return results;
		} else {
			return new ArrayList<OrderAndFoodByDate>();
		}
	}

	public List<OrderAndFoodByDate> findByDayToDaySortByDateAndFoodName(Date firstDay, Date lastDay,
			String employeeCode) {
		// primary
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<OrderAndFoodByDate> cq = cb.createQuery(OrderAndFoodByDate.class);
		Root<OrderAndFoodByDate> root = cq.from(OrderAndFoodByDate.class);
		List<Predicate> queries = new ArrayList<>();
		if (firstDay != null) {
			Predicate resultQueryFirst = cb.greaterThanOrEqualTo(root.get("order_food").get("registration_date"),
					firstDay);
			queries.add(resultQueryFirst);
		}
		if (lastDay != null) {
			Predicate resultQueryLast = cb.lessThanOrEqualTo(root.get("order_food").get("registration_date"), lastDay);
			queries.add(resultQueryLast);
		}
		if (employeeCode != null) {
			Predicate resultQueryEmployeeCode = cb.equal(root.get("order_food").get("employeeCode"), employeeCode);
			queries.add(resultQueryEmployeeCode);
		}

		Predicate data[] = new Predicate[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			data[i] = queries.get(i);
		}
		Predicate finalPredicate = cb.and(data);
		cq.select(root).where(finalPredicate).orderBy(cb.asc(root.get("order_food").get("registration_date")),
				cb.asc(root.get("food_by_day").get("category_food").get("name")));
		TypedQuery<OrderAndFoodByDate> query = em.createQuery(cq);
		List<OrderAndFoodByDate> results = query.getResultList();
		if (!results.isEmpty()) {
			return results;
		} else {
			return new ArrayList<OrderAndFoodByDate>();
		}
	}
}
