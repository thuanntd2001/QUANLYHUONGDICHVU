package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.entity.NhanVienEntity;





public interface NhanVienRepository extends JpaRepository<NhanVienEntity, Long>{

}
