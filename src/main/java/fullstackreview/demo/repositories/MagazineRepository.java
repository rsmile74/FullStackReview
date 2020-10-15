package fullstackreview.demo.repositories;

import fullstackreview.demo.models.Magazine;
import org.springframework.data.repository.CrudRepository;

public interface MagazineRepository extends CrudRepository<Magazine, Long> {
}
