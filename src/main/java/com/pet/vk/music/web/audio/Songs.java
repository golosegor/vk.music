package com.pet.vk.music.web.audio;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class Songs {
  private final Integer count;

  private final List<SongInfo> items;

  @JsonCreator
  public Songs(@JsonProperty("count") final Integer count,
      @JsonProperty("items") final List<SongInfo> items) {
    this.count = count;
    this.items = items;
  }
}
