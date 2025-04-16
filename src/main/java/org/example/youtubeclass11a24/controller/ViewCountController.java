package org.example.youtubeclass11a24.controller;

import org.example.youtubeclass11a24.model.View_count;
import org.example.youtubeclass11a24.service.View_CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/viewcount")
public class ViewCountController {

    @Autowired
    View_CountService viewCountService;

    @GetMapping
    public List<View_count> all(){
        return viewCountService.getall();
    }
    

}
