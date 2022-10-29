package spring.bean;

import java.util.ArrayList;
import java.util.List;

import spring.dto.BanDTO;
import spring.dto.ChiTietHDDTO;
import spring.dto.HoaDonDTO;
import spring.dto.ThucDonDTO;

public class BanHoaDonModel {
	public BanHoaDonModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BanHoaDonModel(long idBan) {
		super();
		this.idBan = idBan;
	}

	private int trangThaiCu = 0;
	private long idBan = 0;
	private List<ChiTietHDDTO> cthds = new ArrayList<ChiTietHDDTO>();
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
		for (ChiTietHDDTO i : cthds)
			System.out.println(i.getMaSP());
	}

	public int getTrangThaiCu() {
		return trangThaiCu;
	}

	public void setTrangThaiCu(int trangThaiCu) {
		this.trangThaiCu = trangThaiCu;
	}
////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////
	///////////////////////////////////////

	public static long findBan(long id, List<BanDTO> list) {
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).getId() == id)
				return i;
		return -1;
	}

	public static long findBanHD(long id, List<BanHoaDonModel> list) {
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).getIdBan() == id)
				return i;
		return -1;
	}

	public static long findCTHD_ThucDon(String id, List<ChiTietHDDTO> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getMaSP());
			if (list.get(i).getMaSP().equals(id))
				return i;
		}

		return -1;
	}

	public static long findTD(String id, List<ThucDonDTO> list) {
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).getid().equals(id))
				return i;
		return -1;
	}

	public static int tinhTong(List<ChiTietHDDTO> list) {
		int tong = 0;
		for (int i = 0; i < list.size(); i++)
			tong += list.get(i).getTongTien();

		return tong;
	}

	public static ThucDonDTO findTDDTO(String maSP, List<ThucDonDTO> thucDons) {
		for (ThucDonDTO item : thucDons) {
			if (item.getid().equals(maSP))
				return item;
		}
		return null;

	}
}
