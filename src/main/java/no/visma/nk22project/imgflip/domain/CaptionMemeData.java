package no.visma.nk22project.imgflip.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class CaptionMemeData {
    String url;
    @JsonProperty("page_url")
    String pageUrl;
}
