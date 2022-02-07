package no.visma.nk22project.imgflip.domain;

import lombok.Value;

import java.util.List;

@Value
public class MemeData {
    List<Meme> memes;
}
