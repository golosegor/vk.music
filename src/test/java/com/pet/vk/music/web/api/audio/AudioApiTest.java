package com.pet.vk.music.web.api.audio;

import com.fasterxml.jackson.databind.*;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;
import static io.dropwizard.testing.FixtureHelpers.fixture;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

public class AudioApiTest {
  private static final ObjectMapper MAPPER = Jackson.newObjectMapper()
      .enable(SerializationFeature.INDENT_OUTPUT);

  ;

  @Test
  public void deserializesFromJSON()
  throws Exception {
    final SongInfo song = new SongInfo(1, 1, "Luther Blissett", "lb@example.com", 1, "ss", 1,
        1, "pp", 1439150460L);
    final Songs songs = new Songs(1, singletonList(song));
    final String s = MAPPER.writeValueAsString(songs);
    final Songs actual = MAPPER.readValue(fixture("fixtures/audioByUserId.json"), Songs.class);
    assertThat(actual).isEqualTo(songs);
  }
}