package neo.nae.dododok.core.auth.infra;

import neo.nae.dododok.core.auth.domain.repo.AuthRepo;
import neo.nae.dododok.core.user.User;
import org.springframework.stereotype.Component;

@Component
public class AuthRepoImpl implements AuthRepo {
	private User user;

	@Override
	public void save(User user) {
		this.user = user;
	}

	@Override
	public User findLoginUser() {
		if (user == null) {
			throw new RuntimeException("user not login");
		}

		return this.user;
	}
}
