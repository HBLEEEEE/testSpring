package com.example.search.controller;


import com.example.search.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/search/{searchThing}")
    public String search(@PathVariable String searchThing){

        return searchService.search(searchThing);
    }
}
