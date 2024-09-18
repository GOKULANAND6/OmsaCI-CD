package com.micro.omsa.repo;

import java.util.List;

import com.micro.omsa.model.History;

public interface HistoryRepo 
{
	public void saveHistory(History history);

	public List<History> findAllHistorys();

	public void updateHistory(History history);

	public void deleteHistoryById(int historyId);
}
