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
import dao.ReportDao;
import dao.TipeKlaimDao;
import entity.Mst_Karyawan;
import entity.Project;
import entity.Report;
import entity.TipeKlaim;

@Repository
public class ReportDaoImpl implements ReportDao{

	@Autowired
	DataSource dataSource;

	@Autowired
	Mst_KaryawanDao mstKaryawanDao;
	
	@Autowired
	TipeKlaimDao tipeKlaimDao;
	
	@Override
	public void save(Report report) {
		String query="insert into REPORT "
				+"(NO, NAMA_KARYAWAN, PROJECT, KANTOR, CUTI, SAKIT, TERLAMBAT, KODE_KLAIM, JUMLAH, ID_HEADER) "
				+"values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, report.getNo());
			ps.setObject(2, report.getKaryawan());
			ps.setString(3, report.getNamaProject());
			ps.setString(4, report.getKantor());
			ps.setInt(6, report.getCuti());
			ps.setInt(7, report.getSakit());
			ps.setInt(8, report.getTerlambat());
			ps.setObject(9, report.getTipeKlaim());
			ps.setDouble(12, report.getJumlah());
			ps.setObject(13, report.getIdHeader());
			
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
	public void update(Report report) {
		String query="update from REPORT "
				+"set NAMA_KARYAWAN=?, PROJECT=?, KANTOR=?, CUTI=?, SAKIT=?, TERLAMBAT=?, REWARD=?, LEMBUR=?, KODE_KLAIM=?, JUMLAH=?, ID_HEADER=?) "
				+"where NO=?";
		
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setObject(1, report.getKaryawan());
			ps.setString(2, report.getNamaProject());
			ps.setString(3, report.getKantor());
			ps.setInt(5, report.getCuti());
			ps.setInt(6, report.getSakit());
			ps.setInt(7, report.getTerlambat());
			ps.setObject(8, report.getTipeKlaim());
			ps.setDouble(11, report.getJumlah());
			ps.setObject(12, report.getIdHeader());
			ps.setInt(13, report.getNo());
			
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
	public void delete(String report) {
		String query="delete from REPORT "
				+"where NO='"+report+"'";
		
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, report);
			
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
	public List<Report> findAll() {
		String query="select * "
				+"FROM LAPORAN";
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		List<Report> listDaftar= new ArrayList<>();
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				Report report = new Report();
				report.setNo(rs.getInt("NO"));
				String nik = rs.getString("NAMA_KARYAWAN");
				Mst_Karyawan karyawan = mstKaryawanDao.findOne(nik);
				report.setKaryawan(karyawan);
				report.setNamaProject(rs.getString("PROJECT"));
				report.setKantor(rs.getString("KANTOR"));
				report.setCuti(rs.getInt("CUTI"));
				report.setSakit(rs.getInt("SAKIT"));
				report.setTerlambat(rs.getInt("TERLAMBAT"));
//				String klaim = rs.getString("KODE_KLAIM");
//				TipeKlaim tipe = tipeKlaimDao.findOne(klaim);
//				report.setTipeKlaim(tipe);
				report.setJumlah(rs.getDouble("JUMLAH"));
				
				listDaftar.add(report);
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
	public Report findOne(String report) {
		String query="select * FROM LAPORAN where NO='"+report+"'";
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		Report reports = new Report();
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				reports.setNo(rs.getInt("NO"));
				String nik = rs.getString("NAMA_KARYAWAN");
				Mst_Karyawan karyawan = mstKaryawanDao.findOne(nik);
				reports.setKaryawan(karyawan);
				reports.setNamaProject(rs.getString("NAMA_PROJECT"));
				reports.setKantor(rs.getString("KANTOR"));
				reports.setCuti(rs.getInt("CUTI"));
				reports.setSakit(rs.getInt("SAKIT"));
				reports.setTerlambat(rs.getInt("TERLAMBAT"));
				String klaim = rs.getString("KODE_KLAIM");
				TipeKlaim tipe = tipeKlaimDao.findOne(klaim);
				reports.setTipeKlaim(tipe);
				reports.setJumlah(rs.getDouble("JUMLAH"));
				
				
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
		return reports;
	}

	@Override
	public List<Report> findKaryawan(String searchKey) {
		String query="select NO, NAMA_KARYAWAN "
				+"FROM LAPORAN where NAMA_KARYAWAN LIKE '%"+searchKey+"%'";
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		List<Report> listDaftar= new ArrayList<>();
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				Report report = new Report();
				report.setNo(rs.getInt("NO"));
				String nik = rs.getString("NAMA_KARYAWAN");				
				
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
	public Report findPeriode(String bulan) {
		String query="select * FROM LAPORAN where ID_HEADER='"+bulan+"'";
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		Report reports = new Report();
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				reports.setNo(rs.getInt("NO"));
				String nik = rs.getString("NAMA_KARYAWAN");
				Mst_Karyawan karyawan = mstKaryawanDao.findOne(nik);
				reports.setKaryawan(karyawan);
				reports.setNamaProject(rs.getString("NAMA_PROJECT"));
				reports.setKantor(rs.getString("KANTOR"));
				reports.setCuti(rs.getInt("CUTI"));
				reports.setSakit(rs.getInt("SAKIT"));
				reports.setTerlambat(rs.getInt("TERLAMBAT"));
				String klaim = rs.getString("KODE_KLAIM");
				TipeKlaim tipe = tipeKlaimDao.findOne(klaim);
				reports.setTipeKlaim(tipe);
				reports.setJumlah(rs.getDouble("JUMLAH"));
				
				
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
		return reports;
	}

	@Override
	public Report findOneKaryawan(String karya) {
String query="select * FROM LAPORAN where NAMA_KARYAWAN='"+karya+"'";
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		Report reports = new Report();
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				reports.setNo(rs.getInt("NO"));
				String nik = rs.getString("NAMA_KARYAWAN");
				Mst_Karyawan karyawan = mstKaryawanDao.findOne(nik);
				reports.setKaryawan(karyawan);
				String project = rs.getString("PROJECT");
				reports.setNamaProject(rs.getString("PROJECT"));
				reports.setKantor(rs.getString("KANTOR"));
				reports.setCuti(rs.getInt("CUTI"));
				reports.setSakit(rs.getInt("SAKIT"));
				reports.setTerlambat(rs.getInt("TERLAMBAT"));
				String klaim = rs.getString("KODE_KLAIM");
				TipeKlaim tipe = tipeKlaimDao.findOne(klaim);
				reports.setTipeKlaim(tipe);
				reports.setJumlah(rs.getDouble("JUMLAH"));
				
				
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
		return reports;
	}
}
