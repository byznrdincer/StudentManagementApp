package com.lbs.Studentmanagementapp.service;

import com.lbs.Studentmanagementapp.dto.BatchDTO;
import com.lbs.Studentmanagementapp.dto.BatchSaveDTO;
import com.lbs.Studentmanagementapp.dto.BatchUpdateDTO;

import java.util.List;

public interface BatchService {
    String addBatch(BatchSaveDTO batchSaveDTO);

    List<BatchDTO> getAllBatches();

    String updateBatch(BatchUpdateDTO batchUpdateDTO);

    boolean deleteBatch(int id);
}
