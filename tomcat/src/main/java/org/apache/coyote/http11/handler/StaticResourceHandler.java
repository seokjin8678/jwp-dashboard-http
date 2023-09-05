package org.apache.coyote.http11.handler;

import java.io.IOException;
import org.apache.coyote.Handler;
import org.apache.coyote.common.HttpContentType;
import org.apache.coyote.common.HttpRequest;
import org.apache.coyote.common.HttpResponse;
import org.apache.coyote.common.HttpStatus;
import org.apache.coyote.util.ResourceResolver;

public class StaticResourceHandler implements Handler {

    @Override
    public HttpResponse handle(HttpRequest request) throws IOException {
        String path = request.getPath();
        HttpResponse response = new HttpResponse();
        response.setContentType(getContentType(path));
        response.setContentBody(ResourceResolver.resolve(path));
        response.setHttpStatus(HttpStatus.OK);
        return response;
    }

    private HttpContentType getContentType(String path) {
        int index = path.lastIndexOf(".");
        if (index <= 0) {
            return HttpContentType.TEXT_PLAIN;
        }
        String extension = path.substring(index);
        return HttpContentType.from(extension);
    }
}
