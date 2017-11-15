package entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Mst_Header {
	String idHeader;
	Date namaBulan;
	List<Report> listReport = new ArrayList<>();
	
	public List<Report> getListReport() {
		return listReport;
	}
	public void setListReport(List<Report> listReport) {
		this.listReport = listReport;
	}
	public String getIdHeader() {
		return idHeader;
	}
	public void setIdHeader(String idHeader) {
		this.idHeader = idHeader;
	}
	public Date getNamaBulan() {
		return namaBulan;
	}
	public void setNamaBulan(Date namaBulan) {
		this.namaBulan = namaBulan;
	}
	
}
