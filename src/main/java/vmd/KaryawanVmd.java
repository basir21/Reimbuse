package vmd;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.New;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.ComboitemRenderer;
import org.zkoss.zul.SimpleListModel;

import entity.Mst_Header;
import entity.Mst_Karyawan;
import entity.Report;
import entity.TipeKlaim;
import service.Mst_HeaderSvc;
import service.Mst_KaryawanSvc;
import service.ReportSvc;
import service.TipeKlaimSvc;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class KaryawanVmd {

	@WireVariable
	Mst_HeaderSvc mst_HeaderSvc;
	
	@WireVariable
	Mst_KaryawanSvc mst_KaryawanSvc;
	
	@WireVariable
	TipeKlaimSvc tipeKlaimSvc;
	
	@WireVariable
	ReportSvc reportSvc;
	
	Mst_Header mst_Header = new Mst_Header();
	Mst_Karyawan mstkaryawan = new Mst_Karyawan();
	TipeKlaim tipeKlaim= new TipeKlaim();
	Report report = new Report();
	List<Mst_Header> listHeader = new ArrayList<>();
	List<Mst_Karyawan> listkaryawan = new ArrayList<>();
	List<TipeKlaim> listKlaim = new ArrayList<>();
	List<Report> listReports = new ArrayList<>();
	double total;
	double penampung;
	String tampungNama;
	
	@Init
	public void load(){
		listHeader = mst_HeaderSvc.findAll();
		listkaryawan = mst_KaryawanSvc.findAll();
	}

	@Command("search")
	@NotifyChange("listReports")
	public void SearchNama(){
		
		listReports.clear();
		listReports = reportSvc.findKaryawan(tampungNama);
		
	}
	
	
	
	public String getTampungNama() {
		return tampungNama;
	}

	public void setTampungNama(String tampungNama) {
		this.tampungNama = tampungNama;
	}

	public Mst_Header getMst_Header() {
		return mst_Header;
	}
	public void setMst_Header(Mst_Header mst_Header) {
		this.mst_Header = mst_Header;
	}
	public Mst_Karyawan getMstkaryawan() {
		return mstkaryawan;
	}
	public void setMstkaryawan(Mst_Karyawan mstkaryawan) {
		this.mstkaryawan = mstkaryawan;
	}
	public TipeKlaim getTipeKlaim() {
		return tipeKlaim;
	}
	public void setTipeKlaim(TipeKlaim tipeKlaim) {
		this.tipeKlaim = tipeKlaim;
	}
	public Report getReport() {
		return report;
	}
	public void setReport(Report report) {
		this.report = report;
	}
	public List<Mst_Header> getListHeader() {
		return listHeader;
	}
	public void setListHeader(List<Mst_Header> listHeader) {
		this.listHeader = listHeader;
	}
	public List<Mst_Karyawan> getListkaryawan() {
		return listkaryawan;
	}
	public void setListkaryawan(List<Mst_Karyawan> listkaryawan) {
		this.listkaryawan = listkaryawan;
	}
	public List<TipeKlaim> getListKlaim() {
		return listKlaim;
	}
	public void setListKlaim(List<TipeKlaim> listKlaim) {
		this.listKlaim = listKlaim;
	}
	public List<Report> getListReports() {
		return listReports;
	}
	public void setListReports(List<Report> listReports) {
		this.listReports = listReports;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getPenampung() {
		return penampung;
	}
	public void setPenampung(double penampung) {
		this.penampung = penampung;
	}
	
	
}
