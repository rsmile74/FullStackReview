package fullstackreview.demo;


import fullstackreview.demo.models.Editor;
import fullstackreview.demo.models.Magazine;
import fullstackreview.demo.models.Office;
import fullstackreview.demo.repositories.EditorRepository;
import fullstackreview.demo.repositories.MagazineRepository;
import fullstackreview.demo.repositories.OfficeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class) //will know to finding rather finding separate web test
@WebMvcTest
public class WebLayerTest {

    @MockBean
    private OfficeRepository officeRepo;

    @MockBean
    private MagazineRepository magazineRepo;

    @MockBean
    private EditorRepository editorRepo;

    @Autowired
    private MockMvc mockMvc; //mocking the user behavior as the go out and interact with the web application

    @Test
    public void headquartersShouldBeOkAndReturnHeadquartersViewWithHeadquartersModelAttribute() throws Exception {
        mockMvc.perform(get("/office"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("officeView"))
                .andExpect(model().attributeExists("office"));

    }

    @Test
    public void magazineShouldBeOkAndReturnMagazineViewWithMagazineModelAttribute() throws Exception {
        mockMvc.perform(get("/magazines"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("magazinesView"))
                .andExpect(model().attributeExists("magazines"));

    }

    @Test
    public void editorShouldBeOkAndReturnEditorViewWithEditorModelAttribute() throws Exception {
        mockMvc.perform(get("/editors"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("editorsView"))
                .andExpect(model().attributeExists("editors"));

    }

    @Test
    public void shouldBeOkForASingleOfficeEndpointWithOfficeViewAndOfficeModelAttribute() throws Exception {
        Office testOffice = new Office("NewYork");
        when(officeRepo.findOfficeByLocation("NewYork")).thenReturn(testOffice);
        mockMvc.perform(get("/offices/NewYork"))
                .andExpect(status().isOk())
                .andExpect(view().name("officeView"))
                .andExpect(model().attributeExists("office"));


    }

    @Test
    public void shouldBeOkForASingleMagazineEndpointWithMagazineViewAndMagazineModelAttribute() throws Exception {
        Office testOffice = new Office("NewYork");
        Editor testEditor = new Editor("First", "Last");
        Magazine testMagazine = new Magazine("Title", "Description", testOffice, testEditor);
        when(magazineRepo.findById(1L)).thenReturn(java.util.Optional.of(testMagazine));
        mockMvc.perform(get("/magazines/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("magazineView"))
                .andExpect(model().attributeExists("magazine"));


    }
}


