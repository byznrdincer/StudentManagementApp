package com.lbs.Studentmanagementapp.service.IMPL;

import com.lbs.Studentmanagementapp.dto.BatchDTO;
import com.lbs.Studentmanagementapp.dto.BatchSaveDTO;
import com.lbs.Studentmanagementapp.dto.BatchUpdateDTO;
import com.lbs.Studentmanagementapp.entity.Batch;
import com.lbs.Studentmanagementapp.entity.Course;
import com.lbs.Studentmanagementapp.repo.BatchRepo;
import com.lbs.Studentmanagementapp.repo.CourseRepo;
import com.lbs.Studentmanagementapp.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BatchServiceIMPL implements BatchService {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private BatchRepo batchRepo;

    @Override
    public String addBatch(BatchSaveDTO batchSaveDTO) {
        Optional<Course> course = courseRepo.findById(batchSaveDTO.getCourseid());
        if (!course.isPresent()) {
            return "Course not found";
        }

        Batch batch = new Batch(
                batchSaveDTO.getBatchname(),
                batchSaveDTO.getStartdate(),
                course.get()
        );
        batchRepo.save(batch);
        return batch.getBatchname();
    }

    @Override
    public List<BatchDTO> getAllBatches() {
        List<Batch> getBatches = batchRepo.findAll();
        List<BatchDTO> batchDTOList = new ArrayList<>();
        for (Batch batch : getBatches) {
            BatchDTO batchDTO = new BatchDTO(
                    batch.getBatchid(),
                    batch.getBatchname(),
                    batch.getCourse(),
                    batch.getStartdate()
            );
            batchDTOList.add(batchDTO);
        }
        return batchDTOList;
    }

    @Override
    public String updateBatch(BatchUpdateDTO batchUpdateDTO) {
        Optional<Batch> batchOptional = batchRepo.findById(batchUpdateDTO.getBatchid());
        if (!batchOptional.isPresent()) {
            return "Batch ID not found";
        }

        Batch batch = batchOptional.get();
        batch.setBatchname(batchUpdateDTO.getBatchname());
        Optional<Course> course = courseRepo.findById(batchUpdateDTO.getCourseid());
        if (!course.isPresent()) {
            return "Course ID not found";
        }
        batch.setCourse(course.get());
        batch.setStartdate(batchUpdateDTO.getStartdate());

        batchRepo.save(batch);
        return batch.getBatchname();
    }

    @Override
    public boolean deleteBatch(int id) {
        Optional<Batch> batchOptional = batchRepo.findById(id);
        if (!batchOptional.isPresent()) {
            return false;
        }

        batchRepo.deleteById(id);
        return true;
    }
}
