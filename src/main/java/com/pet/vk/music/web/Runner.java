package com.pet.vk.music.web;

import com.pet.vk.music.web.api.audio.*;

public class Runner {
  public static void main(String[] args) {
    final String token
        = "17eeefeb21776d0dd92588ab5c3607ded88e76839a11e3a2b5c1fccd50aecf8d5c87b8120fc15391161e0";
    final AudioApi audioApi = AudioApi.factory.createApiVersion5_37(token);
    final int userId = 2397696;
    final int limit = 3;
    final Songs songs = audioApi.songsByParams(userId, limit);
  }
}
