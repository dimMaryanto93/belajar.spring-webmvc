/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.mvc.belajar.aksi;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import spring.mvc.belajar.dao.JurusanDao;
import spring.mvc.belajar.domain.Jurusan;

@Controller
@RequestMapping("/jurusan")
public class JurusanAksi {

    @Autowired
    private JurusanDao dao;

    @RequestMapping("/daftar")
    public ModelMap daftarJurusan() {
        ModelMap map = new ModelMap();
        map.addAttribute("daftarJurusan", dao.findAll());
        return map;
    }

    @RequestMapping("/tambah")
    public ModelMap formTambah() {
        return new ModelMap("jurusan", new Jurusan());
    }

    @RequestMapping("/jurusanBaru")
    public RedirectView prosesTambahJurusan(@ModelAttribute @Valid Jurusan jur) {
        dao.save(jur);
        return new RedirectView("daftar");
    }

    @RequestMapping("/ubah-{id}")
    public ModelAndView formUbah(@PathVariable("id") String kode) {
        Jurusan jur = dao.findOne(kode);
        return new ModelAndView("/jurusan/ubah", "jurusan", jur);
    }

    @RequestMapping("/jurusanUpdate")
    public RedirectView prosesUpdateJurusan(@ModelAttribute @Valid Jurusan jur) {
        dao.save(jur);
        return new RedirectView("daftar");
    }

    @RequestMapping("/hapus-{id}")
    public RedirectView prosesHapusJurusan(@PathVariable("id") String id) {
        dao.delete(id);
        return new RedirectView("daftar");
    }

}
