package entity;

import java.util.ArrayList;
import java.util.List;

public class Mst_Header {
	String idHeader;
	String namaBulan;
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
	public String getNamaBulan() {
		return namaBulan;
	}
	public void setNamaBulan(String namaBulan) {
		this.namaBulan = namaBulan;
	}
	
}
