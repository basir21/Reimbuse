package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Mst_HeaderDao;
import entity.Mst_Header;
import service.Mst_HeaderSvc;

@Service("mst_HeaderSvc")
public class Mst_HeaderSvcImpl implements Mst_HeaderSvc {

	@Autowired
	Mst_HeaderDao mst_HeaderDao;
	
	@Override
	public void save(Mst_Header mstHeader) {
		mst_HeaderDao.save(mstHeader);
	}

	@Override
	public void update(Mst_Header mstHeader) {
		mst_HeaderDao.update(mstHeader);
		
	}

	@Override
	public void delete(String mstHeader) {
		mst_HeaderDao.delete(mstHeader);
		
	}

	@Override
	public List<Mst_Header> findAll() {
		return mst_HeaderDao.findAll();
	}

	@Override
	public Mst_Header findOne(String mstHeader) {
		return mst_HeaderDao.findOne(mstHeader);
	}

}
