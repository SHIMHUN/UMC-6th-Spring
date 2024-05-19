package umc.study.web.dto.mission;

import lombok.Getter;

public class MissionRequestDTO {
    @Getter
    public static class AddDto{
        Integer point;
        Integer foodPrice;
    }
}
