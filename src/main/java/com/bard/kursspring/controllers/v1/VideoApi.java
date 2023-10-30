package com.bard.kursspring.controllers.v1;


import com.bard.kursspring.model.Video;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/videos")
public class VideoApi {

    private List<Video> videoList;

    public VideoApi() {
        this.videoList = new ArrayList<>();
        this.videoList.add(new Video(1L,
                "ARCHITEKTURA MIKROSERWISÓW - MIKROUSŁUGI - WPROWADZENIE",
                "https://www.youtube.com/watch?v=ImKvgCMJ_ro&t=3132s"));
        this.videoList.add(new Video(2L,
                "KOŃCZYMY APLIKACJE CHATU W SPRINGU I WDRAŻAMY JĄ NA SERWER VPS",
                "https://www.youtube.com/watch?v=vKtFeOXCkHM"));
    }

    @GetMapping
    public ResponseEntity<List<Video>> getVideos() {
        return new ResponseEntity<>(videoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Video> getVideoById(@PathVariable long id) {
//        Checking value with is present is simplier and also correct :)
        return this.videoList.stream()
                .filter(vid -> vid.getId() == id)
                .findFirst()
                .map(vid -> new ResponseEntity<>(vid, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping
    public ResponseEntity addVideo(@RequestBody Video video) {

        if (video == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        video.setId(this.videoList.size() + 1);
        this.videoList.add(video);

        return new ResponseEntity<>(HttpStatus.CREATED);


    }

    @PutMapping
    public ResponseEntity modifyVideo(@RequestBody Video postedVideo) {

        Optional<Video> optionalVideo = this.videoList.stream()
                .filter(video -> video.getId() == postedVideo.getId())
                .findFirst();
        if (optionalVideo.isPresent()) {
            Video video = optionalVideo.get();
            if (!video.getTitle().equals(postedVideo.getTitle())) {
                video.setTitle(postedVideo.getTitle());

            }
            if (!video.getUrl().equals(postedVideo.getUrl())) {
                video.setUrl(postedVideo.getUrl());
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteVide(@PathVariable long id) {
        Optional<Video> optionalVideo = this.videoList.stream()
                .filter(video -> video.getId() == id)
                .findFirst();
        if (optionalVideo.isPresent()) {
            this.videoList.remove(optionalVideo.get());
            return new ResponseEntity<>(optionalVideo.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


}
