package springboot.dto;

import java.sql.Timestamp;

public class HoaDonDTO {
	private Long id;
	private Timestamp ngayThucHien;
	private Long nVThuchien;
	public HoaDonDTO(Long id, Timestamp ngayThucHien, Long nVThuchien) {
		super();
		this.id = id;
		this.ngayThucHien = ngayThucHien;
		this.nVThuchien = nVThuchien;
	}
	public HoaDonDTO() {}
	public Long getid() {
		return id;
	}
	public void setid(Long id) {
		this.id = id;
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
