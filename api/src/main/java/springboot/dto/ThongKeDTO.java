package springboot.dto;

import java.util.List;

import springboot.entity.ChiPhiEntity;
import springboot.entity.HoaDonEntity;

public class ThongKeDTO {
	private int soHoaDon;
	private int doanhThu;
	private int chiPhi;
	private int loiNhuan;
	private List<HoaDonEntity> HoaDons;
	private List<ChiPhiEntity> chiPhis;
	private int tongHD;
	
	public int getSoHoaDon() {
		return soHoaDon;
	}
	public void setSoHoaDon(int soHoaDon) {
		this.soHoaDon = soHoaDon;
	}
	public int getDoanhThu() {
		return doanhThu;
	}
	public void setDoanhThu(int doanhThu) {
		this.doanhThu = doanhThu;
	}
	public int getChiPhi() {
		return chiPhi;
	}
	public void setChiPhi(int chiPhi) {
		this.chiPhi = chiPhi;
	}
	public int getLoiNhuan() {
		return loiNhuan;
	}
	public void setLoiNhuan(int loiNhuan) {
		this.loiNhuan = loiNhuan;
	}
	public List<HoaDonEntity> getHoaDons() {
		return HoaDons;
	}
	public void setHoaDons(List<HoaDonEntity> hoaDons) {
		HoaDons = hoaDons;
	}
	public List<ChiPhiEntity> getChiPhis() {
		return chiPhis;
	}
	public void setChiPhis(List<ChiPhiEntity> list) {
		this.chiPhis = list;
	}
	public int getTongHD() {
		return tongHD;
	}
	public void setTongHD(int tongHD) {
		this.tongHD = tongHD;
	}
	
}
