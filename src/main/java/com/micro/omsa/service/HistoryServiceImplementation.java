package com.micro.omsa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.omsa.model.History;
import com.micro.omsa.repo.HistoryRepo;

@Service
public class HistoryServiceImplementation implements HistoryService
{
	HistoryRepo repo;

	public HistoryServiceImplementation(HistoryRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public void addHistory(History history) 
	{
		repo.saveHistory(history);
	}

	@Override
	public List<History> getallHistorys() 
	{
		return repo.findAllHistorys();
	}

	@Override
	public void updateHistory(History history) 
	{
		repo.updateHistory(history);
	}

	@Override
	public void deleteHistory(int historyId) 
	{
		repo.deleteHistoryById(historyId);
	}
}
