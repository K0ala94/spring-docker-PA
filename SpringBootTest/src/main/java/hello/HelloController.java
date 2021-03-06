package hello;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index(HttpServletRequest request) {
    	String host = request.getServerName();
    	StringBuilder sb = new StringBuilder();
    	sb.append("Host:" + host);
    	sb.append("\n");
    	sb.append("Conetxtpath: " + request.getContextPath());
    	sb.append("\n");
    	sb.append("Local address: " + request.getLocalAddr() + " --- " + request.getLocalName());
        return sb.toString();
    }

}