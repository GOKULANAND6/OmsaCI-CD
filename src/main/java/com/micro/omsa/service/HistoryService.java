package com.micro.omsa.service;

import java.util.List;

import com.micro.omsa.model.History;

public interface HistoryService 
{
	public void addHistory(History history);
	 
	public List<History> getallHistorys();

	public void updateHistory(History history);

	public void deleteHistory(int historyId);
}
