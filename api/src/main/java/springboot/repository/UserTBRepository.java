package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.entity.UserTBEntity;





public interface UserTBRepository extends JpaRepository<UserTBEntity, String>{

}
