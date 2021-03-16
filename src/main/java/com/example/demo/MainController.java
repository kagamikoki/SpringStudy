package com.example.demo;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;



@Controller
public class MainController{
	
	@RequestMapping(value="/" , method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mv) {
		mv.addObject("name","名前がここに入ります");
		mv.addObject("age","年齢がここに入ります");
		mv.addObject("height","身長がここに入ります");
		mv.addObject("from","出身地がここに入ります");
		mv.setViewName("index");
		return mv;
	
	}
	
	@RequestMapping(value="/" , method=RequestMethod.POST)
	public ModelAndView indexPost(ModelAndView mv , @RequestParam("nameVal")String name,
	@RequestParam("ageVal")int age,@RequestParam("heightVal")String height,@RequestParam("fromVal")String from){
	mv.addObject("name", name);
	mv.addObject("age", age + 3);
	mv.addObject("height", height);
	mv.addObject("from", from);
	mv.setViewName("index");
	return mv;
	}
	
	@RequestMapping(value="/calc" , method=RequestMethod.GET)
	public ModelAndView calc(ModelAndView mv) {
		mv.addObject("calc","階乗の計算をします。");
		mv.setViewName("calc");
		return mv;
	}
	
	@RequestMapping(value="/calc" , method=RequestMethod.POST)
	public ModelAndView indexPost(ModelAndView mv , 
	@RequestParam("calcVal")int calc){
	
		int total = 0;
		for(int i=1; i<=calc; i++) {
			total += i;
			};
			
	mv.addObject("calc",  calc + "の階乗は" + total + "です。");
	return mv;
	}
	
	@RequestMapping(value="/shipping" , method=RequestMethod.GET)
	public ModelAndView shippingGet(ModelAndView mv) {
		mv.addObject("shipping"," ");
		
		mv.setViewName("shipping");
		return mv;
	}
	
	@RequestMapping(value="/shipping" , method=RequestMethod.POST)
	public ModelAndView shippingPost(ModelAndView mv ,
	@RequestParam("Age")String age ,
	@RequestParam("origin")String origin ,
	@RequestParam("destination")String destination
	) {
		
		//発地
		int i = 0;
		if(origin.equals("北海道")) {
			i += 1500;
		}else if(origin.equals("東北地方")){
			 i += 900;
		}else if(origin.equals("関東地方")){
			 i += 500;
		}else if(origin.equals("中部地方")){
			 i += 700;
		}else if(origin.equals("近畿地方")){
			 i += 600;
		}else if(origin.equals("中国地方")){
			 i += 800;
		}else if(origin.equals("四国")){
			 i += 1000;
		}else if(origin.equals("九州")){
			 i += 1200;
		}else if(origin.equals("沖縄")){
			 i += 1500;
		}
		
		//着地
		if(destination.equals("北海道")) {
			i += 1500;
		}else if(destination.equals("東北地方")){
			 i += 900;
		}else if(destination.equals("関東地方")){
			 i += 500;
		}else if(destination.equals("中部地方")){
			 i += 700;
		}else if(destination.equals("近畿地方")){
			 i += 600;
		}else if(destination.equals("中国地方")){
			 i += 800;
		}else if(destination.equals("四国")){
			 i += 1000;
		}else if(destination.equals("九州")){
			 i += 1200;
		}else if(destination.equals("沖縄")){
			 i += 1500;
		}
		
		mv.addObject("shipping", origin  + "⇨" + destination + "　　は "+ i + "円です");
		mv.setViewName("shipping");
		return mv;
	}
	
	
	
	
	@RequestMapping(value="/ifstudy" , method=RequestMethod.GET)
	public ModelAndView ifget(ModelAndView mv) {
		mv.addObject("suzuki", false);
		mv.setViewName("if");
		return mv;
	}
	
	@RequestMapping(value="/ifstudy" , method=RequestMethod.POST)
	public ModelAndView ifpost(ModelAndView mv ,@RequestParam("Val")String suzuki){
		mv.addObject("suzuki", true);
		mv.setViewName("if");
		return mv;
	}
	
	@RequestMapping(value="/post" , method=RequestMethod.POST)
	public ModelAndView post(ModelAndView mv) {
		mv.setViewName("index");
		return mv;
	}
	
//	@RequestMapping("/{name}")
//	public ModelAndView index(@PathVariable String name, ModelAndView mv) {
//		mv.addObject("name" , name);
//		mv.setViewName("index");
//		return mv;
//	}
	
