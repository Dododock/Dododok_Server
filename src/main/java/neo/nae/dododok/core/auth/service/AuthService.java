package neo.nae.dododok.core.auth.service;

import lombok.RequiredArgsConstructor;
import neo.nae.dododok.core.user.User;
import neo.nae.dododok.core.auth.domain.repo.AuthRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
	private final AuthRepo authRepo;

	public User getLoginUser() {
		return authRepo.findLoginUser();
	}
}
