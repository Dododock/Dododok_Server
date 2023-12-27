package neo.nae.dododok.core.group.domain;

import jakarta.persistence.*;
import lombok.*;
import neo.nae.dododok.core.user.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@Table(name = "TBL_GROUP")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Group {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GROUP_ID")
	private Long id;
	private String groupName;
	private String simpleDescription;
	private Integer memberCount;
	private String schedule;
	private String description;
	private LocalDate due;

	@OneToOne
	@JoinColumn(name = "host", referencedColumnName = "USER_ID")
	private User host;

	@OneToMany(
			mappedBy = "group",
			fetch = FetchType.LAZY
	)
	@Builder.Default
	private List<Join> members = new ArrayList<>();

	public void updateHost(User host) {
		this.host = host;
	}

	public List<User> getMembers() {
		if (members == null) {
			return null;
		}

		return members.stream()
				.map(Join::getUser)
				.toList();
	}
}
