package spring.dto;

import java.util.Date;

public class HoaDonDTO {
	private Long id;
	private Date ngayThucHien;
	private Long nvThucHien;
	private Long ban;





	public HoaDonDTO() {}



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



	public Date getNgayThucHien() {
		return ngayThucHien;
	}



	public void setNgayThucHien(Date ngayThucHien) {
		this.ngayThucHien = ngayThucHien;
	}

	
	
}
