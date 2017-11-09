package entity;

public class TipeKlaim {
	String transport;
	String parkir;
	String kesehatan;
	String bpjs;
	String rewardTriwulan;
	Keterangan keterangan;
	
	public Keterangan getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(Keterangan keterangan) {
		this.keterangan = keterangan;
	}
	public String getTransport() {
		return transport;
	}
	public void setTransport(String transport) {
		this.transport = transport;
	}
	public String getParkir() {
		return parkir;
	}
	public void setParkir(String parkir) {
		this.parkir = parkir;
	}
	public String getKesehatan() {
		return kesehatan;
	}
	public void setKesehatan(String kesehatan) {
		this.kesehatan = kesehatan;
	}
	public String getBpjs() {
		return bpjs;
	}
	public void setBpjs(String bpjs) {
		this.bpjs = bpjs;
	}
	public String getRewardTriwulan() {
		return rewardTriwulan;
	}
	public void setRewardTriwulan(String rewardTriwulan) {
		this.rewardTriwulan = rewardTriwulan;
	}
	
}
