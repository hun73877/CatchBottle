package com.season.winter.liquor.liquorInfo


enum class WhiskyType(
    val type: Int,
    val roleKo: String,
    val roleEn: String,
) {
    SingleMalt(
        0,
        "싱글 몰트",
        "Single Malt"
    ),
    Bourbon(
        1,
        "버번",
        "Bourbon"
    ),
    Rye(
        2,
        "라이",
        "Rye"
    ),
    Blended(
        3,
        "블랜디드", // 혼합주
        "Blended"
    ),
    Sherry(
        4,
        "쉐리",
        "Sherry"
    ),
    Peat(
        5,
        "피트",
        "Sherry"
    ),
}