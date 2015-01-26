package com.tony.examples.cxf;

/**
 * ERROR CODE
 */
public enum ERROR {
    // Common
    COMMON_INVALID_PARAM("1", "COMMON_INVALID_PARAM", 1),                   // 잘못된 파라미터로 에러가 발생했습니다.
    COMMON_UNKNOWN("2", "COMMON_UNKNOWN", 2),                               // 예기치 못한 오류가 발생했습니다.
    COMMON_BAD_REQUEST("3", "COMMON_BAD_REQUEST", 0),                       // 잘못된 요청입니다.
    COMMON_XML_PARSING_ERROR("4", "COMMON_XML_PARSING_ERROR", 2),           // XML 파싱에러입니다.
    COMMON_JSON_PARSING_ERROR("5", "COMMON_JSON_PARSING_ERROR", 2),         // JSON 파싱에러입니다.
    COMMON_SYSTEM_CHECKUP("6", "COMMON_SYSTEM_CHECKUP", 0),                 // 현재 시스템 점검중입니다.
    COMMON_AUTH_CHECK_FAIL("7", "COMMON_AUTH_CHECK_FAIL", 2),               // 인증 체크 오류가 발생했습니다.
    COMMON_APP_VER_NOTMATCH("8", "COMMON_APP_VER_NOTMATCH", 0),             // 앱 업그레이드가 필요합니다.
    COMMON_BLOCKED("9", "COMMON_BLOCKED", 0),                               // 요청 자체는 문제가 없지만, 의도적으로 처리 불가능하도록 된 상태입니다. (금칙어 사용 등)

    COMMON_USER_NOTFOUND("10", "COMMON_USER_NOTFOUND", 1),                  // 회원 정보가 없습니다.
    COMMON_CHERRY_NOTENOUGH("11", "COMMON_CHERRY_NOTENOUGH", 0),            // 체리가 부족합니다.
    COMMON_CLOVER_NOTENOUGH("12", "COMMON_CLOVER_NOTENOUGH", 0),            // 클로버가 부족합니다.
    COMMON_FP_NOTENOUGH("13", "COMMON_FP_NOTENOUGH", 0),                    // 친구 포인트가 부족합니다.
    COMMON_DIAMOND_NOTENOUGH("14", "COMMON_DIAMOND_NOTENOUGH", 0),          // 보석이 부족합니다.
    COMMON_ITEM_NOTENOUGH("15", "COMMON_ITEM_NOTENOUGH", 0),                  // 아이템이 부족합니다.
    COMMON_HAVI_NOTENOUGH("16", "COMMON_HAVI_NOTENOUGH", 0),                // 하비의 상자가 부족합니다.

    // 로그인
    LOGIN_INVALID_PARAM("20", "USER_INVALID_PARAM", 1),                     // 잘못된 파라미터로 에러가 발생했습니다.
    LOGIN_AUTH_CHECK_ERROR("21", "LOGIN_AUTH_CHECK_ERROR", 2),              // 로그인 인증 체크 오류가 발생했습니다.
    LOGIN_ALREADY_WITHDRAWAL("22", "USER_ALREADY_WITHDRAWAL", 2),           // 이미 탈퇴한 회원 입니다.
    LOGIN_ALREADY_BLOCK("23", "USER_ALREADY_BLOCK", 2),                     // 이미 차단된 회원 입니다.
    LOGIN_NICKNAME_DUPLICATION("24", "USER_NICKNAME_DUPLICATION", 1),       // 유저 닉네임이 중복되었습니다.
    LOGIN_NICKNAME_BLOCKWORD("25", "USER_NICKNAME_BLOCKWORD", 1),           // 유저 닉네임은 금칙어가 포함되어 있습니다.

    // 메시지
    MSG_INVALID_PARAM("30", "MSG_INVALID_PARAM", 0),                        // 잘못된 파라미터로 에러가 발생했습니다.
    MSG_NOTFOUND("31", "MSG_NOTFOUND", 0),                                  // 확인할 메시지가 없습니다.
    MSG_SEND_ERROR("32", "MSG_SEND_ERROR", 2),                              // 메세지 전송시 에러가 발생했습니다.
    MSG_RECV_DENY("33", "MSG_RECV_DENY", 0),                                // 상대방이 메시지 수신거부상태입니다.
    MSG_TARGET_USER_NOTFOUND("34", "MSG_TARGET_USER_NOTFOUND", 1),          // 메세지를 받는 대상 정보를 찾을 수 없습니다.
    MSG_SEND_COOL_TIME("35", "MSG_SEND_COOL_TIME", 0),                      // 아직 메시지를 보낼 수 있는 시간이 되지 않았습니다.

    // PLAY
    PLAY_INVALID_PARAM("40", "PLAY_INVALID_PARAM", 0),                     // 잘못된 파라미터로 에러가 발생했습니다.
    PLAY_INVALID_PLAYCODE("41", "PLAY_INVALID_PLAYCODE", 0),               // 잘못된 플레이코드로 에러가 발생했습니다.

