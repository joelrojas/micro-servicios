package arquitectura.software.msaccount;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"})
@RestController
@RequestMapping("/v1/api/account")
public class AccountController {
    private static Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

    @Value("${server.port}")
    private String port;

    @Value("${jwt.secret}")
    private String jwtSecret;
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public ResponseEntity<String> test() {
        LOGGER.info("REQUEST: Iniciando petición del micro-servicio account servicio: test");
        LOGGER.info("JWT_SECRET: {}", jwtSecret);
        return new ResponseEntity<>("JWT_SECRET: " + jwtSecret, HttpStatus.OK);
    }

    @RequestMapping(value = "test-cajero", method = RequestMethod.GET)
    public ResponseEntity<String> testCajero() {
        LOGGER.info("REQUEST: Iniciando petición del micro-servicio account servicio: test cajero");
        LOGGER.info("JWT_SECRET: {}", jwtSecret);
        return new ResponseEntity<>("JWT_SECRET " + jwtSecret, HttpStatus.OK);
    }

    @RequestMapping(value = "test-admin", method = RequestMethod.GET)
    public ResponseEntity<String> testToken() {
        LOGGER.info("REQUEST: Iniciando petición del micro-servicio account servicio: test admin");
        LOGGER.info("JWT_SECRET: {}", jwtSecret);
        return new ResponseEntity<>("JWT_SECRET " + jwtSecret, HttpStatus.OK);
    }
}
