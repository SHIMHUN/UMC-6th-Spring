package umc.study.web.dto.review;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {
    @Getter
    public static class AddDto{
        String body;
        Float star;
    }
}