	@RequestMapping(value="/primeNumber" , method=RequestMethod.POST)
	public ModelAndView primepost(ModelAndView mv) {
		mv.setViewName("primeNumber");
		return mv;
	}
	@RequestMapping(value="/primeNumber" , method=RequestMethod.GET)
	public ModelAndView primeget(ModelAndView mv) {
		mv.addObject("primeNumber","素数判定マシーン");
		mv.setViewName("primeNumber");
		return mv;
	}
	
	@RequestMapping("primeNumber/{number}")
	public ModelAndView postPrime(@PathVariable int number, ModelAndView mv) {
		
		String prime = "素数です";
		
		for(int i = 2; i < number; i++) {
			
			if(number % i == 0) {
			prime = "素数ではありません...";
			break;
			
			}else {
				prime = "素数です!";
			}
		}
			
			mv.addObject("primeNumber" , number + "は" + prime);
			mv.setViewName("primeNumber");
			return mv;
		}
	
	@RequestMapping(value="/day22" , method = RequestMethod.POST )
	public ModelAndView dayPost(ModelAndView mv) {
		mv.setViewName("day22");
		return mv;
}
	@RequestMapping(value="/day22" , method = RequestMethod.GET )
	public ModelAndView dayGet(ModelAndView mv) {
		ArrayList<String[]>customers = new ArrayList<String[]>();
			customers.add(new String[] {"佐藤HTML太郎","35歳","男性","東京都"});
			customers.add(new String[] {"鈴木Java五郎","24歳","男性","京都府"});
			customers.add(new String[] {"高橋CSS子","29歳","女性","大阪府"});
			customers.add(new String[] {"伊藤Spring","23歳","女性","北海道"});
			customers.add(new String[] {"斎藤","40歳","男性","神奈川県"});
			mv.addObject("customers",customers);
			mv.setViewName("day22");
			return mv;
	}
	
	@Autowired
	UserDataRepository repository;
	
	@RequestMapping(value="/user", method = RequestMethod.GET)
	public ModelAndView indexGet(ModelAndView mv) {
		List<UserData> customers = repository.findAll();
		mv.addObject("customers" , customers );
		mv.setViewName("user");
		return mv;
	}
	
	@RequestMapping(value="/user", method = RequestMethod.POST)
	public ModelAndView indexPost(
			@ModelAttribute("formModel") @Validated UserData userData, 
			BindingResult result , RedirectAttributes attributes , 
			ModelAndView mv) {
		
		if(result.hasErrors()) {
			
			List<UserData> customers = repository.findAll();
			
			mv.addObject("formModel" , userData);
			mv.addObject("customers" , customers );
			
			setFlashAttributeErrors(attributes, result);
			
			mv.setViewName("user");
			return mv;
		}
		
		
		repository.saveAndFlush(userData);
		return new ModelAndView("redirect:/user");
	}
	
	@Autowired
	ChannelDataRepository crepository;
	
	@RequestMapping(value="/channel" , method = RequestMethod.GET)
	public ModelAndView channelGet(ModelAndView mv) {
		List<ChannelData> customers = crepository.findAll();
		mv.addObject("customers" , customers);
		mv.setViewName("channel");
		return mv;
	}
	
	@RequestMapping(value="/channel" , method = RequestMethod.POST)
	public ModelAndView channelpost(@ModelAttribute("formModel") 
			ChannelData ChannelData, ModelAndView mv) {
		
		Date now = new Date();
		System.out.println(now);
		SimpleDateFormat d = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String c = d.format(now);	
		ChannelData.setTime(c);
		
		crepository.saveAndFlush(ChannelData);
		return new ModelAndView("redirect:/channel");
	}
	
	
	@RequestMapping(value="/delete/" , method = RequestMethod.POST)
	public ModelAndView delete(@RequestParam("idvalue")long id, ModelAndView mv) {
		System.out.println(id);
		drepository.deleteById(id);
		return new ModelAndView("redirect:/day24");
	}
	
	@RequestMapping(value="/mypage" , method= RequestMethod.GET)
	public ModelAndView mypageGet(ModelAndView mv) {
		Optional<day24Data> customers = drepository.findById((long)1);
		mv.addObject("customers" , customers.get() );
		mv.setViewName("/mypage");
		return mv;
	}
	
