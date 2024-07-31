package com.bandeira.biblioteca_online.services;

import com.bandeira.biblioteca_online.dtos.LibrarianRequest;
import com.bandeira.biblioteca_online.dtos.UpdateLibrarianDTO;
import com.bandeira.biblioteca_online.exceptions.LibrarianNotFoundException;
import com.bandeira.biblioteca_online.model.Librarian;
import com.bandeira.biblioteca_online.repositories.LibrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibrarianService {


    @Autowired
    private LibrarianRepository librarianRepository;


    private Librarian registerLibrarian(LibrarianRequest librarianRequest) {

        Librarian librarian = new Librarian(
                librarianRequest.name(),
                librarianRequest.email(),
                librarianRequest.cpf(),
                librarianRequest.accountBank()
        );

        librarianRepository.save(librarian);

        return librarian;
    }


    private String updateLibrarian(UpdateLibrarianDTO updateLibrarianDTO) {
        var librarian = librarianRepository.findByName(updateLibrarianDTO.name());

        if (librarian == null) {
            throw new LibrarianNotFoundException();
        }

        if (updateLibrarianDTO.name() != null) {
            librarian.setName(updateLibrarianDTO.name());
        }

        if (updateLibrarianDTO.email() != null) {
            librarian.setEmail(updateLibrarianDTO.email());
        }

        if (updateLibrarianDTO.cpf() != null) {
            librarian.setCpf(updateLibrarianDTO.cpf());
        }

        if (updateLibrarianDTO.accountBank() != null) {
            librarian.setAccountBank(updateLibrarianDTO.accountBank());
        }

        librarianRepository.save(librarian);

        return "Information updated successfully";
    }


    public void deleteById(Long id) {
        var librarian = librarianRepository.findById(id).orElseThrow(LibrarianNotFoundException::new);
    }


    public Librarian findByName(String name) {
        var librarian = librarianRepository.findByName(name);

        if (librarian == null) {
            throw new LibrarianNotFoundException();
        }
            return librarian;
        }

}
