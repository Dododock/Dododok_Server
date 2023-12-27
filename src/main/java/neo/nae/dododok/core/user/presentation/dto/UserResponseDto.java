package neo.nae.dododok.core.user.presentation.dto;

import neo.nae.dododok.core.user.User;

public record UserResponseDto(
		String nickname,
		String profileUrl
) {
	public UserResponseDto(User user) {
		this(user.getNickname(), user.getProfileUrl());
	}
}
