package springboot.dto;

public class BanDTO {
	private int soGhe;
	private Long id;
	private Long loai;
	private int tinhTrang;

	public BanDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BanDTO(int soGhe, Long id, Long loai, int tinhTrang) {
		super();
		this.soGhe = soGhe;
		this.id = id;
		this.loai = loai;
		this.tinhTrang = tinhTrang;
	}
	public Integer getSoGhe() {
		return soGhe;
	}
	public void setSoGhe(int soGhe) {
		this.soGhe = soGhe;
	}
	public Long getiD() {
		return id;
	}
	public void setiD(Long iD) {
		this.id = iD;
	}
	public Long getLoai() {
		return loai;
	}
	public void setLoai(Long loaiD) {
		this.loai = loaiD;
	}
	public int getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	
	
}
