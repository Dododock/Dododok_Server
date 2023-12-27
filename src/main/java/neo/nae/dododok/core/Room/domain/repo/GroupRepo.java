package neo.nae.dododok.core.Room.domain.repo;

import neo.nae.dododok.core.Room.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepo extends JpaRepository<Group, Long> {
}
