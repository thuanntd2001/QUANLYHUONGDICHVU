package springboot.dto;

public class BanDTO {
	private int soGhe;
	private Long id;
	private Long loai;
	public BanDTO(int soGhe, Long iD, Long loai) {
		
		this.soGhe = soGhe;
		this.id = iD;
		this.setLoai(loai);
	}
	public BanDTO() {
		// TODO Auto-generated constructor stub
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

	
	
}
