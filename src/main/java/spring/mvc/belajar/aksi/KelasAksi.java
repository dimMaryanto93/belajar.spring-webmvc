package spring.mvc.belajar.aksi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.mvc.belajar.dao.KelasDao;

@Controller
@RequestMapping("/kelas")
public class KelasAksi {

    @Autowired
    private KelasDao dao;

    @RequestMapping("/daftar")
    public ModelMap daftarKelas() {
        return new ModelMap("daftarKelas", dao.findAll());
    }

}
