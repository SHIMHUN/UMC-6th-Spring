package umc.study.service.RestaurantService;

import umc.study.domain.Mission;
import umc.study.web.dto.mission.MissionRequestDTO;

public interface RestaurantCommandService {
    public Mission addMission(Long restaurant_id, MissionRequestDTO.AddDto request);
}
