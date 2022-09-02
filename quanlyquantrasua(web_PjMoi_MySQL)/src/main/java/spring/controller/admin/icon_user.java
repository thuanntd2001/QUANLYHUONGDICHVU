package spring.controller.admin;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;




@Controller

@RequestMapping(value = "/admin-home/")
public class icon_user {
	String defaulf = "logo_highland.png";
	@Autowired
	ServletContext context;




	@RequestMapping(value = "admin-user-avt", method = RequestMethod.POST)
	public String Avt(ModelMap model, @RequestParam("avt") MultipartFile avt, HttpServletRequest request,
			HttpServletResponse response) {

		try {

			String path=avt.getOriginalFilename().trim();
			
			if (path.length()>40) {
				path=path.substring(0, 39);
			}
			
			String photoPath = context
					.getRealPath("/files/"  + path);
			

			
			try {
	
				model.addAttribute("message", "cập nhật thành công!");

				Thread.sleep(5000);
			} catch (Exception e) {
			
			} finally {
			}

		} catch (Exception e) {
			model.addAttribute("message", "lỗi lưu file!");
			e.printStackTrace();
		}

		return "redirect:/admin-home/admin-user.htm";

	}



}