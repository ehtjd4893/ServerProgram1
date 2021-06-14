package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class JoinService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		int result = MemberDAO.getInstance().join(id, name);
		
		if(result == 0)
			return new ModelAndView("/views/login.jsp",false);
		else				
			return new ModelAndView("/ServerProgram1/views/success.jsp",true);
	}

}
