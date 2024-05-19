package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.domain.Restaurant;
import umc.study.service.RestaurantService.RestaurantCommandService;
import umc.study.validation.annotation.ExistRestaurant;
import umc.study.web.dto.mission.MissionRequestDTO;
import umc.study.web.dto.mission.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant")
public class RestaurantRestController {
    private final RestaurantCommandService restaurantCommandService;
    @PostMapping("/mission")
    public ApiResponse<MissionResponseDTO.AddResultDTO> addMission(@ExistRestaurant @RequestParam(value = "restaurantId", required = true) Long restaurant_id,
                                                                   @RequestBody MissionRequestDTO.AddDto request){
        Mission mission = restaurantCommandService.addMission(restaurant_id, request);
        return ApiResponse.onSuccess(MissionConverter.toAddResultDTO(mission));
    }
}
