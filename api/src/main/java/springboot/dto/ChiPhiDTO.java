package springboot.dto;

import java.sql.Timestamp;

public class ChiPhiDTO {
	private Long id;
	private String tenNL;
	private Timestamp ngayNhap;
	private int soLuong;
	private int giaMoidV;
	private String loai;
	private String dV;
	private String nhaCungCap;
	private String ghiChu;
	private Long nVTao;

	public ChiPhiDTO(Long id, String tenNL, Timestamp ngayNhap, int soLuong, int giaMoidV, String loai, String dV,
			String nhaCungCap, String ghiChu, Long nVTao) {
		super();
		this.id = id;
		this.tenNL = tenNL;
		this.ngayNhap = ngayNhap;
		this.soLuong = soLuong;
		this.giaMoidV = giaMoidV;
		this.loai = loai;
		this.dV = dV;
		this.nhaCungCap = nhaCungCap;
		this.ghiChu = ghiChu;
		this.nVTao = nVTao;
	}

	public ChiPhiDTO() {}

	public Long getid() {
		return id;
	}

	public void setid(Long id) {
		this.id = id;
	}

	public String getTenNL() {
		return tenNL;
	}

	public void setTenNL(String tenNL) {
		this.tenNL = tenNL;
	}

	public Timestamp getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Timestamp ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getGiaMoidV() {
		return giaMoidV;
	}

	public void setGiaMoidV(int giaMoidV) {
		this.giaMoidV = giaMoidV;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public String getdV() {
		return dV;
	}

	public void setdV(String dV) {
		this.dV = dV;
	}

	public String getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public Long getnVTao() {
		return nVTao;
	}

	public void setnVTao(Long nVTao) {
		this.nVTao = nVTao;
	}
	
}
