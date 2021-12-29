package springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedCaseInsensitiveMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springmvc.dao.EmployeeDao;
import springmvc.pojo.Employee;

@Controller
public class HomeController {
	
	@RequestMapping("/dash")
	public ModelAndView dashboard(HttpServletRequest request) {
		System.out.println("request.getSession().getAttribute(\"isLogin\") : "+request.getSession().getAttribute("isLogin"));
		
		if(request.getSession().getAttribute("isLogin")!=null) {
			ModelAndView mv = setValueToDashboard(request);
			mv.setViewName("dashboard");
			return mv;
		}
		else {
			return new ModelAndView("redirect:" + "login");
		}
	}
	
	@RequestMapping(path="/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping(path="/signup")
	public String signUp() {
		return "register";
	}
	
	@RequestMapping(path="/login")
	public ModelAndView login(HttpServletRequest request) {
		
		if(request.getSession().getAttribute("isLogin")!=null) {
			return new ModelAndView("redirect:" + "dash");
		}
		else {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("login");
			return mv;
		}
	}
	
	@RequestMapping(path="/logout")
	public ModelAndView logout(HttpServletRequest request) {
		request.getSession().removeAttribute("sessionEmail");
		request.getSession().removeAttribute("isLogin");
		return new ModelAndView("redirect:" + "login");
	}
	
	@RequestMapping(path="/processlogin")
	public ModelAndView processLogin(@RequestParam("email") String email,
		@RequestParam("password") String password, HttpServletRequest request) {
		System.out.println("email : "+email);
		System.out.println("password : "+password);
//		model.addAttribute("name", "Yogendra Rajput G");
		//return "dashboard";		
		
		Employee e2 = getDaoObject(email);
		ModelAndView mv = new ModelAndView();
		
			if(e2!=null && e2.getPassword().equals(password)) {
				request.getSession().setAttribute("sessionEmail", email);
				request.getSession().setAttribute("isLogin", "yes");
				mv.addObject("firstName", e2.getFirstName());
				mv.addObject("lastName", e2.getLastName());
				mv.addObject("email", email);
				mv.addObject("contact", e2.getContact());
				mv.addObject("password", password);
				mv.setViewName("dashboard");
				return mv;
			}
		

		mv.setViewName("login"); //when no match found
		return mv;
	}
	
	private Employee getDaoObject(String email){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");  
		EmployeeDao dao=(EmployeeDao)ctx.getBean("edao",EmployeeDao.class);
		Employee e2 = dao.getLoginDetails(email);
		return e2;
	}
	
	public ModelAndView setValueToDashboard(HttpServletRequest request) {
		String email = (String)request.getSession().getAttribute("sessionEmail");
		Employee e2 = getDaoObject(email);
		System.out.println("e2 : "+e2);
		System.out.println("email : "+email);
		ModelAndView mv = new ModelAndView();
		
		try {
			mv.addObject("firstName", e2.getFirstName());
			mv.addObject("lastName", e2.getLastName());
			mv.addObject("email", e2.getEmail());
			mv.addObject("contact", e2.getContact());
			mv.addObject("password", e2.getPassword());
			return mv;
		}
		catch(Exception e) {
			System.out.println("Error while setting value to Dashboard + "+e.getMessage());
			return mv;
			//return new ModelAndView("redirect:" + "login");
		}
	}
	
	@RequestMapping(path="/processsignup")
	public ModelAndView processSignUp(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("email") String email,
			@RequestParam("contact") String contact,
			@RequestParam("password") String password, HttpServletRequest request) {
		System.out.println("FirstName : "+firstName);
		System.out.println("LastName : "+lastName);
		System.out.println("email : "+email);
		System.out.println("contact : "+contact);
		System.out.println("password : "+password);
//		model.addAttribute("name", "Yogendra Rajput G");
		//return "dashboard";
		request.getSession().setAttribute("sessionEmail", email);
		request.getSession().setAttribute("isLogin", "yes");
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");  
		EmployeeDao dao=(EmployeeDao)ctx.getBean("edao", EmployeeDao.class);
		String status1=dao.saveEmployee(new Employee(firstName,lastName,email,contact,password));
		
	//	ModelAndView mv = new ModelAndView("redirect:" + "dash");
		ModelAndView mv = new ModelAndView();
		mv.addObject("firstName", firstName);
		mv.addObject("lastName", lastName);
		mv.addObject("email", email);
		mv.addObject("contact", contact);
		mv.addObject("password", password);
		mv.setViewName("dashboard");
		return mv;
	}
	
}
