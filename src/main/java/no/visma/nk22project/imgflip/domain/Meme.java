package no.visma.nk22project.imgflip.domain;


import lombok.Value;

@Value
public class Meme {
    String id;
    String name;
    String url;
    String width;
    String height;
    String boxCount;
}
