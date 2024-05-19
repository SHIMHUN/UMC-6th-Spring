package umc.study.service.MemberMission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.TempHandler;
import umc.study.converter.MemberMissionConverter;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService{
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    @Override
    public MemberMission challengeMission(Long member_id, Long mission_id) {
        Member member = memberRepository.findById(member_id).orElseThrow(() -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(mission_id).orElseThrow(() -> new TempHandler(ErrorStatus.MISSION_NOT_FOUND));
        MemberMission memberMission = MemberMissionConverter.toMemberMission();
        memberMission.setStatus(MissionStatus.CHALLENGING);
        memberMission.setMember(member);
        memberMission.setMission(mission);

        return memberMissionRepository.save(memberMission);
//          return null;
    }
}
