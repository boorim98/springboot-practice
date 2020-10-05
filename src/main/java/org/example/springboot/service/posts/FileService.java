package org.example.springboot.service.posts;

import org.example.springboot.domain.posts.Files;
import org.example.springboot.domain.posts.FilesRepository;
import org.example.springboot.web.dto.FileDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FileService {
    private FilesRepository filesRepository;

    public FileService(FilesRepository filesRepository) {
        this.filesRepository = filesRepository;
    }

    @Transactional
    public Long saveFile(FileDto fileDto) {
        return filesRepository.save(fileDto.toEntity()).getId();
    }

    @Transactional
    public FileDto getFile(Long id) {
        Files file = filesRepository.findById(id).get();

        FileDto fileDto = FileDto.builder()
                .id(id)
                .origFilename(file.getOrigFilename())
                .filename(file.getFilename())
                .filePath(file.getFilePath())
                .build();
        return fileDto;
    }
}
