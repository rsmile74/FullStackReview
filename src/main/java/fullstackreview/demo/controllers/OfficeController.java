package fullstackreview.demo.controllers;

import fullstackreview.demo.models.Office;
import fullstackreview.demo.repositories.OfficeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class OfficeController {

    @Resource
    private OfficeRepository officeRepo;

    @RequestMapping({"/offices", "/", ""})//the 8080 will go to the headquarters template
    public String displayOffice(Model model){
        model.addAttribute("offices", officeRepo.findAll());
        return "officesView";

    }

    @GetMapping("/offices/{location}")
    public String displaysSingleOffice(@PathVariable String location, Model model){
        Office retrievedOffice = officeRepo.findOfficeByLocation(location);
        model.addAttribute("office",retrievedOffice);
                return "officeView";
    }

}
