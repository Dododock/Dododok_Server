package neo.nae.dododok.core.auth.presentation;

import lombok.RequiredArgsConstructor;
import neo.nae.dododok.core.auth.service.BsmOauthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("oauth")
public class AuthController {
	private final BsmOauthService bsmOauthService;

	@PostMapping("bsm")
	public String createBsmOauth(@RequestParam String authCode) {
		return bsmOauthService.createOrUpdateUser(authCode);
	}
}
