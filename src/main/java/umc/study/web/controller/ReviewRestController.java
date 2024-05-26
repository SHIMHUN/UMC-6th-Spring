package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.service.ReviewService.ReviewCommandService;
import umc.study.service.ReviewService.ReviewQueryService;
import umc.study.validation.annotation.ExistMember;
import umc.study.validation.annotation.ExistMission;
import umc.study.validation.annotation.ExistRestaurant;
import umc.study.web.dto.review.ReviewRequestDTO;
import umc.study.web.dto.review.ReviewResponseDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;
    private final ReviewQueryService reviewQueryService;
    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.AddResultDTO> add(@ExistMember @RequestParam(value = "memberId", required = true) Long member_id,
                                                           @ExistRestaurant @RequestParam(value = "restaurantId", required = true) Long restaurant_id,
                                                           @RequestBody ReviewRequestDTO.AddDto request){
        Review review = reviewCommandService.addReview(member_id, restaurant_id, request);
        return ApiResponse.onSuccess(ReviewConverter.toAddResultDTO(review));
    }

    @GetMapping("/{memberId}/reviews")
    @Operation(summary = "특정 멤버의 리뷰 목록 조회 API", description = "특정 멤버의 리뷰들의 목록을 조회하는 API 이고, 페이징을 포함한다. query string으로 page 번호를 주세요.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "멤버의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ApiResponse<ReviewResponseDTO.UserReviewPreviewListDTO> getReviewList(@PathVariable(name = "memberId") Long memberId,
                                                                                 @RequestParam(name = "page") Integer page){
        Page<Review> reviewList = reviewQueryService.getReviewList(memberId, page);
        List<Review> reviews = reviewList.getContent();

//        for (Review review : reviews) {
//            System.out.println(review); // 또는 리뷰의 필드를 출력하거나 포맷팅하여 출력합니다.
//        }
//
//        System.out.println("페이지 정보: ");
//        System.out.println("총 리뷰 수: " + reviewList.getTotalElements());
//        System.out.println("현재 페이지: " + (reviewList.getNumber() + 1)); // 0부터 시작하므로 1을 더해줍니다.
//        System.out.println("페이지당 리뷰 수: " + reviewList.getSize());
//        System.out.println("전체 페이지 수: " + reviewList.getTotalPages());
//        System.out.println("이전 페이지 존재 여부: " + reviewList.hasPrevious());
//        System.out.println("다음 페이지 존재 여부: " + reviewList.hasNext());
//        return null;
         return ApiResponse.onSuccess(ReviewConverter.toUserReviewPreviewListDTO(reviewList));
    }


}
