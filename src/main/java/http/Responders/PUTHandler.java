package http.Responders;

import http.Requesters.Request;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PUTHandler implements Handler {

    private Request request;
    private Response response;

    public Response handle(Request request) {
        this.request = request;
        response = new Response();
        if (Files.exists(Paths.get(request.getURI()))) {
            performUpdateResponse();
        } else {
            performCreateResponse();
        }
        return response;
    }

    private void performCreateResponse() {
        writeFile();
        response.setStatus(ResponseStatus.CREATED);
    }

    private void performUpdateResponse() {
        writeFile();
        response.setStatus(ResponseStatus.OK);
    }


    private void writeFile() {
        try {
            Files.write(Paths.get(request.getURI()),
                    request.getBodyContent().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
