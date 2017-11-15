package vmd;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.enterprise.inject.New;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zkplus.acegi.ShowWindowEventListener;
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
	List<Report> report = new ArrayList<>();
	List<Mst_Header> listHeader = new ArrayList<>();
	List<Mst_Karyawan> listkaryawan = new ArrayList<>();
	List<TipeKlaim> listKlaim = new ArrayList<>();
	List<Report> listReports = new ArrayList<>();
	double total;
	double penampung;
	Mst_Karyawan tampungKaryawan = new Mst_Karyawan();
	Report reportByNama = new Report();
	Date selectedDate = new Date();
	int month;
	int years;
	
	@Init
	public void load(){
		listHeader = mst_HeaderSvc.findAll();
		listkaryawan = mst_KaryawanSvc.findAll();
		
		
	}

	@Command("getDetail")
	@NotifyChange({"reportByNama", "listReports"})
	public void getDetail(){
		try{
			report = reportSvc.findByPeriode(mst_Header);
			for(Report r : report){
				System.out.println(r.getKaryawan().getNamaKaryawan());
			}
		reportByNama = reportSvc.findOneKaryawan(tampungKaryawan.getNamaKaryawan());
		listReports = reportSvc.findKaryawan(tampungKaryawan.getNamaKaryawan(), mst_Header);
		System.out.println(mst_Header.getNamaBulan());
		System.out.println(month + " " + years);
		}catch(Exception e){
			e.printStackTrace();
		}
	}	

	@Command("simpan")
	public void simpan(){
		
		Clients.showNotification("Data berhasil di update",
				Clients.NOTIFICATION_TYPE_INFO, null, null, 1500);
	}
	
	@Command("getPeriode")
	public void getPeriode(){
		SimpleDateFormat sdfMonth = new SimpleDateFormat("MM YYYY");
		String d = sdfMonth.format(getSelectedDate());
		String tempMonth = d.substring(0, 2);
		String tempYears = d.substring(3, 7);
		
		month = Integer.parseInt(tempMonth);
		years = Integer.parseInt(tempYears);
		
		mst_Header = mst_HeaderSvc.findPeriode(month, years);
		
		System.out.println(mst_Header.getNamaBulan());
		System.out.println(month + " " + years);
	}
	
	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public Date getSelectedDate() {
		return selectedDate;
	}

	public void setSelectedDate(Date selectedDate) {
		this.selectedDate = selectedDate;
	}

	public Mst_Karyawan getTampungKaryawan() {
		return tampungKaryawan;
	}

	public void setTampungKaryawan(Mst_Karyawan tampungKaryawan) {
		this.tampungKaryawan = tampungKaryawan;
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

	public List<Report> getReport() {
		return report;
	}

	public void setReport(List<Report> report) {
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
	
	public Report getReportByNama() {
		return reportByNama;
	}

	public void setReportByNama(Report reportByNama) {
		this.reportByNama = reportByNama;
	}
}
