package com.pet.vk.music.web.audio;

import javax.ws.rs.*;

public interface AudioApi {

  @Path("/audio.get")
  @GET
  Songs songsByParams(@QueryParam("owner_id") Integer ownerId, @QueryParam("count") Integer count);
}
