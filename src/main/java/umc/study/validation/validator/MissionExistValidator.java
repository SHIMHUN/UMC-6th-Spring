package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.service.ReviewService.ReviewCommandService;
import umc.study.validation.annotation.ExistMission;
import umc.study.web.dto.review.ReviewRequestDTO;

@Component
@RequiredArgsConstructor
public class MissionExistValidator implements ConstraintValidator<ExistMission, ReviewRequestDTO.AddDto> {
//    private final MemberMissionRepository memberMissionRepository;
    private final ReviewCommandService reviewCommandService;

    @Override
    public void initialize(ExistMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(ReviewRequestDTO.AddDto value, ConstraintValidatorContext context) {

//        boolean isValid = reviewCommandService.existsByMemberIdAndRestaurantId(value.getMember_id(), value.getRestaurant_id());
//        System.out.println("isValid = " + isValid);
//        if(!isValid){
//            context.disableDefaultConstraintViolation();
//            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_NOT_FOUND.toString()).addConstraintViolation();
//        }
//        return isValid;
        return true;
    }
}
