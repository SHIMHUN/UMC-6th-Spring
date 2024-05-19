package umc.study.service.RestaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.TempHandler;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.domain.Restaurant;
import umc.study.repository.MissionRepository;
import umc.study.repository.RestaurantRepository;
import umc.study.web.dto.mission.MissionRequestDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantCommandServiceImpl implements RestaurantCommandService{
    private final MissionRepository missionRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public Mission addMission(Long restaurant_id, MissionRequestDTO.AddDto request){
        Mission mission = MissionConverter.toMission(request);
        Restaurant restaurant = restaurantRepository.findById(restaurant_id).orElseThrow(() -> new TempHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        return missionRepository.save(mission);
    }
}
