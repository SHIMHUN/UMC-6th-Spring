package umc.study.converter;

import umc.study.domain.FoodCategory;
import umc.study.domain.mapping.MemberFoodCategory;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {
    public static List<MemberFoodCategory> toMemberPreferList(List<FoodCategory> foodCategoryList){

        return foodCategoryList.stream()
                .map(foodCategory ->
                        MemberFoodCategory.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
