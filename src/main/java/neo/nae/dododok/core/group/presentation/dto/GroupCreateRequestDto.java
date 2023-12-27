package neo.nae.dododok.core.group.presentation.dto;

import neo.nae.dododok.core.user.User;
import neo.nae.dododok.core.group.domain.Group;

import java.time.LocalDate;

public record GroupCreateRequestDto(
		String groupName,
		String simpleDescription,
		Integer memberCount,
		String schedule,
		String description,
		LocalDate due
) {
	public Group toEntity() {
		return Group.builder()
				.groupName(groupName)
				.simpleDescription(simpleDescription)
				.memberCount(memberCount)
				.schedule(schedule)
				.description(description)
				.due(due)
				.build();
	}
}
