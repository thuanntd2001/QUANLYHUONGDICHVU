package springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.entity.HoaDonEntity;





public interface HoaDonRepository extends JpaRepository<HoaDonEntity, Long>{
	List<HoaDonEntity> findByOrderByIdDesc();
}
