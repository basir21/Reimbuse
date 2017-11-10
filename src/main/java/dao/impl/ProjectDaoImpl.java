package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import dao.Mst_KaryawanDao;
import dao.ProjectDao;
import entity.Mst_Karyawan;
import entity.Project;
import entity.Report;
import entity.TipeKlaim;

public class ProjectDaoImpl implements ProjectDao{

	
	@Autowired
	DataSource dataSource;
	
	@Override
	public Project findOne(String namaKaryawan) {
		String query="select * FROM LAPORAN where NAMA_KARYAWAN='"+namaKaryawan+"'";
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		Project project = new Project();
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				project.setNamaProject(rs.getString("PROJECT"));
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

		return project;
	}

}
