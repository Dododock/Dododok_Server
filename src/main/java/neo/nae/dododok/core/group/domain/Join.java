package neo.nae.dododok.core.group.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import neo.nae.dododok.core.user.User;

@Entity
@Getter
@Table(name = "TBL_JOIN")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Join {

	@Id
	@ManyToOne
	@JoinColumn(name = "GROUP_ID", referencedColumnName = "GROUP_ID")
	private Group group;

	@Id
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	public Join(Group group, User user) {
		this.group = group;
		this.user = user;
	}
}
