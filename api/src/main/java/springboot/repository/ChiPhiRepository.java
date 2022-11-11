package springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import springboot.entity.ChiPhiEntity;





public interface ChiPhiRepository extends JpaRepository<ChiPhiEntity, Long>{
	@Query(value = "SELECT sum(soLuong*giaMoiDV) FROM ChiPhiEntity WHERE "
			+ "YEAR(ngayNhap) = ?1", nativeQuery = true)
	int tongChiPhiNam(Integer nam);
	@Query(value = "SELECT sum(soLuong*giaMoiDV) FROM ChiPhiEntity WHERE "
			+ "MONTH(ngayNhap) = ?1 AND YEAR(ngayNhap) = ?2", nativeQuery = true)
	
	int tongChiPhiThang(Integer thang, Integer nam);
	
	@Query(value = "SELECT sum(soLuong*giaMoiDV) FROM ChiPhiEntity WHERE "
			+ "DAY(ngayNhap) = ?1 AND MONTH(ngayNhap) = ?2 AND YEAR(ngayNhap) = ?3", nativeQuery = true)
	int tongChiPhiNgay(Integer ngay, Integer thang, Integer nam);
	
	
	
	@Query(value = "SELECT * FROM ChiPhiEntity WHERE "
			+ "YEAR(ngayNhap) = ?1"
			+ "ORDER BY id DESC, ngayNhap DESC", nativeQuery = true)
	List<ChiPhiEntity> getChiPhiNam(Integer nam);
	@Query(value = "SELECT * FROM ChiPhiEntity WHERE "
			+ "MONTH(ngayNhap) = ?1 AND YEAR(ngayNhap) = ?2"
			+ "ORDER BY id DESC, ngayNhap DESC", nativeQuery = true)
	List<ChiPhiEntity> getChiPhiThang(Integer thang, Integer nam);
	@Query(value = "SELECT * ChiPhiEntity WHERE "
			+ "DAY(ngayNhap) = ?1 AND MONTH(ngayNhap) = ?2 AND YEAR(ngayNhap) = ?3"
			+ "ORDER BY id DESC, ngayNhap DESC", nativeQuery = true)
	List<ChiPhiEntity> getChiPhiNgay(Integer ngay, Integer thang, Integer nam);
	
}
