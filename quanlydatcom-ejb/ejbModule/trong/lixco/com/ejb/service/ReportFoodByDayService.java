package trong.lixco.com.ejb.service;

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

import trong.lixco.com.jpa.entity.ReportFoodByDay;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ReportFoodByDayService extends AbstractService<ReportFoodByDay> {
	@Inject
	private EntityManager em;
	@Resource
	private SessionContext ct;

	@Override
	protected Class<ReportFoodByDay> getEntityClass() {
		return ReportFoodByDay.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@Override
	protected SessionContext getUt() {
		return ct;
	}

	public List<ReportFoodByDay> findByDate(java.util.Date dateSearch, long shiftsId) {
		// primary
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ReportFoodByDay> cq = cb.createQuery(ReportFoodByDay.class);
		Root<ReportFoodByDay> root = cq.from(ReportFoodByDay.class);
		List<Predicate> queries = new ArrayList<>();
		if (dateSearch != null) {
			Predicate dateQuery = cb.equal(root.get("report_date"), dateSearch);
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
		TypedQuery<ReportFoodByDay> query = em.createQuery(cq);
		List<ReportFoodByDay> results = query.getResultList();
		if (!results.isEmpty()) {
			return results;
		} else {
			return new ArrayList<ReportFoodByDay>();
		}
	}

	// find tu ngay den ngay
	public List<ReportFoodByDay> findByDayToDaySortByDateAndShifts(java.util.Date firstDay, java.util.Date lastDay) {
		// primary
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ReportFoodByDay> cq = cb.createQuery(ReportFoodByDay.class);
		Root<ReportFoodByDay> root = cq.from(ReportFoodByDay.class);
		List<Predicate> queries = new ArrayList<>();
		if (firstDay != null) {
			Predicate resultQueryFirst = cb.greaterThanOrEqualTo(root.get("report_date"), firstDay);
			queries.add(resultQueryFirst);
		}
		if (lastDay != null) {
			Predicate resultQueryLast = cb.lessThanOrEqualTo(root.get("report_date"), lastDay);
			queries.add(resultQueryLast);
		}
		Predicate data[] = new Predicate[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			data[i] = queries.get(i);
		}
		Predicate finalPredicate = cb.and(data);
		cq.select(root).where(finalPredicate).orderBy(cb.asc(root.get("report_date")),
				cb.asc(root.get("shifts").get("id")));
		TypedQuery<ReportFoodByDay> query = em.createQuery(cq);
		List<ReportFoodByDay> results = query.getResultList();
		if (!results.isEmpty()) {
			return results;
		} else {
			return new ArrayList<ReportFoodByDay>();
		}
	}

}
