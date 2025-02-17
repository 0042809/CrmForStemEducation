package com.youdev.crmforstemeducation.service;

import com.youdev.crmforstemeducation.model.Test;
import com.youdev.crmforstemeducation.repository.TestRepository;
import com.youdev.crmforstemeducation.exception.ResourceNotFoundException;
import com.youdev.crmforstemeducation.dto.TestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService implements BaseService<Test, Long> {
    private final TestRepository testRepository;
    private final SubjectService subjectService;

    @Override
    public List<Test> findAll() {
        return testRepository.findAll();
    }

    @Override
    public Optional<Test> findById(Long id) {
        return testRepository.findById(id);
    }

    @Transactional
    @Override
    public Test save(Test test) {
        return testRepository.save(test);
    }

    @Transactional
    public Test createTest(TestDTO testDTO) {
        Test test = new Test();
        test.setSubject(subjectService.findById(testDTO.getSubjectId())
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found")));
        test.setTitle(testDTO.getTitle());
        test.setDescription(testDTO.getDescription());
        test.setDuration(testDTO.getDuration());
        test.setMaxScore(testDTO.getMaxScore());
        test.setPassingScore(testDTO.getPassingScore());

        return save(test);
    }

    @Transactional
    public Test update(Long id, TestDTO testDTO) {
        Test test = findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Test not found"));

        test.setTitle(testDTO.getTitle());
        test.setDescription(testDTO.getDescription());
        test.setDuration(testDTO.getDuration());
        test.setMaxScore(testDTO.getMaxScore());
        test.setPassingScore(testDTO.getPassingScore());

        return save(test);
    }

    @Override
    public void delete(Long id) {
        if (!exists(id)) {
            throw new ResourceNotFoundException("Test not found");
        }
        testRepository.deleteById(id);
    }

    @Override
    public boolean exists(Long id) {
        return testRepository.existsById(id);
    }

    public List<Test> findBySubjectId(Long subjectId) {
        return testRepository.findBySubjectId(subjectId);
    }
}