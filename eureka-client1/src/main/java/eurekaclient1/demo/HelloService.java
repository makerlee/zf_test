package eurekaclient1.demo;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by mrjyn on 2018/5/1.
 */
@FeignClient(name = "ribbon-consume")
public interface HelloService {
}
