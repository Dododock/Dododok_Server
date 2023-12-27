package neo.nae.dododok.core.group.presentation;

import lombok.RequiredArgsConstructor;
import neo.nae.dododok.core.auth.service.AuthService;
import neo.nae.dododok.core.group.domain.Group;
import neo.nae.dododok.core.group.presentation.dto.GroupCreateRequestDto;
import neo.nae.dododok.core.group.presentation.dto.GroupResponseDto;
import neo.nae.dododok.core.group.presentation.dto.SimpleGroupResponseDto;
import neo.nae.dododok.core.group.service.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("group")
public class GroupController {
	private final GroupService groupService;
	private final AuthService authService;

	@PostMapping("/create")
	public GroupResponseDto createGroup(@RequestBody GroupCreateRequestDto requestDto) {
		Group group = groupService.createGroup(requestDto.toEntity(), authService.getLoginUser());
		return new GroupResponseDto(group);
	}

	@GetMapping("/find/{id}")
	public GroupResponseDto findOne(@PathVariable Long id) {
		return new GroupResponseDto(groupService.findOne(id));
	}

	@GetMapping("/find/all")
	public List<SimpleGroupResponseDto> findAll() {
		return SimpleGroupResponseDto.of(groupService.findAll());
	}

	@GetMapping("/find/my")
	public List<SimpleGroupResponseDto> findMy() {
		return SimpleGroupResponseDto.of(groupService.findMy(authService.getLoginUser()));
	}

	@PutMapping("/join/{id}")
	public void join(@PathVariable Long id) {
		groupService.join(authService.getLoginUser(), id);
	}
}
