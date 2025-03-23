package com.saude.facil.demo.provider;

import com.saude.facil.demo.provider.dto.EnderecoResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepApi {

    public EnderecoResponse apiCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://viacep.com.br/ws/" + cep + "/json";
        return restTemplate.getForObject(url, EnderecoResponse.class);
    }
}
