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

import dao.TipeKlaimDao;
import entity.TipeKlaim;

@Repository
public class TipeKlaimDaoImpl implements TipeKlaimDao{

	@Autowired
	DataSource dataSource;
	
	@Override
	public void save(TipeKlaim tipeKlaim) {
		String query="insert into TIPE_KLAIM "
				+"(KODE_KLAIM, TRANSPORT, PARKIR, KESEHATAN, BPJS, REWARD_MONTHLY, REWARD_TRIWULAN, TAXI, LEMBUR,"
				+ ", ENTERTAIN_INTERNAL, ENTERTAIN_EKSTERNAL, OTHER) "
				+"values (?,?,?,?,?,?,?,?,?,?)";
		
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, tipeKlaim.getKodeKlaim());
			ps.setDouble(2, tipeKlaim.getTransport());
			ps.setDouble(3, tipeKlaim.getParkir());
			ps.setDouble(4, tipeKlaim.getKesehatan());
			ps.setDouble(5, tipeKlaim.getBpjs());
			ps.setDouble(6, tipeKlaim.getRewardMonthly());
			ps.setDouble(7, tipeKlaim.getTaxi());
			ps.setDouble(8, tipeKlaim.getLembur());
			ps.setDouble(9, tipeKlaim.getEntertainInternal());
			ps.setDouble(10, tipeKlaim.getEntertainExternal());
			ps.setDouble(11, tipeKlaim.getOther());
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
	public void update(TipeKlaim tipeKlaim) {
		String query="update from TIPE_KLAIM "
				+"set TRANSPORT=?, PARKIR=?, KESEHATAN=?, BPJS=?, REWARD_MONTHLY=?, REWARD_TRIWULAN=?, TAXI=?, LEMBUR=?,"
				+ ", ENTERTAIN_INTERNAL=?, ENTERTAIN_EKSTERNAL=?, OTHER=?) "
				+"where KODE_KLAIM=?";
		
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setDouble(1, tipeKlaim.getTransport());
			ps.setDouble(2, tipeKlaim.getParkir());
			ps.setDouble(3, tipeKlaim.getKesehatan());
			ps.setDouble(4, tipeKlaim.getBpjs());
			ps.setDouble(5, tipeKlaim.getRewardMonthly());
			ps.setDouble(6, tipeKlaim.getTaxi());
			ps.setDouble(7, tipeKlaim.getLembur());
			ps.setDouble(8, tipeKlaim.getEntertainInternal());
			ps.setDouble(9, tipeKlaim.getEntertainExternal());
			ps.setDouble(10, tipeKlaim.getOther());
			ps.setString(11, tipeKlaim.getKodeKlaim());
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
	public void delete(String tipeKlaim) {
		String query="delete from TIPE_KLAIM "
				+"where KODE_KLAIM='"+tipeKlaim+"'";
		
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, tipeKlaim);
			
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
	public List<TipeKlaim> findAll() {
		String query="select KODE_KLAIM, TRANSPORT, PARKIR, KESEHATAN, BPJS, REWARD_MONTHLY, REWARD_TRIWULAN, TAXI, LEMBUR,"
				+ ", ENTERTAIN_INTERNAL, ENTERTAIN_EKSTERNAL, OTHER "
				+"FROM KODE_KLAIM";
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		List<TipeKlaim> listDaftar= new ArrayList<>();
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				TipeKlaim tipeKlaim = new TipeKlaim();
				tipeKlaim.setKodeKlaim(rs.getString("KODE_KLAIM"));
				tipeKlaim.setTransport(rs.getDouble("TRANSPORT"));
				tipeKlaim.setParkir(rs.getDouble("PARKIR"));
				tipeKlaim.setKesehatan(rs.getDouble("KESEHATAN"));
				tipeKlaim.setBpjs(rs.getDouble("BPJS"));
				tipeKlaim.setRewardMonthly(rs.getDouble("REWARD_MONTHLY"));
				tipeKlaim.setRewardTriwulan(rs.getDouble("REWARD_TRIWULAN"));
				tipeKlaim.setTaxi(rs.getDouble("TAXI"));
				tipeKlaim.setLembur(rs.getDouble("LMEBUR"));
				tipeKlaim.setEntertainInternal(rs.getDouble("ENTERTAIN_INTERNAL"));
				tipeKlaim.setEntertainExternal(rs.getDouble("ENTERTAIN_EKSTERNAL"));
				tipeKlaim.setOther(rs.getDouble("OTHER"));
				listDaftar.add(tipeKlaim);
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
	public TipeKlaim findOne(String tipeKlaim) {
		String query="select * FROM TIPE_KLAIM "
				+"where KODE_KLAIM='"+tipeKlaim+"'";
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		TipeKlaim tipeKlaims = new TipeKlaim();
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				tipeKlaims.setKodeKlaim(rs.getString("KODE_KLAIM"));
				tipeKlaims.setTransport(rs.getDouble("TRANSPORT"));
				tipeKlaims.setParkir(rs.getDouble("PARKIR"));
				tipeKlaims.setKesehatan(rs.getDouble("KESEHATAN"));
				tipeKlaims.setBpjs(rs.getDouble("BPJS"));
				tipeKlaims.setRewardMonthly(rs.getDouble("REWARD_MONTHLY"));
				tipeKlaims.setRewardTriwulan(rs.getDouble("REWARD_TRIWULAN"));
				tipeKlaims.setTaxi(rs.getDouble("TAXI"));
				tipeKlaims.setLembur(rs.getDouble("LMEBUR"));
				tipeKlaims.setEntertainInternal(rs.getDouble("ENTERTAIN_INTERNAL"));
				tipeKlaims.setEntertainExternal(rs.getDouble("ENTERTAIN_EKSTERNAL"));
				tipeKlaims.setOther(rs.getDouble("OTHER"));
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
		}return tipeKlaims;
	}
}
