package org.example.youtubeclass11a24.controller;

import org.example.youtubeclass11a24.dto.VideoDto;
import org.example.youtubeclass11a24.model.Result;
import org.example.youtubeclass11a24.model.Video;
import org.example.youtubeclass11a24.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/video")
public class VideoController {

    @Autowired
    VideoService videoService;

    @GetMapping
    public HttpEntity<?> all() {
        List<Video> getall = videoService.getall();
        return new ResponseEntity<>(getall, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> by_id(@PathVariable Integer id) {
        Video service = videoService.get_by_id(id);
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<?> add(@RequestBody VideoDto videoDto) {
        Result result = videoService.create(videoDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleted(@PathVariable Integer id) {
        Result delete = videoService.delete(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }

}
