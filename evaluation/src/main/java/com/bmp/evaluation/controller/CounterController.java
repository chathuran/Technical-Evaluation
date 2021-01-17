package com.bmp.evaluation.controller;

import com.bmp.evaluation.dao.CountValue;
import com.bmp.evaluation.dao.SearchTextList;
import com.bmp.evaluation.model.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/counter-api")
public class CounterController {

    @Autowired
    private SearchService searchService;

    /**
     * Task 1
     * @param searchText
     * @return
     */
    @PostMapping("/search")
    public List<CountValue> search(@RequestBody SearchTextList searchText){

        System.out.println(searchText);
        return searchService.search(searchText);
    }

    /**
     * Task 2
     * @param limit
     * @return
     */
    @RequestMapping(value = "/top/{limit}",method = RequestMethod.GET,produces = "text/csv" )
    public ResponseEntity test(@PathVariable int limit)  {

        try {
            File file= searchService.topCharacterCSVGen(limit);

            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=" + "reportName" + ".csv")
                    .contentLength(12)
                    .contentType(MediaType.parseMediaType("text/csv"))
                    .body(new FileSystemResource(file));

        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to generate report: " + "reportName", ex);
        }


    }
}
