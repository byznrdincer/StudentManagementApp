package com.lbs.Studentmanagementapp.controller;

import com.lbs.Studentmanagementapp.dto.BatchDTO;
import com.lbs.Studentmanagementapp.dto.BatchSaveDTO;
import com.lbs.Studentmanagementapp.dto.BatchUpdateDTO;
import com.lbs.Studentmanagementapp.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/batch")
public class BatchController {

    @Autowired
    private BatchService batchService;

    @PostMapping(path = "/save")
    public ResponseEntity<String> saveBatch(@RequestBody BatchSaveDTO batchSaveDTO) {
        // DTO verilerini logla
        System.out.println("Saving Batch: " + batchSaveDTO);

        String batchResponse = batchService.addBatch(batchSaveDTO);
        return new ResponseEntity<>(batchResponse, HttpStatus.CREATED);
    }

    @GetMapping("/getAllBatches")
    public List<BatchDTO> getAllBatches() {
        return batchService.getAllBatches();
    }

    @PutMapping(path = "/update")
    public ResponseEntity<String> updateBatch(@RequestBody BatchUpdateDTO batchUpdateDTO) {
        // DTO verilerini logla
        System.out.println("Updating Batch with ID: " + batchUpdateDTO.getBatchid());

        String updateResponse = batchService.updateBatch(batchUpdateDTO);
        return new ResponseEntity<>(updateResponse, HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteBatch(@PathVariable(value = "id") int id) {
        boolean isDeleted = batchService.deleteBatch(id);
        return isDeleted
                ? new ResponseEntity<>("Batch deleted successfully!", HttpStatus.OK)
                : new ResponseEntity<>("Batch not found!", HttpStatus.NOT_FOUND);
    }
}