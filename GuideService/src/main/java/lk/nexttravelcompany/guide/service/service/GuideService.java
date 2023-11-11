package lk.nexttravelcompany.guide.service.service;

import lk.nexttravelcompany.guide.service.dto.GuideDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GuideService {
    Mono<GuideDTO>saveGuide(GuideDTO guideDTO);
    Mono<String>generateGuideId();
    Mono<GuideDTO>getGuide(String guidName);
    Flux<GuideDTO>getAllGuides();
    Mono<GuideDTO>updateGuide(GuideDTO guideDTO);
    Mono<Void>deleteGuide(String guidId);
}
