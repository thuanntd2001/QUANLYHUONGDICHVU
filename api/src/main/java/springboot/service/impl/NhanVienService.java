package springboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.dto.NhanVienDTO;
import springboot.entity.NhanVienEntity;
import springboot.repository.NhanVienRepository;
import springboot.service.INhanVienService;
@Service
public class NhanVienService implements INhanVienService{
	@Autowired
	NhanVienRepository repo;


	public List<NhanVienDTO> getNV() {
		 List<NhanVienEntity> listEn=repo.findAll();
		 List<NhanVienDTO> list= new ArrayList<>();
		 for (NhanVienEntity item:listEn)
		 {
			
			 item.setChiPhi(null);
			 item.setHoadon(null);
			 item.setUserTB(null);
		 }
		 System.out.print(list.size());
		return list;

	}
}
