package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.service.ReviewService.ReviewCommandService;
import umc.study.validation.annotation.ExistMember;
import umc.study.validation.annotation.ExistMission;
import umc.study.validation.annotation.ExistRestaurant;
import umc.study.web.dto.review.ReviewRequestDTO;
import umc.study.web.dto.review.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;
    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.AddResultDTO> add(@ExistMember @RequestParam(value = "memberId", required = true) Long member_id,
                                                           @ExistRestaurant @RequestParam(value = "restaurantId", required = true) Long restaurant_id,
                                                           @RequestBody ReviewRequestDTO.AddDto request){
        Review review = reviewCommandService.addReview(member_id, restaurant_id, request);
        return ApiResponse.onSuccess(ReviewConverter.toAddResultDTO(review));
    }

}
