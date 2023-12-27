package neo.nae.dododok.core.user.repo;

import neo.nae.dododok.core.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
