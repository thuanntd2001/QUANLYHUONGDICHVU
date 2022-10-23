package spring.bean;

import java.util.ArrayList;
import java.util.List;

import spring.dto.ChiTietHDDTO;
import spring.dto.HoaDonDTO;



public class BanHoaDonModel {
	public BanHoaDonModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BanHoaDonModel(long idBan) {
		super();
		this.idBan = idBan;
	}
	private int trangThaiCu=0;
	private long idBan=0;
	private List<ChiTietHDDTO> cthds= new ArrayList<ChiTietHDDTO>();
	private HoaDonDTO hoaDon;

	public List<ChiTietHDDTO> getCthds() {
		return cthds;
	}
	public void setCthds(List<ChiTietHDDTO> cthds) {
		this.cthds = cthds;
	}
	
	public long getIdBan() {
		return idBan;
	}
	public void setIdBan(long idBan) {
		this.idBan = idBan;
	}
	public HoaDonDTO getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDonDTO hoaDon) {
		this.hoaDon = hoaDon;
	}

	public void xuat() {
		for (ChiTietHDDTO i:cthds)
			System.out.println(i.getMaSP());
	}
	public int getTrangThaiCu() {
		return trangThaiCu;
	}
	public void setTrangThaiCu(int trangThaiCu) {
		this.trangThaiCu = trangThaiCu;
	}


}
