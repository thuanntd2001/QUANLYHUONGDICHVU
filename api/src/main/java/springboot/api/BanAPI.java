package springboot.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springboot.dto.BanDTO;
import springboot.dto.NhanVienDTO;
import springboot.entity.BanEntity;
import springboot.repository.BanRepository;
import springboot.repository.LoaiBanRepository;

@RestController
public class BanAPI {
	@Autowired
	BanRepository repo;
	@Autowired
	LoaiBanRepository loaibanrepo;

	@GetMapping("/ban")
	public List<BanEntity> getBan() {
		 List<BanEntity> list=repo.findAll();
		 for (BanEntity item:list)
		 {
		
			 item.setHoaDon(null);
			 item.setLoaiBan(null);
		 }
		 System.out.print(list.size());
		return list;
	}

	@PostMapping(value="/ban")
	public String create(@RequestBody BanDTO model) {
		
		BanEntity save = new BanEntity();
		BanEntity check = null;
		try {
			save.setLoaiBan(loaibanrepo.findById(model.getLoai()).get());
			save.setSoGhe(model.getSoGhe());
			save.setTinhTrang(model.getTinhTrang());
		
			check = repo.saveAndFlush(save);
		} catch (Exception e) {
			e.printStackTrace();
			
			
			return "01";
		}
		if (check == null) {

			return "02";
		}
		return "00";
	}
	
	@PutMapping(value="/ban")
	public String update(@RequestBody BanDTO model) {

		Optional<BanEntity> option = repo.findById(model.getiD());
		if (option.isEmpty()) {

			System.out.print("ko tồn tại");
			return "404";
		}

		else {
			System.out.print("tồn tại");
			BanEntity save = option.get();
			BanEntity check = null;
			try {

				save.setLoaiBan(loaibanrepo.findById(model.getLoai()).get());
				save.setSoGhe(model.getSoGhe());
				save.setTinhTrang(1);
				check = repo.save(save);
			} catch (Exception e) {
				e.printStackTrace();
				return "01";
			}

			if (check == null) {
				return "02";
			}
			return "00";
		}

	}
	
	@DeleteMapping(value="/ban")
	public String delete(@RequestBody BanDTO ids) {
		Optional<BanEntity> option = repo.findById(ids.getiD());
		if (option.isEmpty()) {

			System.out.print("ko tồn tại");
			return "404";
		}

		else {
			System.out.print("tồn tại");
			BanEntity save = option.get();
			BanEntity check = null;
			try {

				save.setTinhTrang(0);
				check = repo.save(save);

			} catch (Exception e) {
				e.printStackTrace();
				return "01";
			}

			if (check == null) {
				return "02";
			}
			return "00";
		}

	}

}
