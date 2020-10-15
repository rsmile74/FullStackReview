package fullstackreview.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;


@Entity
public class Office {

    @Id
    @GeneratedValue
    private Long id;
    private String location;
    @OneToMany(mappedBy = "office") //mapped by office
    private Collection<Magazine> magazines;

    public Long getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public Collection<Magazine> getMagazines() { //method of behavior
        return magazines;
    }

    //default no args constructor required for jpa
    public Office() {

    }


    public Office(String location) {
        this.location = location;
    }


    @Override
    public boolean equals(Object o) {  //using the equals and hashtag and code, need to autogenerate code
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Office that = (Office) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
