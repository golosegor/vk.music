package com.pet.vk.music.web.api.audio;

import com.fasterxml.jackson.annotation.*;
import java.util.Objects;

@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class SongInfo {
  @JsonProperty("date")
  private final Long date;

  @JsonProperty("id")
  private final Integer id;

  @JsonProperty("owner_id")
  private final Integer ownerId;

  @JsonProperty("artist")
  private final String artist;

  @JsonProperty("title")
  private final String title;

  @JsonProperty("duration")
  private final Integer duration;

  @JsonProperty("url")
  private final String url;

  @JsonProperty("lyrics_id")
  private final Integer lyricsId;

  @JsonProperty("genre_id")
  private final Integer genreId;

  @JsonProperty("photo")
  private final String photo;

  @JsonCreator
  public SongInfo(
      @JsonProperty("id") final Integer id,
      @JsonProperty("owner_id") final Integer ownerId,
      @JsonProperty("artist") final String artist,
      @JsonProperty("title") final String title,
      @JsonProperty("duration") final Integer duration,
      @JsonProperty("url") final String url,
      @JsonProperty("lyrics_id") final Integer lyricsId,
      @JsonProperty("genre_id") final Integer genreId,
      @JsonProperty("photo") final String photo,
      @JsonProperty("date") final Long date) {
    this.id = id;
    this.ownerId = ownerId;
    this.artist = artist;
    this.title = title;
    this.duration = duration;
    this.url = url;
    this.lyricsId = lyricsId;
    this.genreId = genreId;
    this.photo = photo;
    this.date = date;
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, id, ownerId, artist, title, duration, url, lyricsId, genreId, photo);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {return true;}
    if (obj == null || getClass() != obj.getClass()) {return false;}
    final SongInfo other = (SongInfo) obj;
    return Objects.equals(this.date, other.date)
        && Objects.equals(this.id, other.id)
        && Objects.equals(this.ownerId, other.ownerId)
        && Objects.equals(this.artist, other.artist)
        && Objects.equals(this.title, other.title)
        && Objects.equals(this.duration, other.duration)
        && Objects.equals(this.url, other.url)
        && Objects.equals(this.lyricsId, other.lyricsId)
        && Objects.equals(this.genreId, other.genreId)
        && Objects.equals(this.photo, other.photo);
  }

  public Long getDate() {
    return date;
  }

  public Integer getId() {
    return id;
  }

  public Integer getOwnerId() {
    return ownerId;
  }

  public String getArtist() {
    return artist;
  }

  public String getTitle() {
    return title;
  }

  public Integer getDuration() {
    return duration;
  }

  public String getUrl() {
    return url;
  }

  public Integer getLyricsId() {
    return lyricsId;
  }

  public Integer getGenreId() {
    return genreId;
  }

  public String getPhoto() {
    return photo;
  }

  @Override
  public String toString() {
    return "SongInfo{" +
        "date=" + date +
        ", id=" + id +
        ", ownerId=" + ownerId +
        ", artist='" + artist + '\'' +
        ", title='" + title + '\'' +
        ", duration=" + duration +
        ", url='" + url + '\'' +
        ", lyricsId=" + lyricsId +
        ", genreId=" + genreId +
        ", photo='" + photo + '\'' +
        '}';
  }
}
