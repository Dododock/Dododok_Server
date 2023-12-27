package neo.nae.dododok.core.Room.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TBL_GROUP")
public class Group {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String groupName;
	private String simpleDescription;
	private String memberCount;
	private String schedule;
	private String description;
	private String due;

	//TODO 생성 유저랑 참여자
}
