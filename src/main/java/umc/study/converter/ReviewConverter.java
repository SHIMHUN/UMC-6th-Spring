package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.web.dto.review.ReviewRequestDTO;
import umc.study.web.dto.review.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {
    public static Review toReview(ReviewRequestDTO.AddDto request){
        return Review.builder()
                .body(request.getBody())
                .star(request.getStar())
                .build();
    }
    public static ReviewResponseDTO.AddResultDTO toAddResultDTO(Review review){
        return ReviewResponseDTO.AddResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static ReviewResponseDTO.UserReviewPreviewListDTO toUserReviewPreviewListDTO(Page<Review> reviews){
        return ReviewConverter.userReviewPreviewListDTO(reviews);
    }

//    public static ReviewResponseDTO.UserReviewPreviewListDTO AddUserPreviewListDTO(Re){
//        return ReviewResponseDTO.UserReviewPreviewListDTO.builder()
//                .reviewList()
//    }
//
//    public static List<ReviewResponseDTO.ReviewPreviewDTO> toReviewPreviewDTO(Review review){
//        return review.getReviewList().stream().map(r ->
//                        ReviewResponseDTO.ReviewPreviewDTO.builder()
//                                .star(r.getStar())
//                                .body(r.getBody())
//                                .createdAt(r.getCreatedAt())
//                                .build())
//                .toList();
//    }

    public static ReviewResponseDTO.ReviewPreviewDTO reviewPreviewDTO(Review review){
        return ReviewResponseDTO.ReviewPreviewDTO.builder()
                .body(review.getBody())
                .star(review.getStar())
                .createdAt(review.getCreatedAt().toLocalDate().atStartOfDay())
                .build();
    }

    public static ReviewResponseDTO.UserReviewPreviewListDTO userReviewPreviewListDTO(Page<Review> reviewList){
        List<ReviewResponseDTO.ReviewPreviewDTO> reviewPreviewDTOList = reviewList.stream()
                .map(ReviewConverter::reviewPreviewDTO).collect(Collectors.toList());

        return ReviewResponseDTO.UserReviewPreviewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreviewDTOList.size())
                .reviewList(reviewPreviewDTOList)
                .build();
    }
}
