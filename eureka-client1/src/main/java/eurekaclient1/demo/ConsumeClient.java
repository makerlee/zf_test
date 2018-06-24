package eurekaclient1.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumeClient {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/ribbon-consume",method = RequestMethod.GET)
    public String consume(){
        String body = restTemplate.getForEntity("http://hello-service/hello/", String.class).getBody();
        return body;

    }
}
