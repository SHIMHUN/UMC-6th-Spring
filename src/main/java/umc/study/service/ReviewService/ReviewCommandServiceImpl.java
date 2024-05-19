package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.TempHandler;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Member;
import umc.study.domain.Restaurant;
import umc.study.domain.Review;
import umc.study.repository.MemberRepository;
import umc.study.repository.RestaurantRepository;
import umc.study.repository.ReviewRepository;
import umc.study.web.dto.review.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
//@Transactional(readOnly = true)
public class ReviewCommandServiceImpl implements ReviewCommandService{
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final MemberRepository memberRepository;
    @Override
    public Review addReview(Long member_id, Long restaurant_id, ReviewRequestDTO.AddDto request){
        Review review = ReviewConverter.toReview(request);

        Member member = memberRepository.findById(member_id).orElseThrow(() -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Restaurant restaurant = restaurantRepository.findById(restaurant_id).orElseThrow(() -> new TempHandler(ErrorStatus.RESTAURANT_NOT_FOUND));
        review.setMember(member);
        review.setRestaurant(restaurant);
//        member.getReviewList().add(review);
//        restaurant.getReviewList().add(review);
        return reviewRepository.save(review);
    }

//    @Override
//    public Boolean existsByMemberIdAndRestaurantId(Long memberId, Long restaurantId) {
//        return memberMissionRepository.existsByMemberIdAndMissionId(memberId, restaurantId);
////        return null;
//    }


//    private final MemberMissionRepository memberMissionRepository;
//    private final ReviewRepository reviewRepository;
//    @Override
//    @Transactional
//    public Review addReview(ReviewRequestDTO.addDto request, Long missionId) {
//
//
//        //유저 미션 완료 여부
//        Long memberId = request.getMember_id();
//        Optional<MemberMission> findById = memberMissionRepository.findByMemberIdAndMissionIdAndStatus(memberId, missionId, MissionStatus.CHALLENGING);
////        if (findById.isPresent()){
//            //미션을 완료했다면 리뷰 저장
//            Review newReview = ReviewConverter.toReview(request);
//            return reviewRepository.save(newReview);
////        }
//
//    }
//    //해당 유저가 미션 완료했는지 확인
//
//
//    //미션을 완료했다면 리뷰 저장
}
