package springboot.dto;

import java.sql.Timestamp;

public class HoaDonDTO {
	private Long id;
	private Timestamp ngayThucHien;
	private Long nvThuchien;

	public HoaDonDTO(Long id, Timestamp ngayThucHien, Long nvThuchien) {
		super();
		this.setId(id);
		this.ngayThucHien = ngayThucHien;
		this.nvThuchien = nvThuchien;
	}
	public HoaDonDTO() {}

	public Timestamp getNgayThucHien() {
		return ngayThucHien;
	}
	public void setNgayThucHien(Timestamp ngayThucHien) {
		this.ngayThucHien = ngayThucHien;
	}
	public Long getNvThuchien() {
		return nvThuchien;
	}
	public void setNvThuchien(Long nvThuchien) {
		this.nvThuchien = nvThuchien;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
	
}
