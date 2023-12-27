package neo.nae.dododok.core.auth.service;

import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import neo.nae.dododok.core.auth.domain.repo.AuthRepo;
import neo.nae.dododok.core.user.User;
import neo.nae.dododok.core.user.repo.UserRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {
	private final UserRepo userRepo;
	private final AuthRepo authRepo;

	@Value("${JWT_SECRET}")
	String SECRET_KEY;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		if(request.getMethod().equals("OPTIONS")) {
			return true;
		}

		String token = request.getHeader("Authorization");

		System.out.println("token asdfasdf " + token);
		if (token == null || token.isEmpty()) {
			return true;
		}

		Long userId = getUserPk(token);
		User user = userRepo.findById(userId)
				//TODO ERROR
				.orElseThrow(() -> new RuntimeException("user not found"));

		authRepo.save(user);

		return true;
	}

	public Long getUserPk(String token) {
		return Long.decode((String) Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().get("authId"));
	}
}
