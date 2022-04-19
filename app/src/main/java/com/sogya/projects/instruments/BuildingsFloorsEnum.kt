package com.sogya.projects.instruments

import com.sogya.projects.R

enum class BuildingsFloorsEnums(
    val firstFloorResource: Int,
    val secondFloorResource: Int,
    val thirdFloorResource: Int? = null,
    val fourFloorResource: Int? = null,
    val fiveFloorResource: Int? = null,
    val sixFloorResource: Int? = null
) {
    FIRST(
        R.drawable.first_floor_six_building,
        R.drawable.second_floor_six_building,
        R.drawable.third_floor_six_building
    ),
    SECOND(R.drawable.first_floor_second_building, R.drawable.second_floor_second_building),
    THIRD(
        R.drawable.first_floor_third_building,
        R.drawable.second_floor_third_building,
        R.drawable.third_floor_third_building,
        R.drawable.four_floor_third_building
    ),
    FIVE(
        R.drawable.first_floor_five_building,
        R.drawable.second_floor_five_building,
        R.drawable.third_floor_five_building,
        R.drawable.four_floor_five_building,
        R.drawable.five_floor_five_building,
        R.drawable.six_floor_five_building
    ),
    SIX(
        R.drawable.first_floor_six_building,
        R.drawable.second_floor_six_building,
        R.drawable.third_floor_six_building
    );

}