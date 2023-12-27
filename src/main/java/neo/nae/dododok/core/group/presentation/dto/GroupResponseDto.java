package neo.nae.dododok.core.group.presentation.dto;

import neo.nae.dododok.core.user.presentation.dto.UserResponseDto;
import neo.nae.dododok.core.group.domain.Group;

import java.time.LocalDate;
import java.util.List;

public record GroupResponseDto(
		Long id,
		UserResponseDto host,
		String groupName,
		String simpleDescription,
		Integer currentMemberCount,
		Integer memberCount,
		String schedule,
		String description,
		LocalDate due,
		List<UserResponseDto> members
) {
	public GroupResponseDto(Group group) {
		this(
				group.getId(),
				new UserResponseDto(group.getHost()),
				group.getGroupName(),
				group.getSimpleDescription(),
				group.getMembers().size(),
				group.getMemberCount(),
				group.getSchedule(),
				group.getSchedule(),
				group.getDue(),
				group.getMembers()
						.stream()
						.map(UserResponseDto::new)
						.toList()
		);
	}
}
