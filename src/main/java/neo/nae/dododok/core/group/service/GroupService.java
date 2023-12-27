package neo.nae.dododok.core.group.service;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import neo.nae.dododok.core.group.domain.Group;
import neo.nae.dododok.core.group.domain.Join;
import neo.nae.dododok.core.group.domain.repo.GroupRepo;
import neo.nae.dododok.core.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class GroupService {
	private final GroupRepo groupRepo;
	private final EntityManager em;

	public Group createGroup(Group group, User loginUser) {
		groupRepo.save(group);
		group.updateHost(loginUser);
		return group;
	}

	public Group findOne(Long id) {
		return groupRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("group not found"));
	}

	public List<Group> findAll() {
		return groupRepo.findAll();
	}

	public List<Group> findMy(User user) {
		List<Group> myGroup = groupRepo.findByHost(user);
		List<Group> joinGroup = groupRepo.findJoinGroup(user);
		myGroup.addAll(joinGroup);

		return myGroup;
	}

	public void join(User user, Long groupId) {
		Group group = groupRepo.findById(groupId)
				.orElseThrow(() -> new RuntimeException("Group Not Found"));

		Join join = new Join(group, user);

		em.persist(join);
	}
}
