import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import config.BeanCreationConfig;
import service.AdditionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BeanCreationConfig.class})
@WebAppConfiguration
public class AdditionTest {
	
	@Autowired
	private AdditionService additionService;
	
	@Test
	public void additionTest(){
		int a = 10;
		int b = 20;
		int c = additionService.add(a, b);
		System.out.println("c: "+ c);
	}
	
	@Test
	public void additionTest2(){
		int a = 11;
		int b = 21;
		int c = additionService.add(a, b);
		System.out.println("c: "+ c);
	}
	
	@Test
	public void subTest1(){
		int a = 11;
		int b = 21;
		int c = additionService.sub(a, b);
		System.out.println("c: "+ c);
	}
	

	@Test
	public void subTest2(){
		int a = 11;
		int b = 21;
		int c = additionService.sub(a, b);
		System.out.println("c: "+ c);
	}
}
