package com.cjh.ex.controller;

import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjh.ex.dto.TraineeDTO;
import com.cjh.ex.service.TraineeService;

@Controller
public class HomeController {
	
	// 스프링이 관리하는 객체를 사용하기
	// 의존성 주입(DI, Dependency Injection)
	@Autowired
	private TraineeService ts;
	
//	TraineeService ts = new TraineeService();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "index";
	}
	
	// insert 주소 요청
	@RequestMapping(value = "/insertform", method = RequestMethod.GET)
	public String insertform() {
		
		return "insert";
	}
	
	// 회원가입 후 인덱스로
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String trainee(@ModelAttribute TraineeDTO trainee) {
		System.out.println(trainee);
		
		// TraineeService 에 있는 insert 메서드를 호출하면서 trainee 객체를 넘긴다면
		ts.insert(trainee);
		
		// ss.hello();
		
		return "index";
	}
	
	// 전체회원 조회
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public String findAll(Model model) {
		
		// select * from trainee 결과를 mybatis가 List에 담아주고 그 리턴을 가져옴
		List<TraineeDTO> tList = ts.findAll();
		
		model.addAttribute("tList",tList);
		
		return "findAll";
	}
	
	// 원하는 회원조회
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String findById(@RequestParam("t_number") long t_number, Model model) {
		System.out.println("findById: "+ t_number);
		
		/*
		 * TraineeService.findById() 호출
		 * TraineeRepository.findById() 호출
		 * trainee-mapper.findById 호출(mapper에서 parameterType="long" 이라고 하면 됨)
		 * 
		 * 호출하고 역순으로 리턴을 가져화서(리턴타입이 뭐가 돼야 할지 관건)
		 * 결과 출력은 detail.jsp에서 해당 객체값을 출력하면 됩니다.	
		 */
		TraineeDTO trainee = ts.findById(t_number);
		model.addAttribute("trainee",trainee);
		
		return "detail";
	}
	
	// 원하는 회원삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("t_number") long t_number) {
		
		/*
		 * TraineeService.delete() 호출
		 * TraineeRepository.delete() 호출(mapper 호출시 sql.delete() 메서드 사용)
		 * trainee-mapper.delete 호출(mapper에서 parameterType="long" 이라고 하면 됨)
		 * 
		 */
		ts.delete(t_number);
		
		// 삭제 완료된 목록 
		// 삭제 처리후 단순휘 findAll.jsp만 출력한 결과(list를 가져가는 내용이 없음)
		// return "findAll";
		
		// 삭제가 반영된 목록을 다시 요청해야 하며,
		// 다시 요청하는 방식은 redirect 가 있음.
		// redirect를 할 때는 컨트롤러의 주소를 요청해야 함.(절대로 jsp를 요청하는 것이 아님)
		return "redirect:/findAll";
	}
	
	// 원하는 회원수정 (update.jsp 화면에 출력)
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateForm(@RequestParam("t_number") long t_number, Model model) {
		
		/*
		 * t_number에 해당하는 데이터를 DB에서 가져와서 update.jsp로 가져감 
		 */
		TraineeDTO trainee = ts.findById(t_number);
		model.addAttribute("trainee",trainee);
		return "update";
	}
	
	// 원하는 회원수정 (update.jsp 에서 수정한 정보를 findAll로 입력)
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute TraineeDTO trainee) {
		
		System.out.println("Controller.update()" + trainee);
		
		ts.update(trainee);
		
		return "redirect:/findAll";
	}
	
	
}