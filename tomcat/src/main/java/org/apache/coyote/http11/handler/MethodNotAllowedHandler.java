package org.apache.coyote.http11.handler;

import java.io.IOException;
import org.apache.coyote.Handler;
import org.apache.coyote.common.HttpContentType;
import org.apache.coyote.common.HttpProtocol;
import org.apache.coyote.common.HttpRequest;
import org.apache.coyote.common.HttpResponse;
import org.apache.coyote.common.HttpStatus;
import org.apache.coyote.util.ResourceResolver;

public class MethodNotAllowedHandler implements Handler {

    public static final MethodNotAllowedHandler INSTANCE = new MethodNotAllowedHandler();

    private MethodNotAllowedHandler() {
    }

    @Override
    public HttpResponse handle(HttpRequest request) throws IOException {
        HttpResponse response = new HttpResponse(HttpProtocol.HTTP11, HttpStatus.METHOD_NOT_ALLOWED);
        response.setContentType(HttpContentType.TEXT_HTML);
        response.setContentBody(ResourceResolver.resolve("/405.html"));
        return response;
    }
}