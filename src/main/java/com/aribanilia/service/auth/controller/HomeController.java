package com.aribanilia.service.auth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @PostMapping(value="/protected", produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object protectedPage() throws Exception {
        logger.info("Incoming POST /protected");
        HashMap<String, String> response = new HashMap<>();
        try {
            response.put("responseCode", "00");
            response.put("responseDesc", "Approved");
        } catch (Exception e) {
            response.put("responseCode", "500");
            response.put("responseDesc", "Sistem Gagal Mengambil Data");
            e.printStackTrace();
            logger.error("Exception " + e.getMessage());
        }
        logger.info("OutGoing POST /protected");
        return response;
    }
}
