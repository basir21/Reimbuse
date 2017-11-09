package entity;

import java.sql.Date;

public class Mst_Karyawan {

	int nik;
	String namaKaryawan;
	String jenisKelamin;
	String icn;
	Date tanggalMasuk;
	String noAbsen;
	String noRek;
	
	public int getNik() {
		return nik;
	}
	public void setNik(int nik) {
		this.nik = nik;
	}
	public String getNamaKaryawan() {
		return namaKaryawan;
	}
	public void setNamaKaryawan(String namaKaryawan) {
		this.namaKaryawan = namaKaryawan;
	}
	public String getJenisKelamin() {
		return jenisKelamin;
	}
	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}
	public String getIcn() {
		return icn;
	}
	public void setIcn(String icn) {
		this.icn = icn;
	}
	public Date getTanggalMasuk() {
		return tanggalMasuk;
	}
	public void setTanggalMasuk(Date tanggalMasuk) {
		this.tanggalMasuk = tanggalMasuk;
	}
	public String getNoAbsen() {
		return noAbsen;
	}
	public void setNoAbsen(String noAbsen) {
		this.noAbsen = noAbsen;
	}
	public String getNoRek() {
		return noRek;
	}
	public void setNoRek(String noRek) {
		this.noRek = noRek;
	}
}
