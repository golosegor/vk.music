package com.pet.vk.music.web;

import com.google.common.base.Preconditions;
import com.pet.vk.music.web.api.audio.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.*;
import org.slf4j.*;
import java.io.*;
import java.net.*;
import java.util.concurrent.atomic.AtomicInteger;

public class DownloadPerformer {
  private final Logger LOGGER = LoggerFactory.getLogger(DownloadPerformer.class);

  public static final int LIMIT = 999999;

  public void downloadSongsForUser(final int userId, final File directory, final String token) {
    Preconditions.checkArgument(directory.exists(), "Directory %s does not exist",
        directory.getAbsoluteFile());
    Preconditions.checkArgument(directory.isDirectory(), "Directory %s is not directory",
        directory.getAbsoluteFile());
    final AudioApi audioApi = AudioApi.factory.createApiVersion5_37(token);
    final Songs songs = audioApi.songsByParams(userId, LIMIT);

    final AtomicInteger count = new AtomicInteger(0);
    songs.songs().parallelStream().forEach(s -> {
      LOGGER.warn("Downloading {} from {}", count.incrementAndGet(), songs.songs().size());
      saveSongToEndDirectory(s, directory);
    });
  }

  private void saveSongToEndDirectory(final SongInfo s, final File baseDir) {
    try {
      final URL url = new URL(s.getUrl());
      final String songName = String.format("%s - %s.mp3", fixWindowsFileName(s.getArtist()),
          fixWindowsFileName(s.getTitle()));
      final File endFile = new File(baseDir, songName);
      if (endFile.exists()) { endFile.delete(); }
      FileUtils.copyURLToFile(url, endFile);
    } catch (IOException e) {
      LOGGER.error("Error occurred", e);
    }
  }

  private static String fixWindowsFileName(String pathname) {
    final String[] forbiddenSymbols = new String[]{"<", ">", ":", "\"", "/", "\\", "|", "?", "*"};
    String result = pathname;
    for (String forbiddenSymbol : forbiddenSymbols) {
      result = StringUtils.replace(result, forbiddenSymbol, "");
    }
    return StringEscapeUtils.unescapeXml(result);
  }
}
