package entity;

public class TipeKlaim {
	String kodeKlaim;
	double transport;
	double parkir;
	double kesehatan;
	double bpjs;
	double rewardMonthly;
	double rewardTriwulan;
	double taxi;
	double lembur;
	double entertainInternal;
	double entertainExternal;
	double other;
	
	public double getTaxi() {
		return taxi;
	}
	public void setTaxi(double taxi) {
		this.taxi = taxi;
	}

	public double getRewardMonthly() {
		return rewardMonthly;
	}
	public void setRewardMonthly(double rewardMonthly) {
		this.rewardMonthly = rewardMonthly;
	}
	
	public String getKodeKlaim() {
		return kodeKlaim;
	}
	public void setKodeKlaim(String kodeKlaim) {
		this.kodeKlaim = kodeKlaim;
	}
	public double getOther() {
		return other;
	}
	public void setOther(double other) {
		this.other = other;
	}
	public double getTransport() {
		return transport;
	}
	public double getParkir() {
		return parkir;
	}
	public double getKesehatan() {
		return kesehatan;
	}
	public double getBpjs() {
		return bpjs;
	}
	public double getRewardTriwulan() {
		return rewardTriwulan;
	}
	
	public double getLembur() {
		return lembur;
	}
	public void setLembur(double lembur) {
		this.lembur = lembur;
	}
	public double getEntertainInternal() {
		return entertainInternal;
	}
	public void setEntertainInternal(double entertainInternal) {
		this.entertainInternal = entertainInternal;
	}
	public double getEntertainExternal() {
		return entertainExternal;
	}
	public void setEntertainExternal(double entertainExternal) {
		this.entertainExternal = entertainExternal;
	}
	public void setTransport(double transport) {
		this.transport = transport;
	}
	public void setParkir(double parkir) {
		this.parkir = parkir;
	}
	public void setKesehatan(double kesehatan) {
		this.kesehatan = kesehatan;
	}
	public void setBpjs(double bpjs) {
		this.bpjs = bpjs;
	}
	public void setRewardTriwulan(double rewardTriwulan) {
		this.rewardTriwulan = rewardTriwulan;
	}	
}
