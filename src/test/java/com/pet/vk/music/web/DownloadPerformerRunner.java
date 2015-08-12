package com.pet.vk.music.web;

import java.io.File;

public class DownloadPerformerRunner {
  public static void main(String[] args) {
    final DownloadPerformer downloadPerformer = new DownloadPerformer();
    final int userId = 2397696;
    final String token
        = "17eeefeb21776d0dd92588ab5c3607ded88e76839a11e3a2b5c1fccd50aecf8d5c87b8120fc15391161e0";
    downloadPerformer.downloadSongsForUser(userId, new File("C:\\Users\\test\\Downloads\\music"),
        token);
  }
}