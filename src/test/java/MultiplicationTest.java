
import org.junit.platform.runner.JUnitPlatform;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import config.BeanCreationConfig;
import service.AdditionService;
import org.springframework.test.context.junit.jupiter.SpringExtension;
@ExtendWith(SpringExtension.class)
@RunWith(JUnitPlatform.class)
//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BeanCreationConfig.class})
@WebAppConfiguration
public class MultiplicationTest {

	@Autowired
	private AdditionService additionService; 
	
	@Test
	public void multiplyTest(){
		int a = 10;
		int b = 20;
		int c;
		c = additionService.add(a, b);
		System.out.println("c: "+ c);
	}
	
	@Test
	public void subTest(){
		int a = 32;
		int b = 21;
		int c = additionService.add(a, b);
		System.out.println("c: "+ c);
	}
	
//	@BeforeEach
	@Test
	public void multiplyTest2(){
		int a = 10;
		int b = 20;
		int c;
		c = additionService.add(a, b);
		System.out.println("c: "+ c);
	}
	
}
