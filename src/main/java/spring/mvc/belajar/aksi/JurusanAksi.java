/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.mvc.belajar.aksi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.mvc.belajar.dao.JurusanDao;

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

}
