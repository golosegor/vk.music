package com.pet.vk.music.web.api.audio;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.NONE)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonTypeName("response")
public class Songs {
  private final Integer count;

  private final List<SongInfo> items;

  @JsonCreator
  public Songs(@JsonProperty("count") final Integer count,
      @JsonProperty("items") final List<SongInfo> items) {
    this.count = count;
    this.items = items;
  }

  @Override
  public String toString() {
    return "Songs{" +
        "count=" + count +
        ", items=" + items +
        '}';
  }

  @Override
  public int hashCode() {return Objects.hash(count, items);}

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {return true;}
    if (obj == null || getClass() != obj.getClass()) {return false;}
    final Songs other = (Songs) obj;
    return Objects.equals(this.count, other.count)
        && Objects.equals(this.items, other.items);
  }
}
