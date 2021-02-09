package com.js.music.domain;

import ws.schild.jave.AudioAttributes;
import ws.schild.jave.Encoder;
import ws.schild.jave.EncodingAttributes;
import ws.schild.jave.MultimediaObject;

import java.io.File;

/**
 * @author 刘锦涛
 * @title: Mp3
 * @projectName music-transform
 * @date 2021/2/9
 * @dateTime 9:16
 * @description: TODO
 */
public class Mp3 {

    File source;
    File target;

    public Mp3(File source, File target) {
        this.source = source;
        this.target = target;
    }

    public Mp3(String sourcePath, String targetPath) {
        source= new File(sourcePath);
        target=new File(targetPath);
    }

    public boolean  toMp3() {

        boolean succeeded=true;
        try {

            //Audio Attributes
            AudioAttributes audio = new AudioAttributes();
            audio.setCodec("libmp3lame");
            audio.setBitRate(128000);
            audio.setChannels(2);
            audio.setSamplingRate(44100);

            //Encoding attributes
            EncodingAttributes attrs = new EncodingAttributes();
            attrs.setFormat("mp3");
            attrs.setAudioAttributes(audio);

            //Encode
            Encoder encoder = new Encoder();
            encoder.encode(new MultimediaObject(source), target, attrs);

        } catch (Exception ex) {
            ex.printStackTrace();
            succeeded = false;
        }
        return succeeded;
    }

}
