package common;

import service.JoinPageService;
import service.JoinService;
import service.ListService;
import service.MemberService;
import service.UpdateService;
import service.LoginPageService;
import service.LoginService;
import service.LogoutService;

public class ServiceMapper {
	
	private static ServiceMapper mapper = new ServiceMapper(); 
	
	private ServiceMapper() {
		// TODO Auto-generated constructor stub
	}
	
	public static ServiceMapper getInstance() {
		return mapper;
	}
	
	public MemberService getService(String cmd) {
		MemberService service = null;
		switch(cmd) {
		case "list.do":
			service = new ListService(); 
			break;
		case "loginPage.do":
			service = new LoginPageService();
			break;
		case "login_chk.do":
			service = new LoginService(); 
			break;
		case "logout.do":
			service = new LogoutService();
			break;
		case "joinPage.do":
			service = new JoinPageService();
			break;
		case "join.do":
			service = new JoinService();
			break;
		case "update.do":
			service = new UpdateService();
			break;
		}
		
		return service;
	}
}
