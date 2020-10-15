package fullstackreview.demo.repositories;

import fullstackreview.demo.models.Office;
import org.springframework.data.repository.CrudRepository;

public interface OfficeRepository extends CrudRepository<Office, Long> {
    Office findOfficeByLocation(String location);
}
