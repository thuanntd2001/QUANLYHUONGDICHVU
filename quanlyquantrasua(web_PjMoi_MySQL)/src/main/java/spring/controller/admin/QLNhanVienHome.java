package spring.controller.admin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.bean.Collector;
import spring.dto.NhanVienDTO;

@Controller
@RequestMapping(value = "/admin-home/")
public class QLNhanVienHome {

	// CONTROLLER
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public <E> String index(HttpServletRequest request, ModelMap model) {
		List<NhanVienDTO> list = null;
		try {
			list = Collector.getListAll("/nhanvien", NhanVienDTO.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("list", list);
		return "admin/QLNV";
	}

	/* hiển thị form */
	@RequestMapping(value = "form", method = RequestMethod.GET)
	public String index_form(ModelMap model) {
		NhanVienDTO nv = new NhanVienDTO();

		model.addAttribute("nv", nv);
		return "admin/form/inputNV";
	}

	/*
	 * thêm nhân viên
	 * 
	 * @RequestMapping(value = "form",params = "Insert", method = RequestMethod.POST
	 * ) public <E> String addUser(HttpServletRequest request, ModelMap
	 * model,@ModelAttribute("nv") NhanVienDTO nv) {
	 * 
	 * 
	 * 
	 * String dateInString = request.getParameter("ngaysinh"); Date ngaysinh; try {
	 * ngaysinh = DateUtils.parseDate(dateInString, new String[] { "yyyy-MM-dd",
	 * "dd/MM-yyyy" }); nv.setNgaySinh(ngaysinh); } catch (ParseException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); }
	 * 
	 * String dateInString1 = request.getParameter("ngayvaolam"); Date ngayvaolam;
	 * try { ngayvaolam = DateUtils.parseDate(dateInString1, new String[] {
	 * "yyyy-MM-dd", "dd/MM-yyyy" }); nv.setNgayVaoLam(ngayvaolam); } catch
	 * (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
	 * }
	 * 
	 * List<String> listError = checkInfo(nv, dateInString,dateInString1);
	 * nv.getLuong(); nv.getHoTen().trim(); nv.getCmnd().trim();
	 * nv.getDiaChi().trim(); nv.getSdt().trim();
	 * 
	 * nv.setDaNghi(false);
	 * 
	 * Integer temp = this.insertUser(nv); if(temp != 0) {
	 * 
	 * model.addAttribute("message","Thêm Thành Công"); nv.setHoTen(null);
	 * nv.setGioiTinh(null); nv.setLuong(null); nv.setSdt(null); nv.setCmnd(null);
	 * nv.setDiaChi(null);
	 * 
	 * }else { model.addAttribute("message","Thêm thất bại! "+listError);
	 * 
	 * }
	 * 
	 * @SuppressWarnings("unchecked") PagedListHolder<E> pagedListHolder = new
	 * PagedListHolder<E>((List<E>) this.getNhanVien()); int page =
	 * ServletRequestUtils.getIntParameter(request, "p", 0);
	 * pagedListHolder.setPage(page); pagedListHolder.setMaxLinkedPages(10);
	 * pagedListHolder.setPageSize(5); model.addAttribute("pagedListHolder",
	 * pagedListHolder); return "admin/QLNV"; }
	 */
}
