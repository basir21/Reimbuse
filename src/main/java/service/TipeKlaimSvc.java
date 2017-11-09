package service;

import java.util.List;

import entity.Report;
import entity.TipeKlaim;

public interface TipeKlaimSvc {
	public void save(TipeKlaim tipeKlaim);
	public void update(TipeKlaim tipeKlaim);
	public void delete(String tipeKlaim);
	public List<TipeKlaim> findAll();
	public TipeKlaim findOne(String tipeKlaim);
}
