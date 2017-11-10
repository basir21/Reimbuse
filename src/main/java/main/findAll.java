package main;

import java.sql.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.Mst_HeaderDao;
import dao.Mst_KaryawanDao;
import dao.ReportDao;
import entity.Mst_Header;
import entity.Mst_Karyawan;
import entity.Report;

public class findAll {

	public static void main(String[]args ){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/META-INF/spring/app-config.xml");

		Mst_KaryawanDao mst_KaryawanDao = ctx.getBean(Mst_KaryawanDao.class);
		
//		Mst_Karyawan mst_Karyawan = mst_KaryawanDao.findOne("Bharat Ongso");
//		System.out.println(mst_Karyawan.getNamaKaryawan());
//		
		//List<Mst_Karyawan> listKaryawan = mst_KaryawanDao.findAll();
		//for(Mst_Karyawan k : listKaryawan){
		//	System.out.println(k.getNamaKaryawan());
		//}
				
		
		
		
//		ReportDao reportDao = ctx.getBean(ReportDao.class);
//		List<Report> listReport = reportDao.findAll();
//		for(Report r : listReport){
//			System.out.println(r.getNamaProject());
//			Mst_Karyawan kar = mst_KaryawanDao.findOne(r.getKaryawan().getNamaKaryawan());
//			System.out.println(kar.getNik()+" "+kar.getNamaKaryawan());
//		}
		
//		Mst_Karyawan input = new Mst_Karyawan();
//		input.setNik(1010000);
//		input.setNamaKaryawan("Mas Aris");
//		input.setJenisKelamin("L");
//		input.setNoAbsen("1000");
//		input.setIcn("IGT");
//		input.setNoRek("");
//		input.setTanggalMasuk(new Date(0));
//		mst_KaryawanDao.save(input);
//		
		
		Mst_HeaderDao mst_HeaderDao = ctx.getBean(Mst_HeaderDao.class);
//		Mst_Header input = new Mst_Header();
//		input.setIdHeader("H001");
//		input.setNamaBulan("September");
//		mst_HeaderDao.save(input);
		
//		Mst_Karyawan kar = mst_KaryawanDao.findOne("Mas Aris");
//		kar.setNoRek("100-423-1232");
//		mst_KaryawanDao.update(kar);
//		
//		Mst_Header head = mst_HeaderDao.findOne("H001");
//		//head.setIdHeader("H002");
//		head.setNamaBulan("OKTOBER");
//		mst_HeaderDao.update(head);
		
//		List<Mst_Header> mst_Headers = mst_HeaderDao.findAll();
//		for(Mst_Header h : mst_Headers){
//			System.out.println(h.getIdHeader()+" "+h.getNamaBulan());
//		}
		
		
		
	}
}
