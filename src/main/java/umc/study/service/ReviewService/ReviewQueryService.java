package umc.study.service.ReviewService;

import org.springframework.data.domain.Page;
import umc.study.domain.Member;
import umc.study.domain.Review;

import java.util.Optional;

public interface ReviewQueryService {

    Optional<Member> findMember(Long id);

    Page<Review> getReviewList(Long memberId, Integer page);
}
