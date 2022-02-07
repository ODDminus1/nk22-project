package no.visma.nk22project.imgflip.domain;

import lombok.Value;

@Value
public class CaptionMemeResponse {
    boolean success;
    CaptionMemeData data;
}
