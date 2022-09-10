package springboot.entity;


import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="DATBAN")
public class DatBanEntity {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	
	@Column(name="HOTEN")
	@NotNull
	@NotBlank(message="Không để trống họ tên")
	private String hoTen;
	
	@Column(name="SDT")
	@Size(min = 10, max = 12, message="SDT không đúng")
	private String sdt;
	
	@Column(name="TIENCOC")
	private Integer tienCoc;
	
	@Column(name="NGAYDAT")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date ngayDat;
	@Column(name="TGDUKIEN")
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Timestamp tgDuKien;
	

	@ManyToOne
	@JoinColumn(name="BAN")
	private BanEntity ban;


	
	@ManyToOne
	@JoinColumn(name="NVTHUCHIEN")
	private NhanVienEntity dbnv;
	
	@Column(name="TRANGTHAI")
	private int trangThai;

	public BanEntity getBan() {
		return ban;
	}

	public void setBan(BanEntity ban) {
		this.ban = ban;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public Integer getTienCoc() {
		return tienCoc;
	}

	public void setTienCoc(Integer tienCoc) {
		this.tienCoc = tienCoc;
	}

	public Date getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}

	public Timestamp getTgDuKien() {
		return tgDuKien;
	}

	public void setTgDuKien(Timestamp tgDuKien) {
		this.tgDuKien = tgDuKien;
	}



	public NhanVienEntity getDbnv() {
		return dbnv;
	}

	public void setDbnv(NhanVienEntity dbnv) {
		this.dbnv = dbnv;
	}

	public DatBanEntity(Long id, @NotNull @NotBlank(message = "Không để trống họ tên") String hoTen,
			@Size(min = 10, max = 12, message = "SDT không đúng") String sdt, Integer tienCoc, Date ngayDat,
			Timestamp tgDuKien, BanEntity ban, NhanVienEntity dbnv, int trangThai) {
		super();
		this.id = id;
		this.hoTen = hoTen;
		this.sdt = sdt;
		this.tienCoc = tienCoc;
		this.ngayDat = ngayDat;
		this.tgDuKien = tgDuKien;
		this.ban = ban;
		this.dbnv = dbnv;
		this.trangThai = trangThai;
	}

	public DatBanEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	
}
