package neo.nae.dododok.core.auth.domain.repo;

import neo.nae.dododok.core.user.User;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepo {
	void save(User user);
	User findLoginUser();
}
