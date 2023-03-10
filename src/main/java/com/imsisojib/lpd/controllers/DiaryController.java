package com.imsisojib.lpd.controllers;

import com.imsisojib.lpd.models.entities.Address;
import com.imsisojib.lpd.models.entities.Diary;
import com.imsisojib.lpd.models.entities.User;
import com.imsisojib.lpd.models.responses.Response;
import com.imsisojib.lpd.repositories.AddressRepository;
import com.imsisojib.lpd.repositories.DiaryRepository;
import com.imsisojib.lpd.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/diary")
public class DiaryController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    DiaryRepository diaryRepository;

    @Autowired
    AddressRepository addressRepository;

    @PostMapping("/create")
    public ResponseEntity<?> createDiary(@RequestBody Diary diary) {
        var result = diaryRepository.save(diary);
        return ResponseEntity.ok(
                new Response<Diary>(
                        "Successful!",
                        result
                )
        );
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAllDiary() {
        return ResponseEntity.ok(
                new Response(
                        "Successful!",
                        diaryRepository.findAll()
                )
        );
    }

}
