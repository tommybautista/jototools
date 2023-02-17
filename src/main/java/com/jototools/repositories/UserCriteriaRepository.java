package com.jototools.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.jototools.models.User;
import com.jototools.models.UserPage;
import com.jototools.models.UserSearchCriteria;

@Repository
public class UserCriteriaRepository {
	
	private final EntityManager entityManager;
	private final CriteriaBuilder criteriaBuilder;
	
	public UserCriteriaRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
		this.criteriaBuilder = entityManager.getCriteriaBuilder();
	}
	
	public Page<User> findAllWithFilters(UserPage userPage, 
										 UserSearchCriteria usc){
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		Root<User> userRoot = criteriaQuery.from(User.class);
		Predicate predicate = getPredicate(usc, userRoot);
		criteriaQuery.where(predicate);
		setOrder(userPage, criteriaQuery, userRoot);
		
		TypedQuery<User> typedQuery = entityManager.createQuery(criteriaQuery);
		typedQuery.setFirstResult(userPage.getPageNumber() * userPage.getPageSize());
		typedQuery.setMaxResults(userPage.getPageSize());
		
		Pageable pageable = getPageable(userPage);
				
		long usersCount = getUsersCount(predicate);
		
        return new PageImpl<User>(typedQuery.getResultList(), pageable, usersCount);
	}
	
//	public Page<User> findAllWithFilters(UserSearchCriteria usc){
//		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
//		Root<User> userRoot = criteriaQuery.from(User.class);
//		Predicate predicate = getPredicate(usc, userRoot);
//		criteriaQuery.where(predicate);
//		
//		TypedQuery<User> typedQuery = entityManager.createQuery(criteriaQuery);
//		
//		return new PageImpl<User>(typedQuery.getResultList());
//	}
	
	
	private Predicate getPredicate(UserSearchCriteria usc, 
								   Root<User> userRoot) {
		List<Predicate> predicates = new ArrayList<>();
		if(Objects.nonNull(usc.getName())) {
			predicates.add(
					criteriaBuilder.like(userRoot.get("name"), "%" + usc.getName() + "%")
			);
		}
		if(Objects.nonNull(usc.getEmail())) {
			predicates.add(
					criteriaBuilder.like(userRoot.get("email"), "%" + usc.getEmail() + "%")
			);
		}
		return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
	}
	
	private void setOrder(UserPage userPage, 
						  CriteriaQuery<User> criteriaQuery, 
						  Root<User> userRoot) {
		if(userPage.getSortDirection().equals(Sort.Direction.ASC)) {
			criteriaQuery.orderBy(criteriaBuilder.asc(userRoot.get(userPage.getSortBy())));
		} else {
			criteriaQuery.orderBy(criteriaBuilder.desc(userRoot.get(userPage.getSortBy())));
		}
		
	}
	
	private Pageable getPageable(UserPage userPage) {
        Sort sort = Sort.by(userPage.getSortDirection(), userPage.getSortBy());
        return PageRequest.of(userPage.getPageNumber(),userPage.getPageSize(), sort);
    }
	
	
	private long getUsersCount(Predicate predicate) {
		CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
		Root<User> countRoot = countQuery.from(User.class);
		countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
		return entityManager.createQuery(countQuery).getSingleResult();
	}

	

}
