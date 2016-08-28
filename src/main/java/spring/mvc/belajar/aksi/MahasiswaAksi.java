package spring.mvc.belajar.aksi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.belajar.dao.MahasiswaDao;

@Controller
@RequestMapping("/mahasiswa")
public class MahasiswaAksi {

	@Autowired
	private MahasiswaDao dao;

	@RequestMapping("/daftar")
	public ModelMap daftarMahasiswa() {
		ModelMap map = new ModelMap();
		map.addAttribute("daftarMahasiswa", (List) dao.findAll());
		return map;
	}

}
