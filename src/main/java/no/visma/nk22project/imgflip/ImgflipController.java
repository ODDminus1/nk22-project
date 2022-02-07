package no.visma.nk22project.imgflip;

import lombok.RequiredArgsConstructor;
import no.visma.nk22project.imgflip.domain.CaptionMemeResponse;
import no.visma.nk22project.imgflip.domain.GetMemesResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ImgflipController {
    private final ImgflipConsumer imgflipConsumer;

    @GetMapping("/memes")
    GetMemesResponse getMemes() {
        return imgflipConsumer.getMemes();
    }

    @GetMapping("/captionmeme")
    CaptionMemeResponse captionMeme(
            @RequestParam("template_id") String templateId,
            @RequestParam("text0") String text0,
            @RequestParam("text1") String text1
    ) {
        return imgflipConsumer.captionMeme(templateId, text0, text1);
    }
}
