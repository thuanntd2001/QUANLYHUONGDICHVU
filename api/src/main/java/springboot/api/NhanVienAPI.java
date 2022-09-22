package springboot.api;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springboot.dto.NhanVienDTO;
import springboot.dto.UserDTO;
import springboot.entity.BanEntity;
import springboot.entity.NhanVienEntity;
import springboot.repository.BanRepository;
import springboot.repository.NhanVienRepository;

@RestController
public class NhanVienAPI {
	@Autowired
	NhanVienRepository repo;

	@GetMapping("/nhanvien")
	public List<NhanVienEntity> getNV() {
		 List<NhanVienEntity> list=repo.findAll();
		 for (NhanVienEntity item:list)
		 {
			
			 item.setChiPhi(null);
			 item.setHoadon(null);
			 item.setUserTB(null);
		 }
		 System.out.print(list.size());
		return list;

	}

	@PostMapping(value="/nhanvien")
	public String createNV(@RequestBody NhanVienDTO model) {
//		if (repo.findById(model.getMaNV()) == null) {
//			NhanVienEntity esave = null;
//			UserModel user = (UserModel) session.getAttribute("USERMODEL");
		NhanVienEntity save= new NhanVienEntity();
		NhanVienEntity check = null;
			try {
				save.setCmnd(model.getCmnd());
				save.setDaNghi(model.getDaNghi());
				save.setDiaChi(model.getDiaChi());
				save.setGioiTinh(model.getGioiTinh());
				save.setHoTen(model.getHoTen());
				save.setNgaySinh(model.getNgaySinh());
				save.setLuong(model.getLuong());
				save.setNgayVaoLam(model.getNgayVaoLam());
				save.setSdt(model.getSdt());
			
				check = repo.save(save);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.print(model.getCmnd());
				System.out.print(model.getHoTen());
				return "01";
			}
			if (check == null) {
				
				return "02";
			}
			return "00";
		} 

		
	

	
	@PutMapping(value="/nhanvien")
	public UserDTO updateNV(@RequestBody UserDTO model) {

		return model;

	}
	
	@DeleteMapping(value="/nhanvien")
	public void deleteNV(@RequestBody Long[] ids) {

		

	}
}
