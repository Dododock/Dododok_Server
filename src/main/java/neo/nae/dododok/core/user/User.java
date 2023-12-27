package neo.nae.dododok.core.user;

import jakarta.persistence.*;
import lombok.*;
import neo.nae.dododok.core.group.domain.Join;

import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TBL_USER")
public class User {
	@Id
	@Column(name = "USER_ID")
	private Long userCode;
	private String nickname;
	private String email;
	private String profileUrl;

	@OneToMany(
			mappedBy = "user",
			fetch = FetchType.LAZY
	)
	private List<Join> groups;

}
