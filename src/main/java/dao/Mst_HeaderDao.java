package dao;

import java.util.List;

import entity.Mst_Header;

public interface Mst_HeaderDao {
	public void save(Mst_Header mstHeader);
	public void update(Mst_Header mstHeader);
	public void delete(String mstHeader);
	public List<Mst_Header> findAll();
	public Mst_Header findPeriode(int bulan, int tahun);
	
}
