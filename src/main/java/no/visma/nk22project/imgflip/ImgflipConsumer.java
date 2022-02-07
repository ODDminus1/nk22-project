package no.visma.nk22project.imgflip;

import lombok.RequiredArgsConstructor;
import no.visma.nk22project.imgflip.domain.CaptionMemeResponse;
import no.visma.nk22project.imgflip.domain.GetMemesResponse;
import no.visma.nk22project.imgflip.repo.PersistedMeme;
import no.visma.nk22project.imgflip.repo.PersistedMemeRepo;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class ImgflipConsumer {
    private final WebClient webClient;
    private final PersistedMemeRepo persistedMemeRepo;

    public GetMemesResponse getMemes() {
        return webClient.get()
                .uri("https://api.imgflip.com/get_memes")
                .retrieve()
                .bodyToMono(GetMemesResponse.class)
                .block();
    }

    public CaptionMemeResponse captionMeme(String templateId, String text0, String text1) {
        var memeResponse = webClient.post()
                .uri(UriComponentsBuilder.fromHttpUrl("https://api.imgflip.com/caption_image")
                        .queryParam("template_id", templateId)
                        .queryParam("username", "visma1")
                        .queryParam("password", "visma123")
                        .queryParam("text0", text0)
                        .queryParam("text1", text1)
                        .build().toUri())
                .retrieve()
                .bodyToMono(CaptionMemeResponse.class)
                .block();

        var persistedMeme = PersistedMeme.builder()
                .name(String.join(", ", text0, text1))
                .url(memeResponse.getData().getUrl())
                .build();

        persistedMemeRepo.save(persistedMeme);

        return memeResponse;
    }
}
