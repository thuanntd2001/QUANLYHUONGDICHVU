package spring.controller.admin;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.entity.ChucVuEntity;
import spring.entity.NhanVienEntity;
import spring.entity.ThucDonEntity;
import spring.entity.UserTBEntity;

@Transactional
@Controller
@RequestMapping(value = "/admin-home/")
public class QLTaiKhoan {
	@Autowired
	SessionFactory factory;

	public String hashPass(String matKhau) {
		String hashpw = DigestUtils.md5Hex(matKhau);
		return hashpw;
	}
	
	// CONTROLLER
	@RequestMapping(value = "admin-taikhoan", method = RequestMethod.GET)
	public <E> String index_TaiKhoan(HttpServletRequest request, ModelMap model) {
		@SuppressWarnings("unchecked")
		PagedListHolder<E> pagedListHolder = new PagedListHolder<E>((List<E>) this.getTaiKhoans());
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(10);

		pagedListHolder.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "admin/qltaikhoan";
	}

	

	public List<ChucVuEntity> getChucVus() {
		Session session = factory.getCurrentSession();
		String hql = "FROM ChucVuEntity";
		Query query = session.createQuery(hql);
		List<ChucVuEntity> list = query.list();

		return list;
	}

	public ChucVuEntity getChucVu(long id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM ChucVuEntity where id =:id ";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		ChucVuEntity list = (ChucVuEntity) query.list().get(0);
		return list;
	}

	public NhanVienEntity getNV(long id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM NhanVienEntity where id =:id ";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		NhanVienEntity list = (NhanVienEntity) query.list().get(0);
		return list;
	}

	// th??m
	public int CheckUserName_Email(String username, String email) { // check xem email v?? username ???? c?? hay ch??a
		List<UserTBEntity> list = getTaiKhoans();
		int n = list.size();
		String user;
		String emailtmp;
		for (int i = 0; i < n; i++) {
			user = list.get(i).getUserName();
			if (user.equals(username)) {
				return 1;
			}

			emailtmp = list.get(i).getEmail();
			if (emailtmp.equals(email)) {
				return 2;
			}
		}
		return 0;
	}

	// show form
		@RequestMapping(value = "formTaiKhoan", method = RequestMethod.GET)
		public String formInputTaikhoan(ModelMap model) {
			model.addAttribute("tk", new UserTBEntity());
			model.addAttribute("chucvus", this.getChucVus());
			/*model.addAttribute("fixmanv", "false");*/
			model.addAttribute("doc", "false");
			return "admin/form/inputTaiKhoan";
		}
	@RequestMapping(value = "formTaiKhoan", params = "Insert", method = RequestMethod.POST)
	public <E> String addTaiKhoan(HttpServletRequest request, ModelMap model, @ModelAttribute("tk") UserTBEntity tk) {
		String error = "";
		Integer temp = 0;
		int check = CheckUserName_Email(tk.getUserName(), tk.getEmail());
		
		if (tk.getUserName().trim().equals("")) {
			error = "T??n t??i kho???n kh??ng ???????c ????? tr???ng!";
		} else if (check == 1) {
			error = "v?? t??n t??i kho???n ???? t???n t???i!!!";
		} else if (check == 2) {
			error = "email kh??ng ???????c tr??ng!!!";
		} else {
			String maNVtmp = request.getParameter("manv");

			Integer maNV = Integer.parseInt(maNVtmp);
			String tmp = request.getParameter("chucvu").trim();
			Integer idChucVU = Integer.parseInt(tmp);
			if(CheckMaNhanVien(maNV)==false) {
				System.out.println(maNV);
				error = "kh??ng t???n t???i nh??n vi??n";
			}else {
				
			tk.setUsernv(getNV(maNV));
			tk.setChucVu(getChucVu(idChucVU));
			tk.setStatus(1);
			tk.setIcon("1");
			String generatedString = RandomStringUtils.randomNumeric(6);//t???o chu???i k?? t??? s??? ????? d??i l?? 6
			tk.setPasswd(generatedString);
			/*listError = checkInfo(tk);*/

			temp = this.insertTaiKhoan(tk);
			 }
		}

		if (temp != 0) {
			model.addAttribute("message", "Th??m m???i th??nh c??ng");

		} else {
			model.addAttribute("message", "Th??m th???t b???i " + error + " ");
		}
		@SuppressWarnings("unchecked")
		PagedListHolder<E> pagedListHolder = new PagedListHolder<E>((List<E>) this.getTaiKhoans());
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(10);
		pagedListHolder.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "admin/qltaikhoan";
	}

