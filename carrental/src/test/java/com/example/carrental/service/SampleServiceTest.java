package com.example.carrental.service;

import com.example.carrental.model.Sample;
import com.example.carrental.repository.SampleRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleServiceTest {

    @Autowired
    private SampleService sampleService;

    @Autowired
    private SampleRepository sampleRepository;

    @Test
    public void testSaveSample() {
        // Given
        Sample sample = new Sample();
        sample.setPlateNumber("11AA22");

        // When
        sample = sampleRepository.saveAndFlush(sample);

        // Then
        Optional<Sample> opt = sampleService.getOne(sample.getPlateNumber());
        Assert.assertNotNull(sample.getId());
        Assert.assertEquals(opt.get().getPlateNumber(), "11AA22");
    }
}
