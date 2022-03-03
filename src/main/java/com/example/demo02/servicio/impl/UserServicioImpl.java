package com.example.demo02.servicio.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import com.example.demo02.modelo.UsuarioModel;
import com.example.demo02.servicio.UserServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
//import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
//import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServicioImpl implements UserServicio {

    public static final Logger logger = LoggerFactory.getLogger(UserServicioImpl.class);

    //@Autowired(required = true)
	private RestTemplate restTemplate = new RestTemplate();

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<UsuarioModel> obtenerUsuarios(){

        //logger.info("Inicia Busqueda Comentarios Con For Entity");

		/*restTemplate.getInterceptors().add(new ClientHttpRequestInterceptor() {
			@Override
			public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
					throws IOException {
				request.getHeaders().setContentType(MediaType.APPLICATION_JSON);
				request.getHeaders().setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
				return execution.execute(request, body);
			}
		});*/

        try{
            final String randomServerPort =  "a";
            final String baseUrl = "https://reqres.in/api/users";
            URI uri = new URI(baseUrl);

            HttpHeaders headers = new HttpHeaders();
            headers.set("X-COM-PERSIST", "true");

            HttpEntity<UsuarioModel> requestEntity = new HttpEntity<>(null, headers);

            ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);

            ResponseEntity<String> response = restTemplate.getForEntity(uri,
				String.class);

		logger.info("Response: {}", response.getBody());

        }catch(URISyntaxException uri){
            logger.info("Response: {}", uri);
        }
        

		

		List<UsuarioModel> object = null;

		return object;


    }
    
}
