package fullstackreview.demo.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Editor {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String images;

    @ManyToMany(mappedBy = "editors")
    private Collection<Magazine> magazines;

    public Long getId() {
        return id;
    }

    public Collection<Magazine> getMagazines(){
        return magazines;
    }

    public Editor(){ //default

    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getImage(){
        return images;
    }

    public Editor(String firstName, String lastName, String images) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.images=images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Editor editor = (Editor) o;
        return Objects.equals(id, editor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
