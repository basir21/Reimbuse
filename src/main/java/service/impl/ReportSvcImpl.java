package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ReportDao;
import entity.Report;
import service.ReportSvc;

@Service("reportSvc")
public class ReportSvcImpl implements ReportSvc {

	@Autowired
	ReportDao reportDao;
	
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
	public List<Report> findKaryawan(String report) {
		return reportDao.findKaryawan(report);
	}
}