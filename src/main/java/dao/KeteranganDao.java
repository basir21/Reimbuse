package dao;

import java.util.List;

import entity.Keterangan;

public interface KeteranganDao {
	public void save(Keterangan keterangan);
	public void update(Keterangan keterangan);
	public void delete(String keterangan);
	public List<Keterangan> findAll();
	public Keterangan findOne(String keterangan);
}
