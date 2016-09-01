package spring.mvc.belajar.aksi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HaloController {

    @RequestMapping("/halo")
    public ModelMap halo() {
        ModelMap map = new ModelMap();
        map.addAttribute("message", "Halo, nama saya dimas maryanto");
        return map;
    }
}
