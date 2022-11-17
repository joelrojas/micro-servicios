package arquitectura.software.mscustomer.service;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Service
@FeignClient(name = "keycloakService", url = "http://localhost:8180/auth/realms/google/protocol/openid-connect/token")
public interface KeycloakService {

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @Headers("Content-Type: application/x-www-form-urlencoded")
    public Map<String, String> getToken(Map<String, ?> params);

}
