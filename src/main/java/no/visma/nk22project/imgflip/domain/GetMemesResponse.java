package no.visma.nk22project.imgflip.domain;


import lombok.Value;

@Value
public class GetMemesResponse {
    boolean success;
    MemeData data;
}
