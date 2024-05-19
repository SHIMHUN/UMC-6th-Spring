package umc.study.converter;

import umc.study.domain.Review;
import umc.study.web.dto.review.ReviewRequestDTO;
import umc.study.web.dto.review.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {
    public static ReviewResponseDTO.AddResultDTO toAddResultDTO(Review review){
        return ReviewResponseDTO.AddResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
//    toAddResultDTO(Review);
    public static Review toReview(ReviewRequestDTO.AddDto request){
        return Review.builder()
                .body(request.getBody())
                .star(request.getStar())
                .build();
    }
}