	public Integer insertTaiKhoan(UserTBEntity tk) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {

			session.save(tk);
			t.commit();
		} catch (Exception e) {

			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	// end th??m

//	ph???n t??m ki???m
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "admin-taikhoan", params = "btnsearch", method = RequestMethod.POST)
	public <E> String searchTaiKhoan(HttpServletRequest request, ModelMap model) {
		PagedListHolder<E> pagedListHolder = new PagedListHolder<E>(
				(List<E>) this.searchTaiKhoan(request.getParameter("searchInput")));
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setMaxLinkedPages(10);

		pagedListHolder.setPageSize(5);

		model.addAttribute("pagedListHolder", pagedListHolder);

		return "admin/qltaikhoan";
	}

	public List<UserTBEntity> searchTaiKhoan(String name) {
		Session session = factory.getCurrentSession();
		String hql = "FROM UserTBEntity where chucVu.tenChucVu like :name OR email like :name OR userName like :name ";
		Query query = session.createQuery(hql);

		query.setParameter("name", "%" + name + "%");
		List<UserTBEntity> list = query.list();
		return list;
	}

	// ph???n ch???nh s???a

	@RequestMapping(value = "formTaiKhoan", params = "linkEdit")
	public String editTK_showform(HttpServletRequest request, ModelMap model, @ModelAttribute("tk") UserTBEntity tk) {

		model.addAttribute("tk", this.getTaiKhoan(tk.getUserName()));
		model.addAttribute("maNV", this.getTaiKhoan(tk.getUserName()).getUsernv().getMaNV());
		model.addAttribute("chucvus", this.getChucVus_kAdmin());
		model.addAttribute("idCV", this.getTaiKhoan(tk.getUserName()).getChucVu().getId());
		
		model.addAttribute("fixmanv", "true");// kh??ng ??c s???a m?? username
		model.addAttribute("doc", "readonly");// kh??ng ???????c s???a m?? nh??n vi??n
		model.addAttribute("btnupdate", "true");
		return "admin/form/inputTaiKhoan";
	}

	public List<NhanVienEntity> getNhanVien() {
		Session session = factory.getCurrentSession();
		String hql = "FROM NhanVienEntity where daNghi = false";
		Query query = session.createQuery(hql);
		List<NhanVienEntity> list = query.list();
		return list;
	}

	public boolean CheckMaNhanVien(long manv) { // n???u c?? nh??n vi??n ??ang l??m vi???c tr??? v??? true
		List<NhanVienEntity> list = getNhanVien();
		int n = list.size();
		NhanVienEntity nv;
		for (int i = 0; i < n; i++) {
			nv = list.get(i);
			if (manv == nv.getMaNV() && nv.getDaNghi()  == false) {
				return true;
			}
		}
		return false;
	}

