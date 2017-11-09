package dao;

import java.util.List;

import entity.Mst_Karyawan;


public interface Mst_KaryawanDao {
	public void save(Mst_Karyawan mstKaryawan);
	public void update(Mst_Karyawan mstKaryawan);
	public void delete(String mstKaryawan);
	public List<Mst_Karyawan> findAll();
	public Mst_Karyawan findOne(String mstKaryawan);
	
}
