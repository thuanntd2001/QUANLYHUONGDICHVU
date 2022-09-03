package springboot.dto;

public class ChiTietDatDTO {
	private Long iD;
	private Long maDat;
	public ChiTietDatDTO(Long iD, Long maDat) {
		super();
		this.iD = iD;
		this.maDat = maDat;
	}
	public ChiTietDatDTO() {}
	public Long getiD() {
		return iD;
	}
	public void setiD(Long iD) {
		this.iD = iD;
	}
	public Long getMaDat() {
		return maDat;
	}
	public void setMaDat(Long maDat) {
		this.maDat = maDat;
	}
	
	
}
