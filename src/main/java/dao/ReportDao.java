package dao;

import java.util.List;

import entity.Mst_Header;
import entity.Report;

public interface ReportDao {
	public void save(Report report);
	public void update(Report report);
	public void delete(String report);
	public List<Report> findAll();
	public Report findOne(String report);
	public List<Report> findKaryawan(String report, Mst_Header header);
	public List<Report> findByPeriode(Mst_Header idHeader);
	public Report findOneKaryawan(String karya);
}
