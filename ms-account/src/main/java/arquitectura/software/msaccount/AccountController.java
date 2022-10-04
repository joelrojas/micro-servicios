package arquitectura.software.msaccount;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/account")
public class AccountController {
    private static Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public ResponseEntity<String> test() {
        LOGGER.info("REQUEST: Iniciando petición del micro-servicio account servicio: test");
        return new ResponseEntity<>("TEST ACCOUNT", HttpStatus.OK);
    }
}
