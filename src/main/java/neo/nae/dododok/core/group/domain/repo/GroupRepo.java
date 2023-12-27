package neo.nae.dododok.core.group.domain.repo;

import neo.nae.dododok.core.group.domain.Group;
import neo.nae.dododok.core.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupRepo extends JpaRepository<Group, Long> {
	@Query("select g from Group g where g.host = :host")
	List<Group> findByHost(User host);

	@Query("select distinct g from Group g join fetch g.members a where a.user = :user")
	List<Group> findJoinGroup(User user);
}