	@RequestMapping(value="mypage/{code}" , method = RequestMethod.GET)
	public ModelAndView codePost(@ModelAttribute day24Data day24Data, ModelAndView mv ,@PathVariable long code) {
		Optional<day24Data> customers = drepository.findById((long)code);
		mv.addObject("customers" , customers.get() );
		mv.addObject("id" , code );
		mv.setViewName("mypage");
		return mv;
	}
	
	@RequestMapping(value="/mypage/" , method = RequestMethod.POST)
	public ModelAndView mypagePost(@ModelAttribute day24Data day24Data ,ModelAndView mv ) {
		drepository.saveAndFlush(day24Data);
		return new ModelAndView("redirect:/mypage");
	}	
	
	
	@Autowired
	day24DataRepository drepository;
	
	@RequestMapping(value="/day24" , method = RequestMethod.GET)
	public ModelAndView day24Get(ModelAndView mv) {
		mv.setViewName("/day24");
		return mv;
	}
	
	@RequestMapping(value="/day24" , method= RequestMethod.POST)
	public ModelAndView day24post(@ModelAttribute("dayform")
	day24Data day24Data,ModelAndView mv) {
		drepository.saveAndFlush(day24Data);
		return new ModelAndView("redirect:/day24");
	}
	
	
	
	@Autowired
	db_exampleRepository hrepository;
	
	@Autowired
	memberDataRepository mrepository;
	
	@RequestMapping(value="/household" , method = RequestMethod.GET)
	public ModelAndView householdGet(
			@ModelAttribute("houseform")db_example db ,
			@ModelAttribute("memberform")memberData memberData ,ModelAndView mv) {
		
		List<db_example> customer = hrepository.findAll();
		List<memberData> client = mrepository.findById(1);
		
		mv.addObject("customer" , customer );
		mv.addObject("houseform", db);
		mv.addObject("memberform", memberData);
		mv.addObject("client" , client);
		
		mv.setViewName("household");
		return mv;
	}
	
	
	@RequestMapping(value="/household" , method = RequestMethod.POST)
	public ModelAndView householdPost(
		@ModelAttribute("houseform")@Validated db_example db_example ,
		BindingResult result ,RedirectAttributes attributes ,
		@ModelAttribute("memberform") memberData memberData ,
		ModelAndView mv ){
	
			//バリデーション
			if(result.hasErrors()) {
				List<db_example> customer = hrepository.findAll();
				List<memberData> client = mrepository.findById(1);
				
				mv.addObject("houseform",db_example);
				mv.addObject("customer" , customer );
				mv.addObject("memberform", memberData);
				mv.addObject("client" , client);
				
				setFlashAttributeErrors(attributes, result);
				
				mv.setViewName("/household");
				return mv;
				
			}
		
		
			List<db_example> customer = hrepository.findAll();
			List<memberData> client = mrepository.findById(1);
			
			db_example.setMemberData(client.get(0));
			
			hrepository.saveAndFlush(db_example);
			
			
			mv.addObject("houseform",db_example);
			mv.addObject("customer" , customer );
			mv.addObject("memberform", memberData);
			mv.addObject("client" , client);
			
			return new ModelAndView("redirect:/household");
		}
	
	
	private void setFlashAttributeErrors(RedirectAttributes attributes, BindingResult result) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@RequestMapping(value="/member" , method = RequestMethod.GET)
	public ModelAndView memberGet(@ModelAttribute("memberform")memberData memberData ,ModelAndView mv) {
		List<memberData> client = mrepository.findAll();
		mv.addObject("client" , client );
		mv.addObject("memberform", memberData);
		mv.setViewName("member");
		return mv;
	} 
	
	@RequestMapping(value="/member" , method = RequestMethod.POST)
	public ModelAndView membePost(@ModelAttribute("memberform") memberData memberData ,ModelAndView mv) {
		mrepository.saveAndFlush(memberData);
		
		return new ModelAndView("redirect:/household");
	} 

	
	}
	
	
	//@Valid db_example db_example, →　入力されたデータの検証するためのアノテーション
	//BindingResult bindingResultは、入力されたデータと検証結果（エラーがあるかどうか）を保持するためのアノテーション
	//bindingResult.hasErrors()が書かれているif文では、エラーがあるかどうかを確認
	//⇨もしエラーがある場合、householdをエラーメッセージと入力されていた値と共に再描画する
	//RedirectAttributes リダイレクト先にパラメータとして渡す
	


