package coba;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import spring.mvc.belajar.KonfigurasiWeb;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = KonfigurasiWeb.class)
@WebAppConfiguration
public class SpringContext {

	@Test
	public void contextLoaded() {

	}
}
