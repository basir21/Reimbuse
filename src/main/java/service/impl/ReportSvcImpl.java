package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Mst_HeaderDao;
import dao.ReportDao;
import entity.Mst_Header;
import entity.Report;
import service.ReportSvc;

@Service("reportSvc")
public class ReportSvcImpl implements ReportSvc {

	@Autowired
	ReportDao reportDao;
	
	@Autowired
	Mst_HeaderDao mst_headerDao;
	
	@Override
	public void save(Report report) {
		reportDao.save(report);
	}

	@Override
	public void update(Report report) {
		reportDao.update(report);
	}

	@Override
	public void delete(String report) {
		reportDao.delete(report);
	}

	@Override
	public List<Report> findAll() {
		return reportDao.findAll();
	}

	@Override
	public Report findOne(String report) {
		return reportDao.findOne(report);
	}

	@Override
	public List<Report> findKaryawan(String report, Mst_Header periode) {
		return reportDao.findKaryawan(report, periode);
	}

	@Override
	public Report findOneKaryawan(String karya) {
		return reportDao.findOneKaryawan(karya);
	}

	@Override
	public List<Report> findByPeriode(Mst_Header idHeader) {
		return reportDao.findByPeriode(idHeader);
	}
}