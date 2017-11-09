package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TipeKlaimDao;
import entity.Report;
import entity.TipeKlaim;
import service.TipeKlaimSvc;

@Service("tipeKlaimSvc")
public class TipeKlaimSvcImpl implements TipeKlaimSvc {

	@Autowired
	TipeKlaimDao tipeKlaimDao;

	@Override
	public void save(TipeKlaim tipeKlaim) {
		tipeKlaimDao.save(tipeKlaim);
	}

	@Override
	public void update(TipeKlaim tipeKlaim) {
		tipeKlaimDao.update(tipeKlaim);
	}

	@Override
	public void delete(String tipeKlaim) {
		tipeKlaimDao.delete(tipeKlaim);
	}

	@Override
	public List<TipeKlaim> findAll() {
		return tipeKlaimDao.findAll();
	}

	@Override
	public TipeKlaim findOne(String tipeKlaim) {
		return tipeKlaimDao.findOne(tipeKlaim);
	}
}
