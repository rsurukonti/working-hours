package app.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@Autowired
	private welcomeservice service;
@RequestMapping("/welcome")	

	public String welcome()
	

	{
		return service.welcomeretrieve();
	}
	

}
@Component
class welcomeservice
{
	public String welcomeretrieve()
	{
	
		return "Hi all";
		
	}
	
}
