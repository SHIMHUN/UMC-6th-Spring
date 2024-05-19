package umc.study.service.MemberMission;

import umc.study.domain.mapping.MemberMission;

public interface MemberMissionCommandService {
    public MemberMission challengeMission(Long member_id, Long mission_id);
}
