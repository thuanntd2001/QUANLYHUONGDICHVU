package springboot.dto;

public class ChiTietDatDTO {
	private Long id;
	private Long maDat;
	public ChiTietDatDTO(Long id, Long maDat) {
		super();
		this.id = id;
		this.maDat = maDat;
	}
	public ChiTietDatDTO() {}
	public Long getid() {
		return id;
	}
	public void setid(Long id) {
		this.id = id;
	}
	public Long getMaDat() {
		return maDat;
	}
	public void setMaDat(Long maDat) {
		this.maDat = maDat;
	}
	
	
}
