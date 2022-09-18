package springboot.dto;

public class ThucDonDTO {
	private Long id1;
	private String id;
	private String ten;
	private String loai;
	private int gia;
	public ThucDonDTO(Long id1, String id, String ten, String loai, int gia) {
		super();
		this.id1 = id1;
		this.id = id;
		this.ten = ten;
		this.loai = loai;
		this.gia = gia;
	}
	public ThucDonDTO() {}
	public Long getid1() {
		return id1;
	}
	public void setid1(Long id1) {
		this.id1 = id1;
	}
	public String getid() {
		return id;
	}
	public void setid(String id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	
}
