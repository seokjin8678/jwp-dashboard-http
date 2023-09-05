package org.apache.coyote.common;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class RequestUriTest {

    @Nested
    class from {

        @Test
        void 파라미터가_null이면_예외() {
            // when & then
            assertThatThrownBy(() -> RequestUri.from(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("requestUri는 null이 될 수 없습니다.");
        }

        @Test
        void 파라미터가_RequestUri의_형식이_아니면_예외() {
            assertThatThrownBy(() -> RequestUri.from("hello world"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("지원되지 않는 RequestURI 입니다.");
        }

        @Test
        void 생성() {
            // given
            RequestUri requestUri = RequestUri.from("GET /index.html HTTP/1.1");

            // when & then
            SoftAssertions.assertSoftly(softly -> {
                softly.assertThat(requestUri.getHttpMethod()).isEqualTo(HttpMethod.GET);
                softly.assertThat(requestUri.getHttpPath().getPath()).isEqualTo("/index.html");
                softly.assertThat(requestUri.getHttpProtocol()).isEqualTo(HttpProtocol.HTTP11);
            });
        }
    }
}
