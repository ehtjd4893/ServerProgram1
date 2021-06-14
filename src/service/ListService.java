package service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class ListService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		
		List<MemberDTO> list = MemberDAO.getInstance().getList();
		
		request.setAttribute("list", list);
		
		return new ModelAndView("/views/list.jsp", false);
	}

}
