package arquitectura.software.mscustomer;

import arquitectura.software.mscustomer.service.AccountService;
import arquitectura.software.mscustomer.service.KeycloakService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/api/customer")
public class CustomerController {
    private static Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    private AccountService accountService;
    private KeycloakService keycloakService;
    @Autowired
    public CustomerController(AccountService accountService, KeycloakService keycloakService) {
        this.accountService = accountService;
        this.keycloakService = keycloakService;
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public ResponseEntity<String> test() {
        LOGGER.info("REQUEST: Iniciando petición del micro-servicio customer servicio: test");
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("grant_type", "client_credentials");
        params.put("client_id", "youtube");
        params.put("client_secret", "857pYhP4aVBM0mklvyjC3X13O7nYlSrt");
        Map<String, String> responseKeycloak = keycloakService.getToken(params);
        LOGGER.info("TOKEN {}", responseKeycloak);
        String result1 = accountService.test(responseKeycloak.get("access_token"));
        String result2 = accountService.testAdmin("Bearer " + responseKeycloak.get("access_token"));
//        LOGGER.info("RESULTADO DE LA INVOCACION A MS-ACCOUNT: {}", result);
        return new ResponseEntity<>("TEST CUSTOMER --> " + result1 + result2, HttpStatus.OK);
    }
}
