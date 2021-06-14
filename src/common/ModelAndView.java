package common;

public class ModelAndView {
	private String view;
	private boolean redirect;
	
	public ModelAndView() {
		// TODO Auto-generated constructor stub
	}

	public ModelAndView(String view, boolean redirect) {
		super();
		this.view = view;
		this.redirect = redirect;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public boolean isRedirect() {
		return redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	
	
	
}
