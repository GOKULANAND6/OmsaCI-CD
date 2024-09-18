package com.micro.omsa.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.micro.omsa.model.History;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HistoryRepoImplementation implements HistoryRepo
{
	EntityManager manager;

	public HistoryRepoImplementation(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public void saveHistory(History history) 
	{
		manager.persist(history); 
	}


	@Override
	public List<History> findAllHistorys() 
	{
		String str = "From History";
		Query query = manager.createQuery(str);
		return query.getResultList();
	}

	@Override
	public void updateHistory(History history) 
	{
	    manager.merge(history);
	}


	@Override
	public void deleteHistoryById(int historyId) 
	{
		History history = manager.find(History.class, historyId);
		manager.remove(history);
	}
}
