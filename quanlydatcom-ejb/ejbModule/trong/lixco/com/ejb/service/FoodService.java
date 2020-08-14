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

import trong.lixco.com.jpa.entity.Food;
import trong.lixco.com.jpa.entity.OrderFood;


@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class FoodService extends AbstractService<Food>{
	@Inject
	private EntityManager em;
	@Resource
	private SessionContext ct;
	
	@Override
	protected Class<Food> getEntityClass() {
		// TODO Auto-generated method stub
		return Food.class;
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
	
	public List<Food> findByDate(Date date, int shifts) {
		// primary
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Food> cq = cb.createQuery(Food.class);
		Root<Food> root = cq.from(Food.class);
		List<Predicate> queries = new ArrayList<>();
		if (date != null) {
			Predicate dateQuery = cb.equal(root.get("food_date"), date);
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
		TypedQuery<Food> query = em.createQuery(cq);
		List<Food> results = query.getResultList();
		if(results != null) {
			return results;
		}else {
			return new ArrayList<Food>();
		}
	}

}
