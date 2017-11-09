package service;

import java.util.List;

import entity.Report;

public interface ReportSvc {
	public void save(Report report);
	public void update(Report report);
	public void delete(String report);
	public List<Report> findAll();
	public Report findOne(String report);
}
