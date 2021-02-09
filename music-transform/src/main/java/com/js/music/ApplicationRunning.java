package com.js.music;

import com.js.music.domain.Mp3;

/**
 * @author 刘锦涛
 * @title: ApplicationRunning
 * @projectName music-transform
 * @date 2021/2/9
 * @dateTime 9:17
 * @description: TODO
 */
public class ApplicationRunning {
    public static void main(String[] args) {
        new Mp3("C:/Users/liujintao/Music/王心凌 - 梦的光点.flac",
                "C:/Users/liujintao/Music/王心凌 - 梦的光点.mp3").toMp3();
    }
}
