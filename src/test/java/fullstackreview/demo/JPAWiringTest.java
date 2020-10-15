package fullstackreview.demo;


import fullstackreview.demo.models.Editor;
import fullstackreview.demo.models.Magazine;
import fullstackreview.demo.models.Office;

import fullstackreview.demo.repositories.EditorRepository;
import fullstackreview.demo.repositories.MagazineRepository;
import fullstackreview.demo.repositories.OfficeRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JPAWiringTest {

    @Autowired
    private TestEntityManager entityManager; //flush and clear

    @Autowired
    private OfficeRepository officeRepo;

    @Autowired
    private EditorRepository editorRepo; //creating an interface
    @Autowired
    private MagazineRepository magazineRepo; //creating an interface

    @Test
    public void locationShouldHaveAListOfTheBiggestMagazines(){
        Office testOffice = new Office("Test Location");//build a new class called headquarters and build out the constructor
        Office testOffice2 = new Office("Test Location2");
        Editor testEditor1 = new Editor("Test firstName", "Test lastName");
        Magazine testMagazine = new Magazine("Title", "Description", testOffice, testEditor1);
        Magazine testMagazine2 = new Magazine("Title", "Description", testOffice2, testEditor1);
        //each table that we create we need to save the items to the database and the CRUD Repo will do that so it will need a Repository



        editorRepo.save(testEditor1);
        officeRepo.save(testOffice);
        officeRepo.save(testOffice2);
        magazineRepo.save(testMagazine);
        magazineRepo.save(testMagazine2);

        entityManager.flush(); //test energy manager for flush and clear
        entityManager.clear();

        Optional<Office> retrievedOfficeOpt = officeRepo.findById(testOffice.getId()); //when you use the findById it is optional, so you can use the Optional operator, since this does not have a particular ID create a getter.
        Office retrievedOffice = retrievedOfficeOpt.get();//need to add the .get which is a method of optional
        assertThat(retrievedOffice.getMagazines()).contains(testMagazine);

    }
    @Test
    public void magazineShouldBeAbleToHaveMultipleEditors(){
        Office testOffice = new Office("Test Location");
        Editor testEditor1 = new Editor("Test firstName", "Test lastName");
        Editor testEditor2 = new Editor("Test firstName2", "Test lastName2");
        Magazine testMagazine1 = new Magazine("Title", "Description", testOffice, testEditor1, testEditor2);
        Magazine testMagazine2 = new Magazine("Title", "Description", testOffice, testEditor1);
        Magazine testMagazine3 = new Magazine("Title", "Description", testOffice, testEditor2);
        officeRepo.save(testOffice);
        editorRepo.save(testEditor1);
        editorRepo.save(testEditor2);
        magazineRepo.save(testMagazine1);
        magazineRepo.save(testMagazine2);
        magazineRepo.save(testMagazine3);

        entityManager.flush(); //test energy manager for flush and clear
        entityManager.clear();

        Magazine retrievedMagazine = magazineRepo.findById(testMagazine1.getId()).get();
        Editor retrievedEditor1 = editorRepo.findById(testEditor1.getId()).get();
        Editor retrievedEditor2 = editorRepo.findById(testEditor2.getId()).get();
        assertThat(retrievedMagazine.getEditors()).contains(testEditor1,testEditor2);

    }

}
