package fullstackreview.demo.controllers;


import fullstackreview.demo.repositories.EditorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class EditorController {

    @Resource
    private EditorRepository editorRepo;

    @RequestMapping("/editors")
    public String displayEditors(Model model){
        model.addAttribute("editors", editorRepo.findAll());
        return "editorsView";
    }

}