	@RequestMapping(value = "formTaiKhoan", params = "btnupdate", method = RequestMethod.POST)
	public <E> String editTK(HttpServletRequest requets, ModelMap model, @ModelAttribute("tk") UserTBEntity tk) {

		Integer temp = 0;

		String maNVtmp = requets.getParameter("manv");
		Integer maNV = Integer.parseInt(maNVtmp);
		String tmp = requets.getParameter("chucvu");
		Integer idChucVU = Integer.parseInt(tmp);
		
		tk.setPasswd(getTaiKhoan(tk.getUserName()).getPasswd());
		tk.setUsernv(getNV(maNV));
		tk.setChucVu(getChucVu(idChucVU));
		tk.setStatus(1);
		tk.setIcon("1");
		
		temp = this.updateTK(tk);

		if (temp != 0) {
			model.addAttribute("message", "C???p nh???t th??nh c??ng");
		} else {
			model.addAttribute("message", "C???p nh???t kh??ng th??nh c??ng");

		}
		@SuppressWarnings("unchecked")
		PagedListHolder<E> pagedListHolder = new PagedListHolder<E>((List<E>) this.getTaiKhoans());
		int page = ServletRequestUtils.getIntParameter(requets, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(10);

		pagedListHolder.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "admin/qltaikhoan";
	}

	public Integer updateTK(UserTBEntity tk) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(tk);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	// end ph???n ch???nh s???a

//	ph???n x??a
	public Boolean checkAdmin(String username) {
		List<UserTBEntity> list = getTaiKhoans();
		int n = list.size();
		UserTBEntity tmp;
		for (int i = 0; i < n; i++) {
			tmp = this.getTaiKhoan(list.get(i).getUserName());

			if (tmp.getChucVu().getId() == 1 && tmp.getUserName().equals(username)) {
				return true;

			}
		}

		return false;
	}
	
	@RequestMapping(value = "admin-taikhoan", params = "linkReset", method = RequestMethod.GET)
	public <E> String ResetMatKhau(HttpServletRequest requests, ModelMap model, @ModelAttribute("tk") UserTBEntity tk) {

		String userName = tk.getUserName();

		
			UserTBEntity tmp = this.getTaiKhoan(userName);
		//	String generatedString = RandomStringUtils.randomNumeric(6);//t???o chu???i k?? t??? s??? ????? d??i l?? 6
			tmp.setPasswd(hashPass("123456"));
			Integer temp = this.updateTK(tmp);
		
		if (temp != 0) {
			model.addAttribute("message", "?????t l???i m???t kh???u th??nh c??ng, m???c ?????nh 123456");
		} else {
			model.addAttribute("message", "?????t l???i m???t kh???u th???t b???i");
		}
		@SuppressWarnings("unchecked")
		PagedListHolder<E> pagedListHolder = new PagedListHolder<E>((List<E>) this.getTaiKhoans());
		int page = ServletRequestUtils.getIntParameter(requests, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(10);

		pagedListHolder.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "admin/qltaikhoan";

	}

	@RequestMapping(value = "admin-taikhoan", params = "linkDelete", method = RequestMethod.GET)
	public <E> String deleteNV(HttpServletRequest requests, ModelMap model, @ModelAttribute("tk") UserTBEntity tk) {

		String error = "";
		Integer temp = 0;

		String userName = tk.getUserName();

		System.out.println(userName);
		System.out.println(checkAdmin(userName));
		if (checkAdmin(userName)) {
			error = ", kh??ng th??? x??a t??i kho???n admin";
		} else {
			UserTBEntity tmp = this.getTaiKhoan(userName);
			tmp.setStatus(0);
			temp = this.updateTK(tmp);
		}
		if (temp != 0) {
			model.addAttribute("message", "X??a th??nh c??ng");
		} else {
			model.addAttribute("message", "X??a k th??nh c??ng" + error);
		}
		@SuppressWarnings("unchecked")
		PagedListHolder<E> pagedListHolder = new PagedListHolder<E>((List<E>) this.getTaiKhoans());
		int page = ServletRequestUtils.getIntParameter(requests, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(10);

		pagedListHolder.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "admin/qltaikhoan";

	}

	public List<UserTBEntity> getTaiKhoans() {
		Session session = factory.getCurrentSession();
		String hql = "FROM UserTBEntity where status =:status";
		Query query = session.createQuery(hql);
		query.setParameter("status", 1);
		List<UserTBEntity> list = query.list();
		return list;
	}

	public List<ChucVuEntity> getchucvus() {
		Session session = factory.getCurrentSession();
		String hql = "FROM ChucVuEntity";
		Query query = session.createQuery(hql);
		List<ChucVuEntity> list = query.list();
		return list;
	}
	public List<ChucVuEntity> getChucVus_kAdmin() {
		Session session = factory.getCurrentSession();
		String hql = "FROM ChucVuEntity C where C.id != 1 ";
		Query query = session.createQuery(hql);
		List<ChucVuEntity> list = query.list();
		return list;
	}

	public UserTBEntity getTaiKhoan(String username) {
		Session session = factory.getCurrentSession();
		String hql = "FROM UserTBEntity where userName =:username and status=:status";

		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		query.setParameter("status", 1);
		UserTBEntity list = (UserTBEntity) query.list().get(0);
		return list;
	}
}