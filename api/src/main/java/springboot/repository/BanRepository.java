package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.entity.BanEntity;





public interface BanRepository extends JpaRepository<BanEntity, Long>{

}
