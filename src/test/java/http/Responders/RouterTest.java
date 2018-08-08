package http.Responders;

import http.HardcodedValues;
import http.Requesters.HTTPVerb;
import http.Requesters.Request;
import org.junit.Test;

import java.util.HashMap;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RouterTest {

    private String mockFileURI = "src/test/resources/dummyFile1.txt";
    private HashMap<String, String> emptyHeaders = new HashMap<>();
    private String emptyBody;
//
//    @Test
//    public void respondTo_GETRequest_MethodNotAllowedForFile() {
//        Router router = new Router();
//        Request mockRequest = new Request(HTTPVerb.POST, mockFileURI, emptyHeaders, emptyBody);
//
//        Response mockResponse = router.respondTo(mockRequest);
//
//        assertEquals(ResponseStatus.METHODNOTALLOWED, mockResponse.getStatus());
//        assertTrue(mockResponse.getHeaders().isEmpty());
//        assertArrayEquals(ResponseStatus.METHODNOTALLOWED.getStatusBody(),
//                mockResponse.getBodyContent());
//    }
//
//    @Test
//    public void respondTo_GETRequest_MethodNotAllowedForLogs() {
//        Router router = new Router();
//        Request mockRequest = new Request(HTTPVerb.DELETE, "src/test/resources/logs", emptyHeaders, emptyBody);
//
//        Response mockResponse = router.respondTo(mockRequest);
//
//        assertEquals(ResponseStatus.METHODNOTALLOWED, mockResponse.getStatus());
//        assertTrue(mockResponse.getHeaders().isEmpty());
//        assertArrayEquals(ResponseStatus.METHODNOTALLOWED.getStatusBody(),
//                mockResponse.getBodyContent());
//    }
//
//    @Test
//    public void respondTo_redirectRequest() {
//        Router router = new Router();
//        Request mockRequest = new Request(HTTPVerb.GET, HardcodedValues.RESOURCEPATH.getS() + "/redirect", emptyHeaders, emptyBody);
//
//        Response mockResponse = router.respondTo(mockRequest);
//
//        assertEquals(ResponseStatus.FOUND, mockResponse.getStatus());
//        assertNotNull(mockResponse.getHeaders().get(ResponseHeader.LOCATION));
//        assertArrayEquals(ResponseStatus.FOUND.getStatusBody(),
//                mockResponse.getBodyContent());
//    }
//
//    @Test
//    public void respondTo_coffeeRequest() {
//        Router router = new Router();
//        Request mockRequest = new Request(HTTPVerb.GET, HardcodedValues.RESOURCEPATH.getS() + "/coffee", emptyHeaders, emptyBody);
//
//        Response mockResponse = router.respondTo(mockRequest);
//
//        assertEquals(ResponseStatus.IMATEAPOT, mockResponse.getStatus());
//        assertArrayEquals(ResponseStatus.IMATEAPOT.getStatusBody(),
//                mockResponse.getBodyContent());
//    }
//
//    @Test
//    public void respondTo_teaRequest() {
//        Router router = new Router();
//        Request mockRequest = new Request(HTTPVerb.GET, HardcodedValues.RESOURCEPATH.getS() + "/tea", emptyHeaders, emptyBody);
//
//        Response mockResponse = router.respondTo(mockRequest);
//
//        assertEquals(ResponseStatus.OK, mockResponse.getStatus());
//        assertArrayEquals("Here's some delicious tea!".getBytes(),
//                mockResponse.getBodyContent());
//    }

    @Test
    public void respondTo_teaRequest() {
        Router2 router2 = new Router2("/");
        Request mockRequest = new Request(HTTPVerb.OPTIONS, "/tea", emptyHeaders, emptyBody);

        Response mockResponse = router2.handle(mockRequest);

        assertEquals(ResponseStatus.OK, mockResponse.getStatus());
        assertNotNull(mockResponse.getHeaders().get(ResponseHeader.ALLOW));
    }
}