package fullstackreview.demo.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Magazine {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private String images;
    @ManyToOne//many magazines to one headquarter, focus on the entity first then the data
    private Office office;
    @ManyToMany //editors can have many magazines so you can do many to many
    private Collection<Editor> editors;//collection of editors, bring in the import

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Office getOffice() {
        return office;
    }

    public String getImage(){
        return images;
    }

    public Collection<Editor> getEditors() {
        return editors;
    }


    public Magazine() { //default

    }

    public Magazine(String title, String description, String images, Office office, Editor... editors) { //using the VarArgs operator to list as many authors as you want
        this.title = title;
        this.description=description;
        this.images=images;
        this.office = office;
        this.editors = new ArrayList<>(Arrays.asList(editors));//pass in the collection of editors as an array list

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magazine magazine = (Magazine) o;
        return Objects.equals(id, magazine.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
