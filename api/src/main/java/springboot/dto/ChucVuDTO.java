package springboot.dto;

public class ChucVuDTO {
	private int iD;
	private String tenChucVu;
	public ChucVuDTO(int iD, String tenChucVu) {
		super();
		this.iD = iD;
		this.tenChucVu = tenChucVu;
	}
	public ChucVuDTO() {}
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public String getTenChucVu() {
		return tenChucVu;
	}
	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}
	
	
}
