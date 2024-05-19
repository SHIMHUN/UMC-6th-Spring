package umc.study.converter;

import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.membermission.MemberMissionResponseDTO;

import java.time.LocalDateTime;

public class MemberMissionConverter {
    public static MemberMissionResponseDTO.AddResultDTO toChallengeResultDTO(MemberMission memberMission){
        return MemberMissionResponseDTO.AddResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();

    }

    public static MemberMission toMemberMission(){
        return MemberMission.builder().build();
    }
}
