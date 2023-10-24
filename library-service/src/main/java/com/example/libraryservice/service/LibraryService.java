package com.example.libraryservice.service;

import com.example.libraryservice.dto.LibraryDto;
import com.example.libraryservice.exception.LibraryNotFoundException;
import com.example.libraryservice.model.Library;
import com.example.libraryservice.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public LibraryDto getAllBooksInLibraryById(String id) {
        Library library = libraryRepository.findById(id).
                orElseThrow(() -> new LibraryNotFoundException("Library not found " + id));
        return new LibraryDto(Objects.requireNonNull(library.getId()));
    }

    public LibraryDto createLibrary() {
        Library newLibrary = libraryRepository.save(new Library());
        return new LibraryDto(Objects.requireNonNull(newLibrary.getId()));
    }

}
