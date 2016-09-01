package coba;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import junit.framework.TestCase;
import spring.mvc.belajar.KonfigurasiWeb;
import spring.mvc.belajar.dao.MahasiswaDao;
import spring.mvc.belajar.domain.Mahasiswa;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = KonfigurasiWeb.class)
@WebAppConfiguration
public class SpringContext extends TestCase {

    @Autowired
    private MahasiswaDao dao;

    @Test
    public void contextLoaded() {

    }

    @Test
    public void testCariSemuaMahasiswa() {
        Mahasiswa mhs = dao.findByNim("10511148");
        assertNull(mhs);
    }
}
