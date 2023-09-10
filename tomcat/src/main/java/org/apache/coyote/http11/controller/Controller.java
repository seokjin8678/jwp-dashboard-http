package org.apache.coyote.http11.controller;

import java.io.IOException;
import org.apache.coyote.common.HttpRequest;
import org.apache.coyote.common.HttpResponse;

public interface Controller {

    void service(HttpRequest request, HttpResponse response) throws IOException;
}
