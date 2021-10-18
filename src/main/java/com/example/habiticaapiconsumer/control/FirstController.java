package com.example.habiticaapiconsumer.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FirstController {

    @Autowired
    private RestTemplate restTemplate;

    private static String url = "https://habitica.com/api/v3/user/anonymized";

    @RequestMapping( method = RequestMethod.GET, path = "/userInfo")
    public Object getInfo(){

        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("x-api-user", "xxx");
        httpHeaders.add("x-api-key", "xxx");

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(httpHeaders);
        System.out.println(requestEntity.getHeaders().toSingleValueMap());

        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(httpHeaders),
                Object.class, (Object) null).getBody();

    }

}
