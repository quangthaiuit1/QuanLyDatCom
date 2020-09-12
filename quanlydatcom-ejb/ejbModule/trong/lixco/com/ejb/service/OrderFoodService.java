package trong.lixco.com.ejb.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
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
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import trong.lixco.com.jpa.entity.OrderFood;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class OrderFoodService extends AbstractService<OrderFood> {

	@Inject
	private EntityManager em;
	@Resource
	private SessionContext ct;

	@Override
	protected Class<OrderFood> getEntityClass() {
		// TODO Auto-generated method stub
		return OrderFood.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

	@Override
	protected SessionContext getUt() {
		// TODO Auto-generated method stub
		return ct;
	}

	public List<OrderFood> findByIdGreater(int dayOfMonth, int month, int year) {
		// primary
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<OrderFood> cq = cb.createQuery(OrderFood.class);
		Root<OrderFood> root = cq.from(OrderFood.class);
		List<Predicate> queries = new ArrayList<>();
		if (dayOfMonth != 0) {
			Predicate resultQuery = cb.greaterThan(root.get("dayOfmonth"), dayOfMonth);
			queries.add(resultQuery);
		}
		if (month != 0) {
			Predicate resultQuery = cb.greaterThan(root.get("month"), month);
			queries.add(resultQuery);
		}
		if (year != 0) {
			Predicate resultQuery = cb.greaterThan(root.get("year"), year);
			queries.add(resultQuery);
		}

		Predicate data[] = new Predicate[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			data[i] = queries.get(i);
		}
		Predicate finalPredicate = cb.and(data);
		cq.where(finalPredicate);
		TypedQuery<OrderFood> query = em.createQuery(cq);
		List<OrderFood> results = query.getResultList();
		if (!results.isEmpty()) {
			return results;
		} else {
			return new ArrayList<OrderFood>();
		}
	}

	// find tu ngay den ngay
	public List<OrderFood> findByDayToDay(Date firstDay, Date lastDay, String employeeCode) {
		// primary
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<OrderFood> cq = cb.createQuery(OrderFood.class);
		Root<OrderFood> root = cq.from(OrderFood.class);
		List<Predicate> queries = new ArrayList<>();
		if (firstDay != null) {
			Predicate resultQueryFirst = cb.greaterThanOrEqualTo(root.get("registration_date"), firstDay);
			queries.add(resultQueryFirst);
		}
		if (lastDay != null) {
			Predicate resultQueryLast = cb.lessThanOrEqualTo(root.get("registration_date"), lastDay);
			queries.add(resultQueryLast);
		}
		if (employeeCode != null) {
			Predicate resultQueryEmployeeCode = cb.equal(root.get("employeeCode"), employeeCode);
			queries.add(resultQueryEmployeeCode);
		}

		Predicate data[] = new Predicate[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			data[i] = queries.get(i);
		}
		Predicate finalPredicate = cb.and(data);
//		List<Order> orderList = new ArrayList<>();
//		orderList.add(cb.desc(root.get("registration_date")));
		cq.select(root).where(finalPredicate);
		TypedQuery<OrderFood> query = em.createQuery(cq);
		List<OrderFood> results = query.getResultList();
		if (!results.isEmpty()) {
			return results;
		} else {
			return new ArrayList<OrderFood>();
		}
	}
	
	// find tu ngay den ngay sort by day
		public List<OrderFood> findByDayToDaySortByDate(Date firstDay, Date lastDay) {
			// primary
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<OrderFood> cq = cb.createQuery(OrderFood.class);
			Root<OrderFood> root = cq.from(OrderFood.class);
			List<Predicate> queries = new ArrayList<>();
			if (firstDay != null) {
				Predicate resultQueryFirst = cb.greaterThanOrEqualTo(root.get("registration_date"), firstDay);
				queries.add(resultQueryFirst);
			}
			if (lastDay != null) {
				Predicate resultQueryLast = cb.lessThanOrEqualTo(root.get("registration_date"), lastDay);
				queries.add(resultQueryLast);
			}
			Predicate data[] = new Predicate[queries.size()];
			for (int i = 0; i < queries.size(); i++) {
				data[i] = queries.get(i);
			}
			Predicate finalPredicate = cb.and(data);
			cq.select(root).where(finalPredicate).orderBy(cb.asc(root.get("registration_date")));
			TypedQuery<OrderFood> query = em.createQuery(cq);
			List<OrderFood> results = query.getResultList();
			if (!results.isEmpty()) {
				return results;
			} else {
				return new ArrayList<OrderFood>();
			}
		}

	public OrderFood findByDateAndEmployeeCode(Date date, String employeeCode) {
		// primary
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<OrderFood> cq = cb.createQuery(OrderFood.class);
		Root<OrderFood> root = cq.from(OrderFood.class);
		List<Predicate> queries = new ArrayList<>();
		if (date != null) {
			Predicate dateQuery = cb.equal(root.get("registration_date"), date);
			queries.add(dateQuery);
		}
		if (employeeCode != null) {
			Predicate employeeQuery = cb.equal(root.get("employeeCode"), employeeCode);
			queries.add(employeeQuery);
		}

		Predicate data[] = new Predicate[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			data[i] = queries.get(i);
		}
		Predicate finalPredicate = cb.and(data);
		cq.where(finalPredicate);
		TypedQuery<OrderFood> query = em.createQuery(cq);
		List<OrderFood> results = query.getResultList();
		if (!results.isEmpty()) {
			return results.get(0);
		} else {
			return new OrderFood();
		}
	}

	public List<OrderFood> findRange(String codeEmp, int month, int year, List<String> codeEmps) {
		if (codeEmps != null && codeEmps.size() != 0) {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<OrderFood> cq = cb.createQuery(OrderFood.class);
			List<Predicate> predicates = new LinkedList<Predicate>();
			Root<OrderFood> root = cq.from(OrderFood.class);
			if (codeEmp != null) {
				predicates.add(cb.equal(root.get("employeeCode"), codeEmp));
			}

			predicates.add(cb.in(root.get("employeeCode")).value(codeEmps));

			if (month != 0) {
				predicates.add(cb.equal(root.get("month"), month));
			}
			if (year != 0) {
				predicates.add(cb.equal(root.get("year"), year));
			}
			cq.select(root).where(cb.and(predicates.toArray(new Predicate[0])));
			List<OrderFood> result = em.createQuery(cq).getResultList();
			return result;
		} else {
			return new ArrayList<OrderFood>();
		}
	}

	public List<OrderFood> findRange(String codeEmp, int month, int year) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<OrderFood> cq = cb.createQuery(OrderFood.class);
		List<Predicate> predicates = new LinkedList<Predicate>();
		Root<OrderFood> root = cq.from(OrderFood.class);
		if (codeEmp != null) {
			predicates.add(cb.equal(root.get("employeeCode"), codeEmp));
		}
		if (month != 0) {
			predicates.add(cb.equal(root.get("month"), month));
		}
		if (year != 0) {
			predicates.add(cb.equal(root.get("year"), year));
		}
		cq.select(root).where(cb.and(predicates.toArray(new Predicate[0])));
		List<OrderFood> result = em.createQuery(cq).getResultList();
		return result;
	}
}
