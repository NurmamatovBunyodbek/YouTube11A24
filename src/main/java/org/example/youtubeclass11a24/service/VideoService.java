package org.example.youtubeclass11a24.service;

import org.example.youtubeclass11a24.dto.VideoDto;
import org.example.youtubeclass11a24.model.*;
import org.example.youtubeclass11a24.model.entity.Status;
import org.example.youtubeclass11a24.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.Inet4Address;
import java.util.List;
import java.util.Optional;

@Service
public class VideoService {

    @Autowired
    VideoRepo videoRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    AttachRepo attachRepo;

    @Autowired
    View_countRepo viewCountRepo;

    @Autowired
    ChannelRepo channelRepo;

    // get all
    public List<Video> getall() {
        return videoRepo.findAll();
    }

    // get by id
    public Video get_by_id(Integer id) {
        Optional<Video> videoOptional = videoRepo.findById(id);
        return videoOptional.get();
    }

    // create
    public Result create(VideoDto videoDto) {
        Video video = new Video();
        video.setPreview_attach_id(videoDto.getPreview_attach_id());
        video.setTitle(videoDto.getTitle());

        Optional<Category> categoryOptional = categoryRepo.findById(videoDto.getCategory());
        Category category = categoryOptional.get();
        video.setCategory((List<Category>) category);

        Optional<Attach> attachOptional = attachRepo.findById(videoDto.getAttach());
        Attach attach = attachOptional.get();
        video.setAttach(attach);

        video.setStatus(Status.ACTIVE);
        video.setType(videoDto.getType());

        Optional<View_count> countOptional = viewCountRepo.findById(videoDto.getViewCount());
        View_count viewCount = countOptional.get();
        video.setViewCount((List<View_count>) viewCount);

        video.setDescription(videoDto.getDescription());

        Optional<Channel> channelOptional = channelRepo.findById(videoDto.getChannel());
        Channel channel = channelOptional.get();
        video.setChannel((List<Channel>) channel);

        video.setLike_count(videoDto.getLike_count());
        video.setDislike_count(videoDto.getDislike_count());

        videoRepo.save(video);
        return new Result(true, "Saqlandi");
    }

    // delete
    public Result delete(Integer id) {
        Optional<Video> videoOptional = videoRepo.findById(id);
        if (videoOptional.isPresent()) {
            videoRepo.deleteById(id);
            return new Result(true, "Deleted");
        }
        return new Result(false, "Id not found");
    }


}
