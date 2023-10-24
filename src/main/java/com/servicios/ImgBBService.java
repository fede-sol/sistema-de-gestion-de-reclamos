package com.servicios;
import java.io.File;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImgBBService {
    private final String apiKey = "42dc2ab135f55ca2420fdd55256f8c1a";
    private final String uploadUrl = "https://api.imgbb.com/1/upload";


    public ResponseEntity<String> uploadImage(MultipartFile image) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("key", apiKey);
        body.add("image", image.getResource());

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(uploadUrl+ "?key="+apiKey, HttpMethod.POST, requestEntity, String.class);


    }
}
