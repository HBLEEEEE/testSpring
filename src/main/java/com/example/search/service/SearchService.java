package com.example.search.service;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.Charset;

@Service
public class SearchService {

    RestTemplate restTemplate = new RestTemplate();

    public String search(String searchThing){
        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("v1/search/local.json")
                .queryParam("query",searchThing)
                .queryParam("display", 10)
                .queryParam("start", 1)
                .queryParam("sort", "random")
                .encode(Charset.forName("UTF-8"))
                .build()
                .toUri();

        System.out.println("uri : " + uri );

        RequestEntity<Void> req = RequestEntity
                .get(uri)
                .header("X-Naver-Client-Id", "RA4Bzpu8IJFbuWOXiGOy")
                .header("X-Naver-Client-Secret","iaWvEjxRXJ")
                .build();

        ResponseEntity<String> result = restTemplate.exchange(req, String.class);

        return result.getBody();
    }
}