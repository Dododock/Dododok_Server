package neo.nae.dododok.core.auth.service;

import leehj050211.bsmOauth.BsmOauth;
import leehj050211.bsmOauth.dto.resource.BsmUserResource;
import leehj050211.bsmOauth.exception.BsmOAuthCodeNotFoundException;
import leehj050211.bsmOauth.exception.BsmOAuthInvalidClientException;
import leehj050211.bsmOauth.exception.BsmOAuthTokenNotFoundException;
import lombok.RequiredArgsConstructor;
import neo.nae.dododok.core.user.User;
import neo.nae.dododok.core.user.repo.UserRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class BsmOauthService {
	private final UserRepo userRepo;
	private final TokenProvider tokenProvider;

	@Value("${BSM_CLIENT_ID}")
	String BSM_AUTH_CLIENT_ID;

	@Value("${BSM_SECRET_KEY}")
	String BSM_AUTH_CLIENT_SECRET;

	public String createOrUpdateUser(String authCode) {
		BsmOauth bsmOauth = new BsmOauth(BSM_AUTH_CLIENT_ID, BSM_AUTH_CLIENT_SECRET);
		String token = null;
		BsmUserResource resource;
		try {
			token = bsmOauth.getToken(authCode);
			resource = bsmOauth.getResource(token);
		} catch (IOException | BsmOAuthCodeNotFoundException | BsmOAuthInvalidClientException |
				 BsmOAuthTokenNotFoundException e) {
			throw new RuntimeException(e);
		}

		User newUser = User.builder()
				.userCode(resource.getUserCode())
				.nickname(resource.getNickname())
				.email(resource.getEmail())
				.profileUrl(resource.getProfileUrl())
				.build();

		User user = userRepo.save(newUser);

		return tokenProvider.newToken(user);
	}
}
