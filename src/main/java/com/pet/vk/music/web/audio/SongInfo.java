package com.pet.vk.music.web.audio;

import com.fasterxml.jackson.annotation.*;

public class SongInfo {
  private final Integer id;

  private final Integer ownerId;

  private final String artist;

  private final String title;

  private final Integer duration;

  private final String url;

  private final Integer lyricsId;

  private final Integer genreId;

  private final String photo;

  @JsonCreator
  public SongInfo(@JsonProperty("id") final Integer id,
      @JsonProperty("owner_id") final Integer ownerId,
      @JsonProperty("artist") final String artist,
      @JsonProperty("title") final String title,
      @JsonProperty("duration") final Integer duration,
      @JsonProperty("url") final String url,
      @JsonProperty("lyrics_id") final Integer lyricsId,
      @JsonProperty("genr_id") final Integer genreId,
      @JsonProperty("photo") final String photo) {
    this.id = id;
    this.ownerId = ownerId;
    this.artist = artist;
    this.title = title;
    this.duration = duration;
    this.url = url;
    this.lyricsId = lyricsId;
    this.genreId = genreId;
    this.photo = photo;
  }
}
