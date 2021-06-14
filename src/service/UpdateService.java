package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class UpdateService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		
		String name = request.getParameter("name");
		int point = Integer.parseInt(request.getParameter("point"));
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setPoint(point);
		if(point >= 5000) 
			dto.setGrade("vip");
		else if(point >= 4000)
			dto.setGrade("gold");
		else if(point >= 3000)
			dto.setGrade("silver");
		else if(point >= 0)
			dto.setGrade("bronze");
		
		MemberDTO result = MemberDAO.getInstance().update(dto);
		MemberDTO loginDTO = (MemberDTO) request.getSession().getAttribute("loginDTO");
		loginDTO.setGrade(result.getGrade());
		loginDTO.setName(result.getName());
		loginDTO.setPoint(result.getPoint());
		
		
		return new ModelAndView("/views/manager.jsp",false);
			
	}

}
