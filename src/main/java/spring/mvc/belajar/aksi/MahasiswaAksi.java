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

    @GetMapping(value = "/{action}-{id}")
    public ModelAndView informasiMahasiswa(@PathVariable(value = "id") String nim,
            @PathVariable(value = "action") String action) {
        Mahasiswa mhs = dao.findByNim(nim);
        ModelAndView mv = null;
        if (action.equalsIgnoreCase("update")) {
            mv = new ModelAndView("mahasiswa/update", "command", mhs);
            return mv;
        } else if (action.equalsIgnoreCase("info")) {
            mv = new ModelAndView("mahasiswa/info");
            mv.addObject(mhs);
            return mv;
        }
        return mv;
    }

    @GetMapping("/hapus-{id}")
    public RedirectView hapusMahasiswa(@PathVariable(value = "id") String id) {
        Mahasiswa mhs = dao.findByNim(id);
        dao.delete(mhs);
        return new RedirectView("daftar");
    }

    @GetMapping(value = "/reg")
    public ModelAndView formRegistrasi() {
        return new ModelAndView("mahasiswa/registrasi", "command", new Mahasiswa());
    }

    @PostMapping(value = "/registered")
    public RedirectView registrasiMahasiswa(@ModelAttribute Mahasiswa mhs) {
        dao.save(mhs);
        return new RedirectView("daftar");
    }

    @PostMapping("/do-updated")
    public RedirectView updateMahasiswa(@ModelAttribute Mahasiswa mhs) {
        dao.save(mhs);
        return new RedirectView("daftar");
    }

}
