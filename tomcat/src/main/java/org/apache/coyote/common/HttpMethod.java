package org.apache.coyote.common;

public enum HttpMethod {
    GET,
    POST,
    PATCH
    ;

    public static HttpMethod from(String httpMethod) {
        try {
            return valueOf(httpMethod);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("지원되지 않는 HTTP 메서드 입니다.");
        }
    }
}
