package dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.KeteranganDao;
import entity.Keterangan;

@Repository
public class KeteranganDaoImpl implements KeteranganDao{

	@Autowired
	DataSource dataSource;
	
	@Override
	public void save(Keterangan keterangan) {
		
	}

	@Override
	public void update(Keterangan keterangan) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String keterangan) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Keterangan> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Keterangan findOne(String keterangan) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
