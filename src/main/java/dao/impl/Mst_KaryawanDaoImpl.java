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

import dao.Mst_KaryawanDao;
import entity.Mst_Karyawan;

@Repository
public class Mst_KaryawanDaoImpl implements Mst_KaryawanDao{

	@Autowired
	DataSource dataSource;
	
	@Override
	public void save(Mst_Karyawan mstKaryawan) {
		String query="insert into MST_KARYAWAN "
				+"(NIK, NAMA, JENIS_KELAMIN, ICN, TANGGAL_MASUK, NO_ABSEN, NO_REK) "
				+"values (?,?,?,?,?,?,?)";
		
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, mstKaryawan.getNik());
			ps.setString(2, mstKaryawan.getNamaKaryawan());
			ps.setString(3, mstKaryawan.getJenisKelamin());
			ps.setString(4, mstKaryawan.getIcn());
			ps.setDate(5, mstKaryawan.getTanggalMasuk());
			ps.setString(6, mstKaryawan.getNoAbsen());
			ps.setString(7, mstKaryawan.getNoRek());
			
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
	public void update(Mst_Karyawan mstKaryawan) {
		String query="update MST_KARYAWAN "
				+"set NIK=?, JENIS_KELAMIN=?, ICN=?, TANGGAL_MASUK=?, NO_ABSEN=?, NO_REK=? "
				+"where NAMA=?";
		
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			
			ps.setInt(1, mstKaryawan.getNik());
			ps.setString(2, mstKaryawan.getJenisKelamin());
			ps.setString(3, mstKaryawan.getIcn());
			ps.setDate(4, mstKaryawan.getTanggalMasuk());
			ps.setString(5, mstKaryawan.getNoAbsen());
			ps.setString(6, mstKaryawan.getNoRek());
			ps.setString(7, mstKaryawan.getNamaKaryawan());
			
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
	public void delete(String mstKaryawan) {
		String query="delete from MST_KARYAWAN "
				+"where NIK='"+mstKaryawan+"'";
		
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, mstKaryawan);
			
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
	public List<Mst_Karyawan> findAll() {
		String query="select NIK, NAMA, JENIS_KELAMIN, ICN, TANGGAL_MASUK, NO_ABSEN, NO_REK "
				+"FROM MST_KARYAWAN";
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		List<Mst_Karyawan> listDaftar= new ArrayList<>();
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				Mst_Karyawan mstKaryawan = new Mst_Karyawan();
				mstKaryawan.setNik(rs.getInt("NIK"));
				mstKaryawan.setNamaKaryawan(rs.getString("NAMA"));
				mstKaryawan.setJenisKelamin(rs.getString("JENIS_KELAMIN"));
				mstKaryawan.setIcn(rs.getString("ICN"));
				mstKaryawan.setTanggalMasuk(rs.getDate("TANGGAL_MASUK"));
				mstKaryawan.setNoAbsen(rs.getString("NO_ABSEN"));
				mstKaryawan.setNoRek(rs.getString("NO_REK"));
				listDaftar.add(mstKaryawan);
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
	public Mst_Karyawan findOne(String mstKaryawan) {
		String query="select * FROM MST_KARYAWAN WHERE NAMA='"+mstKaryawan+"'";
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		Mst_Karyawan mstKaryawans = new Mst_Karyawan();

		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				mstKaryawans.setNik(rs.getInt("NIK"));
				mstKaryawans.setNamaKaryawan(rs.getString("NAMA"));
				mstKaryawans.setJenisKelamin(rs.getString("JENIS_KELAMIN"));
				mstKaryawans.setIcn(rs.getString("ICN"));
				mstKaryawans.setTanggalMasuk(rs.getDate("TANGGAL_MASUK"));
				mstKaryawans.setNoAbsen(rs.getString("NO_ABSEN"));
				mstKaryawans.setNoRek(rs.getString("NO_REK"));
				
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
		return mstKaryawans;
	}
}
