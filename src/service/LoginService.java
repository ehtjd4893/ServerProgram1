package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class LoginService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		MemberDTO dto = MemberDAO.getInstance().login(id, name);
		
		if(dto != null) {
			request.getSession().setAttribute("loginDTO", dto);
			return new ModelAndView("/views/manager.jsp",false);
			
		}
		return new ModelAndView("/ServerProgram1/views/login.jsp",true);
	}

}
