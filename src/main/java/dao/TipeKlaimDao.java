package dao;

import java.util.List;

import entity.Mst_Karyawan;
import entity.TipeKlaim;

public interface TipeKlaimDao {
	public void save(TipeKlaim tipeKlaim);
	public void update(TipeKlaim tipeKlaim);
	public void delete(String tipeKlaim);
	public List<TipeKlaim> findAll();
	public TipeKlaim findOne(String tipeKlaim);
}