    // 보상
    REWARD_INVALID_PARAM("50", "REWARD_INVALID_PARAM", 0),                 // 잘못된 파라미터로 에러가 발생했습니다.
    REWARD_ALREADY_PAID("51", "REWARD_ALREADY_PAID", 1),                   // 이미 보상을 지급받았습니다.

    // 구매
    PURCHASE_NOT_YET_COOLTIME("60", "PURCHASE_NOT_YET_COOLTIME", 0),       // 아직 구매 가능한 쿨타임이 지나지 않았습니다.

    // 미션
    MISSION_INVALID_PARAM("61", "MISSION_INVALID_PARAM", 0),               // 잘못된 파라미터로 에러가 발생했습니다.

    // 쿠폰
    COUPON_INVALID_PARAM("70", "COUPON_INVALID_PARAM", 1),                 // 잘못된 파라미터로 에러가 발생했습니다.
    COUPON_ALREADY_USED("71", "COUPON_ALREADY_USED", 0),                   // 이미 사용한 쿠폰 번호입니다.
    COUPON_INVALID_DATE("72", "COUPON_INVALID_DATE", 0),                   // 쿠폰의 유효기간이 만료되었습니다.
    COUPON_LIMIT_ERROR("73", "COUPON_LIMIT_ERROR", 0),                     // 쿠폰 사용 제한을 초과했습니다.

    // CACHE
    CACHE_USERMAP_NOTFOUND("80", "CACHE_USERMAP_NOTFOUND", 2),             // 캐쉬된 shardusermap 데이터가 없습니다.

    // 동물, 체리 뽑기
    DRAW_ANIMAL_INVALID_PARAM("90", "DRAW_ANIMAL_INVALID_PARAM", 1),       // 잘못된 파라미터로 에러가 발생했습니다.
    DRAW_ANIMAL_NOTFOUND("91", "DRAW_ANIMAL_NOTFOUND", 1),                 // 해당하는 동물 정보를 찾을 수 없습니다.
    DRAW_ANIMAL_WRONG_DATA("92", "DRAW_ANIMAL_WRONG_DATA", 2),             // 잘못된 데이터가 발생했습니다.
    DRAW_CHERRY_WRONG_DATA("93", "DRAW_CHERRY_WRONG_DATA", 2),             // 체리뽑기에서 잘못된 데이터가 발생했습니다.

    // ITEM(무기)
    ITEM_WRONG_DATA("100", "ITEM_WRONG_DATA", 2),                            // 보석으로 업그레이드시 최소 10레벨 이상이어야 합니다.

    // 마스터 데이터
    MST_INVALID_PARAM("110", "MST_INVALID_PARAM", 1),                      // 잘못된 파라미터로 에러가 발생했습니다.
    MST_INVALID_DATATYPE("111", "MST_INVALID_DATATYPE", 2),                // 마스터 데이터 형태가 잘못 되었습니다.
    MST_ANIMAL_NOTFOUND("112", "MST_ANIMAL_NOTFOUND", 2),                  // 마스터 동물 데이터가 없습니다.
    MST_LEVEL_NOTFOUND("113", "MST_LEVEL_NOTFOUND", 2),                    // 마스터 레벨 데이터가 없습니다.
    MST_BLOCKWORD_NOTFOUND("114", "MST_BLOCKWORD_NOTFOUND", 2),            // 금칙어 데이터가 없습니다.

    // 외부
    EXTERN_API_CALL_ERROR("120", "EXTERN_API_CALL_ERROR", 2),              // API 호출 중에 에러가 발생했습니다.
    EXTERN_INVALID_PARAM("121", "EXTERN_INVALID_PARAM", 2),                // 잘못된 parameter를 입력했습니다.
    EXTERN_WRONG_DATA("122", "EXTERN_WRONG_DATA", 1),                      // 잘못된 데이터가 발생했습니다.
    EXTERN_PURCHASE_SUCCESS("123", "EXTERN_PURCHASE_SUCCESS", 2),          // 결재가 성공했습니다.
    EXTERN_PURCHASE_FAIL("124", "EXTERN_PURCHASE_FAIL", 2),                // 결재가 실패했습니다.
    EXTERN_UC_VERIFY_SESSION_FAIL("125", "EXTERN_UC_VERIFY_SESSION_FAIL", 2);    // UC 인증 체크 검증 실패했습니다.

    private final String code;
    private final String value;

    /**
     * 에러 로깅 레벨(0:info, 1:warn, 2:error)
     */
    private final int level;

    ERROR(String code, String value, int level) {
        this.code = code;
        this.value = value;
        this.level = level;
    }

    public String code() {
        return code;
    }

    public String value() {
        return value;
    }

    public int level() {
        return level;
    }
}