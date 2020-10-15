package fullstackreview.demo;


import fullstackreview.demo.models.Editor;
import fullstackreview.demo.models.Magazine;
import fullstackreview.demo.models.Office;
import fullstackreview.demo.repositories.EditorRepository;
import fullstackreview.demo.repositories.MagazineRepository;
import fullstackreview.demo.repositories.OfficeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {

    @Resource
    private OfficeRepository officeRepo;

    @Resource
    private EditorRepository editorRepo;

    @Resource
    private MagazineRepository magazineRepo;


    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        Office newyork = new Office("NewYork");
        Office losAngeles = new Office("LosAngeles");
        officeRepo.save(newyork);
        officeRepo.save(losAngeles);

        Editor wintour = new Editor("Anna", "Wintour","./images/AnnaWintour.jpg");
        Editor garcia = new Editor("Nina", "Garcia","./images/NinaGarcia.jpg");
        Editor brown = new Editor("Laura", "Brown","./images/LauraBrown.jpg");
        Editor nasr = new Editor("Samira", "Nasr","./images/SamiraNasr.jpg");
        Editor bedard = new Editor("Matthew", "Bedard","./images/MatthewBedard.jpg");
        Editor barry = new Editor("Samantha", "Barry ","./images/SamanthaBarry.jpg");
        editorRepo.save(wintour);
        editorRepo.save(garcia);
        editorRepo.save(brown);
        editorRepo.save(nasr);
        editorRepo.save(bedard);
        editorRepo.save(barry);


        Magazine vogue = new Magazine("Vogue "  , " is one of the best leading magazines in the fashion industry has the best September issue ", "/images/AnnaWintour.jpg", newyork, wintour);
        Magazine elle = new Magazine("Elle", "celebrates style of all aspects very innovative for today's industry", "/images/NinaGarcia.jpg", newyork, garcia);
        Magazine instyle = new Magazine("InStyle", "not only focuses on beauty but also home decor, an philanthropy", "/images/LauraBrown.jpg", newyork, brown);
        Magazine harpersbazzar = new Magazine("Harper's Bazaar", "Is one of the oldest fashion magazine founded in 1867, is started off newspaper catering to middle and upperclass women", "/images/SamiraNasr.jpg", newyork, nasr);
        Magazine flaunt = new Magazine("Flaunt", "a very trendy magazine that is really geared to the millennials ", "/images/MatthewBedard.jpg", losAngeles, bedard);
        Magazine glamour = new Magazine("Glamour", "This magazine shows a 360-dergree perspective of life: relationships, fashion, beauty, pop-culture, sex health and travel. ", "/images/SamanthaBarry.jpg", newyork, barry);
        magazineRepo.save(vogue);
        magazineRepo.save(elle);
        magazineRepo.save(instyle);
        magazineRepo.save(harpersbazzar);
        magazineRepo.save(flaunt);
        magazineRepo.save(glamour);


    }
}
