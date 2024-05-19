package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.web.dto.mission.MissionRequestDTO;
import umc.study.web.dto.mission.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {
    public static MissionResponseDTO.AddResultDTO toAddResultDTO(Mission mission){
        return MissionResponseDTO.AddResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static Mission toMission(MissionRequestDTO.AddDto request){
        return Mission.builder()
                .point(request.getPoint())
                .foodPrice(request.getFoodPrice())
                .build();
    }
}
