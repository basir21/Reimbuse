package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Mst_KaryawanDao;
import entity.Mst_Karyawan;
import service.Mst_KaryawanSvc;

@Service("mst_KaryawanSvc")
public class Mst_KaryawanSvcImpl implements Mst_KaryawanSvc {

	@Autowired
	Mst_KaryawanDao mst_KaryawanDao;
	
	@Override
	public void save(Mst_Karyawan mstKaryawan) {
		mst_KaryawanDao.save(mstKaryawan);
	}

	@Override
	public void update(Mst_Karyawan mstKaryawan) {
		mst_KaryawanDao.update(mstKaryawan);
	}

	@Override
	public void delete(String mstKaryawan) {
		mst_KaryawanDao.delete(mstKaryawan);
	}

	@Override
	public List<Mst_Karyawan> findAll() {
		return mst_KaryawanDao.findAll();
	}

	@Override
	public Mst_Karyawan findOne(String mstKaryawan) {
		return mst_KaryawanDao.findOne(mstKaryawan);
	}

}
