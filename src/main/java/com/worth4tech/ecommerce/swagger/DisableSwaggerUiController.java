package com.worth4tech.ecommerce.swagger;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Profile("!dev")
@RestController
public class DisableSwaggerUiController {
	
	@RequestMapping(value = "/swagger-ui", method = RequestMethod.GET)
    public void getSwagger(HttpServletResponse httpResponse) throws IOException {
        httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
    }

}
