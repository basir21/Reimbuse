package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.Mst_HeaderDao;
import entity.Mst_Header;
import entity.Mst_Karyawan;

@Repository
public class MstHeaderDaoImpl implements Mst_HeaderDao{

	@Autowired
	DataSource dataSource;
	@Override
	public void save(Mst_Header mstHeader) {
		String query="insert into PERIODE "
				+"(ID_HEADER, NAMA_BULAN) "
				+"values (?,?)";
		
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, mstHeader.getIdHeader());
			ps.setString(2, mstHeader.getNamaBulan());
			
			int out = ps.executeUpdate();
			if(out!=0){
				System.out.println("insert sukses");
			}
			else{
				System.out.println("insert gagal");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

	}

	@Override
	public void update(Mst_Header mstHeader) {
		String query="update PERIODE "
				+"set NAMA_BULAN=? "
				+"where ID_HEADER=?";
		
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			
			ps.setString(1, mstHeader.getNamaBulan());
			ps.setString(2, mstHeader.getIdHeader());
			
			int out = ps.executeUpdate();
			if(out!=0){
				System.out.println("update sukses");
			}
			else{
				System.out.println("update gagal");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(String mstHeader) {
		String query="delete from PERIODE "
				+"where ID_HEADER='"+mstHeader+"'";
		
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, mstHeader);
			
			int out = ps.executeUpdate();
			if(out!=0){
				System.out.println("delete sukses");
			}
			else{
				System.out.println("delete gagal");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Mst_Header> findAll() {
		String query="select ID_HEADER, NAMA_BULAN "
				+"FROM PERIODE";
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		List<Mst_Header> listDaftar= new ArrayList<>();
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				Mst_Header mstHeader = new Mst_Header();
				mstHeader.setIdHeader(rs.getString("ID_HEADER"));
				mstHeader.setNamaBulan(rs.getString("NAMA_BULAN"));
				listDaftar.add(mstHeader);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				ps.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return listDaftar;
	}

	@Override
	public Mst_Header findOne(String mstHeader) {
		String query="select * FROM PERIODE "
				+"WHERE ID_HEADER='"+mstHeader+"'";
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		Mst_Header mstHeaders = new Mst_Header();
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				mstHeaders.setIdHeader(rs.getString("ID_HEADER"));
				mstHeaders.setNamaBulan(rs.getString("NAMA_BULAN"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				ps.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return mstHeaders;
	}
	
}
