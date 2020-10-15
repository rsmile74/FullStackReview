package fullstackreview.demo.controllers;



import fullstackreview.demo.models.Magazine;
import fullstackreview.demo.repositories.MagazineRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Optional;

@Controller
public class MagazineController {

    @Resource
    private MagazineRepository magazineRepo;

    @RequestMapping("/magazines")
    public String displayMagazines(Model model){
        model.addAttribute("magazines", magazineRepo.findAll());
        return "magazinesView";

    }

    @RequestMapping("/magazines/{id}")
    public String displaySingleMagazine(@PathVariable long id, Model model){
        Optional<Magazine> retrievedMagazine = magazineRepo.findById(id);
        Magazine foundMagazine = retrievedMagazine.get();
        model.addAttribute("magazine", foundMagazine);
        return "magazineView";
    }
}
