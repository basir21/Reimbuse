package entity;

public class Report {

	int no;
	Mst_Karyawan karyawan;
	String namaProject;
	String kantor;
	int cuti;
	int sakit;
	int terlambat;
	TipeKlaim tipeKlaim;
	double jumlah;
	Mst_Header idHeader;
	
	public Mst_Header getIdHeader() {
		return idHeader;
	}
	public void setIdHeader(Mst_Header idHeader) {
		this.idHeader = idHeader;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Mst_Karyawan getKaryawan() {
		return karyawan;
	}
	public void setKaryawan(Mst_Karyawan karyawan) {
		this.karyawan = karyawan;
	}
	public String getNamaProject() {
		return namaProject;
	}
	public void setNamaProject(String namaProject) {
		this.namaProject = namaProject;
	}
	public String getKantor() {
		return kantor;
	}
	public void setKantor(String kantor) {
		this.kantor = kantor;
	}
	
	public int getCuti() {
		return cuti;
	}
	public void setCuti(int cuti) {
		this.cuti = cuti;
	}
	public int getSakit() {
		return sakit;
	}
	public void setSakit(int sakit) {
		this.sakit = sakit;
	}
	public int getTerlambat() {
		return terlambat;
	}
	public void setTerlambat(int terlambat) {
		this.terlambat = terlambat;
	}
	
	public TipeKlaim getTipeKlaim() {
		return tipeKlaim;
	}
	public void setTipeKlaim(TipeKlaim tipeKlaim) {
		this.tipeKlaim = tipeKlaim;
	}
	public double getJumlah() {
		return jumlah;
	}
	public void setJumlah(double jumlah) {
		this.jumlah = jumlah;
	}
	
}
