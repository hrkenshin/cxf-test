package com.tony.examples.cxf;

/**
 * 시스템 상수 정의 클래스
 */
public class Constants {
    /**
     * 사용자 ROLE ( GUEST < USER < TESTER < ADMIN )
     */
    public enum USER_ROLE {
        GUEST(0, "게스트"), USER(1, "사용자"), TESTER(2, "테스터"), ADMIN(9, "관리자");

        private int value;
        private String name;

        private USER_ROLE(int v, String name) {
            this.value = v;
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public String getName() {
            return name;
        }

        public static USER_ROLE get(int v) {
            switch (v) {
                case 0:
                    return USER_ROLE.GUEST;
                case 1:
                    return USER_ROLE.USER;
                case 2:
                    return USER_ROLE.TESTER;
                case 9:
                    return USER_ROLE.ADMIN;
                default:
                    return USER_ROLE.GUEST;
            }
        }

        public static USER_ROLE get(String v) {
            return USER_ROLE.get(Integer.parseInt(v));
        }
    }
}