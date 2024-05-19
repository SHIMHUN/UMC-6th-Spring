package umc.study.service.ReviewService;

import umc.study.domain.Review;
import umc.study.web.dto.member.MemberRequestDTO;
import umc.study.web.dto.review.ReviewRequestDTO;

public interface ReviewCommandService {
    public Review addReview(Long member_id, Long restaurant_id, ReviewRequestDTO.AddDto request);
//    public Boolean existsByMemberIdAndRestaurantId(Long memberId, Long restaurantId);
}
