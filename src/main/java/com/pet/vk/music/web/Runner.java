package com.pet.vk.music.web;

import com.fasterxml.jackson.databind.*;
import com.pet.vk.music.web.audio.*;
import feign.*;
import feign.jackson.JacksonDecoder;
import feign.jaxrs.JAXRSContract;
import feign.slf4j.Slf4jLogger;

public class Runner {
  public static void main(String[] args) {
    final String token
        = "26b5ee0ff277371b041cd7113e9d80595bb87d04fac83057d017d6ffc73a15b461592e7adde89fc58d574";
    final ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    final AudioApi audioApi = Feign.builder()
        .logger(new Slf4jLogger())
        .logLevel(Logger.Level.FULL)
        .contract(new JAXRSContract())
        .decoder(new JacksonDecoder(objectMapper))
        .requestInterceptor(requestTemplate -> {
          requestTemplate.query("access_token", token);
        })
        .target(AudioApi.class, "https://api.vk.com");
    final Songs songs = audioApi.songsByParams(11055539, 3);
    int i = 0;
  }
}
