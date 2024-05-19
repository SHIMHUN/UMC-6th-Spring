package umc.study.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.Member;
import umc.study.repository.MemberRepository;
import umc.study.web.dto.member.MemberRequestDTO;

public interface MemberCommandService{
    Member joinMember(MemberRequestDTO.JoinDto request);
}
