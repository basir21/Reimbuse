package service;

import java.util.List;

import entity.Mst_Header;
import entity.Report;

public interface ReportSvc {
	public void save(Report report);
	public void update(Report report);
	public void delete(String report);
	public List<Report> findAll();
	public Report findOne(String report);
	public List<Report> findKaryawan(String report, Mst_Header periode);
	public Report findOneKaryawan(String karya);
	public List<Report> findByPeriode(Mst_Header idHeader);

}
