package com.lbs.Studentmanagementapp.controller;

import com.lbs.Studentmanagementapp.dto.BatchDTO;
import com.lbs.Studentmanagementapp.dto.BatchSaveDTO;
import com.lbs.Studentmanagementapp.dto.BatchUpdateDTO;
import com.lbs.Studentmanagementapp.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/batch")
public class BatchController {

    @Autowired
    private BatchService batchService;

    @PostMapping(path = "/save")
    public String saveBatch(@RequestBody BatchSaveDTO batchSaveDTO)
    {
        String batch = batchService.addBatch(batchSaveDTO);
        return batch;
    }

    @GetMapping("/getAllBatches")
    public List<BatchDTO> getAllBatches()
    {
        List<BatchDTO> allBatches = batchService.getAllBatches();
        return allBatches;
    }


    @PutMapping(path = "/update")
    public String updateBatch(@RequestBody BatchUpdateDTO batchUpdateDTO)
    {
        String course = batchService.updateBatch(batchUpdateDTO);
        return course;

    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteBatch(@PathVariable(value = "id")int id)
    {
        boolean deleteCourse = batchService.deleteBatch(id);
        return "deletedddddd!!!!";

    }

}
