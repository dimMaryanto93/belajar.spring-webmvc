package spring.mvc.belajar.aksi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import spring.mvc.belajar.dao.MahasiswaDao;
import spring.mvc.belajar.domain.Mahasiswa;

@Controller
@RequestMapping("/mahasiswa")
public class MahasiswaAksi {

	@Autowired
	private MahasiswaDao dao;

	@GetMapping(value = "/daftar")
	public ModelMap daftarMahasiswa() {
		ModelMap map = new ModelMap();
		map.addAttribute("daftarMahasiswa", (List<Mahasiswa>) dao.findAll());
		return map;
	}

	@GetMapping(value = "/{id}")
	public ModelAndView informasiMahasiswa(@PathVariable(value = "id") String nim) {
		ModelAndView mv = new ModelAndView("/mahasiswa/info");
		mv.addObject("mahasiswa", dao.findByNim(nim));
		return mv;
	}

	@GetMapping(value = "/reg")
	public ModelAndView formRegistrasi() {
		return new ModelAndView("mahasiswa/registrasi", "command", new Mahasiswa());
	}

	@PostMapping(value = "/createNew")
	public RedirectView registrasiMahasiswa(@ModelAttribute Mahasiswa mhs) {
		dao.save(mhs);
		return new RedirectView("daftar");
	}

}
