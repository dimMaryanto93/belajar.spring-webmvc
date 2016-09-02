package spring.mvc.belajar.aksi;

import javax.validation.Valid;
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
import spring.mvc.belajar.dao.JurusanDao;
import spring.mvc.belajar.dao.KelasDao;
import spring.mvc.belajar.domain.Kelas;

@Controller
@RequestMapping("/kelas")
public class KelasAksi {

    @Autowired
    private KelasDao dao;

    @Autowired
    private JurusanDao jurusanDao;

    @RequestMapping("/daftar")
    public ModelMap daftarKelas() {
        return new ModelMap("daftarKelas", dao.findAll());
    }

    @GetMapping("/tambah")
    public ModelMap kelasBaru() {
        ModelMap map = new ModelMap();
        map.addAttribute("kelas", new Kelas());
        map.addAttribute("daftarJurusan", jurusanDao.findAll());
        return map;
    }

    @PostMapping("/tambahBaru")
    public RedirectView prosesTambahKelas(@ModelAttribute @Valid Kelas kelas) {
        dao.save(kelas);
        return new RedirectView("daftar");
    }

    @GetMapping("/ubah-{id}")
    public ModelAndView updateKelas(@PathVariable("id") String id) {
        ModelAndView map = new ModelAndView("/kelas/ubah");
        map.addObject("kelas", dao.findOne(id));
        map.addObject("daftarJurusan", jurusanDao.findAll());
        return map;
    }

    @PostMapping("/perbaharui")
    public RedirectView prosesPerbaharuiKelas(@ModelAttribute @Valid Kelas kelas) {
        dao.save(kelas);
        return new RedirectView("daftar");
    }

    @GetMapping("/hapus-{id}")
    public RedirectView prosesHapusKelas(@PathVariable("id") String kode) {
        dao.delete(kode);
        return new RedirectView("daftar");
    }
}
