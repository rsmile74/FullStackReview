package fullstackreview.demo.repositories;

import fullstackreview.demo.models.Editor;
import org.springframework.data.repository.CrudRepository;

public interface EditorRepository extends CrudRepository<Editor, Long> {
}
