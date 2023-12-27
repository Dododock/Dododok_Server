package neo.nae.dododok.core.auth.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import neo.nae.dododok.core.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenProvider {
	@Value("${JWT_SECRET}")
	private String SECRET_KEY;

	public String newToken(User user) {
		return generateToken(String.valueOf(user.getUserCode()));
	}

	private String generateToken(String userCode) {
		return Jwts.builder()
				.claim("authId", userCode)
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY)
				.compact();
	}
}
