package springboot.dto;

public class ChucVuDTO {
	private int id;
	private String tenChucVu;
	public ChucVuDTO(int id, String tenChucVu) {
		super();
		this.id = id;
		this.tenChucVu = tenChucVu;
	}
	public ChucVuDTO() {}
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public String getTenChucVu() {
		return tenChucVu;
	}
	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}
	
	
}
