package springboot.dto;

import java.sql.Timestamp;

public class HoaDonDTO {
	private Long id;
	private Timestamp ngayThucHien;
	private Long nvThucHien;
	private Long ban;



	public HoaDonDTO(Long id, Timestamp ngayThucHien, Long nvThucHien, Long ban) {
		super();
		this.id = id;
		this.ngayThucHien = ngayThucHien;
		this.nvThucHien = nvThucHien;
		this.ban = ban;
	}

	public HoaDonDTO() {}

	public Timestamp getNgayThucHien() {
		return ngayThucHien;
	}
	public void setNgayThucHien(Timestamp ngayThucHien) {
		this.ngayThucHien = ngayThucHien;
	}
	public Long getNvThucHien() {
		return nvThucHien;
	}
	public void setNvThucHien(Long nvThuchien) {
		this.nvThucHien = nvThuchien;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getBan() {
		return ban;
	}
	public void setBan(Long ban) {
		this.ban = ban;
	}

	
	
}
