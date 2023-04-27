package org.soneech.service;

import lombok.RequiredArgsConstructor;
import org.soneech.models.Author;
import org.soneech.repository.AuthorRepository;
import org.soneech.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private AuthorRepository authorRepository;
    private GameRepository gameRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository, GameRepository gameRepository) {
        this.authorRepository = authorRepository;
        this.gameRepository = gameRepository;
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(int id) {
        return authorRepository.findById(id);
    }

    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    public void deleteAuthor(Author author) {
        gameRepository.deleteAll(author.getGames());
        authorRepository.delete(author);
    }

    public void updateAuthor(int id, Author updatedAuthor) {
        Author author = getAuthorById(id);
        author.setNickname(updatedAuthor.getNickname());
        author.setBirthDate(updatedAuthor.getBirthDate());
        addAuthor(author);
    }

    public List<Author> orderedAuthorsByNickname() {
        return authorRepository.findAll(Sort.by("nickname"));
    }

    public List<Author> orderedAuthorsByBirthDate() {
        return authorRepository.findAll(Sort.by("birthDate"));
    }
}
