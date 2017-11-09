package service;

import java.util.List;

import entity.Mst_Header;

public interface Mst_HeaderSvc {
	public void save(Mst_Header mstHeader);
	public void update(Mst_Header mstHeader);
	public void delete(String mstHeader);
	public List<Mst_Header> findAll();
	public Mst_Header findOne(String mstHeader);
}