package springboot.dto;

import java.sql.Timestamp;

public class HoaDonDTO {
	private Long iD;
	private Timestamp ngayThucHien;
	private Long nVThuchien;
	public HoaDonDTO(Long iD, Timestamp ngayThucHien, Long nVThuchien) {
		super();
		this.iD = iD;
		this.ngayThucHien = ngayThucHien;
		this.nVThuchien = nVThuchien;
	}
	public HoaDonDTO() {}
	public Long getiD() {
		return iD;
	}
	public void setiD(Long iD) {
		this.iD = iD;
	}
	public Timestamp getNgayThucHien() {
		return ngayThucHien;
	}
	public void setNgayThucHien(Timestamp ngayThucHien) {
		this.ngayThucHien = ngayThucHien;
	}
	public Long getnVThuchien() {
		return nVThuchien;
	}
	public void setnVThuchien(Long nVThuchien) {
		this.nVThuchien = nVThuchien;
	}
	
	
}
