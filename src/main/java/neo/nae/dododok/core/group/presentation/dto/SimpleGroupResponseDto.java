package neo.nae.dododok.core.group.presentation.dto;

import lombok.Getter;
import neo.nae.dododok.core.group.domain.Group;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Getter
public class SimpleGroupResponseDto {
	private final Long id;
	private final String groupName;
	private final LocalDate due;
	private final Integer currentMemberCount;
	private final Integer memberCount;

	public SimpleGroupResponseDto(Group group) {
		this.id = group.getId();
		this.groupName = group.getGroupName();
		this.due = group.getDue();
		this.currentMemberCount = group.getMemberCount();
		this.memberCount = group.getMembers().size();
	}

	public static List<SimpleGroupResponseDto> of(List<Group> groups) {
		List<SimpleGroupResponseDto> list = new java.util.ArrayList<>(groups.stream()
				.filter(group -> group.getMemberCount() > group.getMembers().size())
				.map(SimpleGroupResponseDto::new)
				.toList());

		list.sort((SimpleGroupResponseDto g1, SimpleGroupResponseDto g2) -> g2.currentMemberCount - g1.currentMemberCount);


		return list;
	}
}
