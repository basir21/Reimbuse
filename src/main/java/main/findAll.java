package main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.ReportDao;
import entity.Report;

public class findAll {

	public static void main(String[]args ){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/META-INF/spring/app-config.xml");

		ReportDao reportDao = ctx.getBean(ReportDao.class);
		List<Report> listReport = reportDao.findAll();
		for(Report r : listReport){
			System.out.println(r.getKaryawan().getNamaKaryawan());
		}
	}
}
