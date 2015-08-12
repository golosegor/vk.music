package com.pet.vk.music.web.api.audio;

import com.fasterxml.jackson.databind.*;
import feign.*;
import feign.jackson.JacksonDecoder;
import feign.jaxrs.JAXRSContract;
import feign.slf4j.Slf4jLogger;
import javax.ws.rs.*;

public interface AudioApi {

  @Path("/method/audio.get")
  @GET
  Songs songsByParams(@QueryParam("owner_id") Integer ownerId, @QueryParam("count") Integer count);

  class factory {
    public static AudioApi createApiVersion5_37(String token) {
      final ObjectMapper objectMapper = new ObjectMapper();
      objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
      return Feign.builder()
          .logger(new Slf4jLogger())
          .logLevel(Logger.Level.FULL)
          .contract(new JAXRSContract())
          .decoder(new JacksonDecoder(objectMapper))
          .requestInterceptor(requestTemplate -> {
            requestTemplate.query("access_token", token);
            requestTemplate.query("v", "5.37");
          })
          .target(AudioApi.class, "https://api.vk.com");
    }
  }
}
