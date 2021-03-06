package com.library.controller;

import com.library.domain.dto.ReaderDto;
import com.library.mapper.ReaderMapper;
import com.library.service.DbReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/reader")
@RequiredArgsConstructor
public class ReaderController {

    private final DbReaderService readerService;
    private final ReaderMapper readerMapper;

    @PostMapping(value = "addReader", consumes = APPLICATION_JSON_VALUE)
    public void addReader (@RequestBody ReaderDto readerDto) {
        readerService.saveReader(readerMapper.mapToReader(readerDto));
    }

    @GetMapping(value = "getReaders")
    public List<ReaderDto> getReaders() {
        return readerMapper.mapToReaderDtoList(readerService.getAllReaders());
    }
}
