package org.apache.coyote.http11.handler;

import org.apache.coyote.AbstractHandler;
import org.apache.coyote.common.HttpContentType;
import org.apache.coyote.common.HttpRequest;
import org.apache.coyote.common.HttpResponse;
import org.apache.coyote.common.HttpStatus;
import org.apache.coyote.util.ResourceResolver;

public class NotFoundHandler extends AbstractHandler {

    @Override
    public void handle(HttpRequest request, HttpResponse response) {
        response.setContentType(HttpContentType.TEXT_HTML);
        response.setContentBody(ResourceResolver.resolve("/404.html"));
        response.setHttpStatus(HttpStatus.NOT_FOUND);
    }
}
