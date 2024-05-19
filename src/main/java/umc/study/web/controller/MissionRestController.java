package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberMissionConverter;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.MemberMission.MemberMissionCommandService;
import umc.study.web.dto.membermission.MemberMissionResponseDTO;
import umc.study.web.dto.mission.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionRestController {
    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/challenge")
    public ApiResponse<MemberMissionResponseDTO.AddResultDTO> add(@RequestParam(value = "missionId", required = true) Long mission_id,
                                                                  @RequestParam(value = "memberId", required = true) Long member_id){
        MemberMission memberMission = memberMissionCommandService.challengeMission(member_id, mission_id);
        return ApiResponse.onSuccess(MemberMissionConverter.toChallengeResultDTO(memberMission));
    }
}
