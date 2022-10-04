package arquitectura.software.mscustomer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/customer")
public class CustomerController {
    private static Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public ResponseEntity<String> test() {
        LOGGER.info("REQUEST: Iniciando petición del micro-servicio customer servicio: test");
        return new ResponseEntity<>("TEST CUSTOMER", HttpStatus.OK);
    }
}
