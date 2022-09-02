package spring.controller.chung;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quancafehighland.utils.SessionUtil;

@Controller
public class LoginController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	Locale localeVi = new Locale("vi");
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message_vi",localeVi);

	
	public String hashPass(String matKhau) {
		String hashpw = DigestUtils.md5Hex(matKhau);
		return hashpw;
	}
	
	@RequestMapping(value = "dang-nhap", method = RequestMethod.GET)
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			String alert = request.getParameter("alert");
			String message = request.getParameter("message");
			if (message != null && alert != null) {
				request.setAttribute("message", resourceBundle.getString(message));
				request.setAttribute("alert", alert);
			}
			RequestDispatcher rd = request.getRequestDispatcher("/jsp-views/login.jsp");
			rd.forward(request, response);
		} else if (action != null && action.equals("logout")) {
			SessionUtil.getInstance().removeValue(request, "USERMODEL");
			response.sendRedirect(request.getContextPath() + "/dang-nhap.htm?action=login");
			
		} else {
			response.sendRedirect(request.getContextPath() + "/dang-nhap.htm?action=login");
		}
	}

	@RequestMapping(value = "dang-nhap", method = RequestMethod.POST)
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
