package com.example.onetomanydemo.service;

import com.example.onetomanydemo.dao.AuthorDao;
import com.example.onetomanydemo.dao.BookDao;
import com.example.onetomanydemo.entity.Author;
import com.example.onetomanydemo.entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    private final AuthorDao authorDao;
    private final BookDao bookDao;

    public BookService(AuthorDao authorDao, BookDao bookDao) {
        this.authorDao = authorDao;
        this.bookDao = bookDao;
    }

    public void newThreeBooksWithoutAuthor(){
        Book book1 = new Book("A Tale of Two Cities",44,"Novel");
        Book book2 = new Book("Black Arrow",44,"Novel");
        Book book3 = new Book("Return of The Native",44,"Novel");

        bookDao.save(book1);
        bookDao.save(book2);
        bookDao.save(book3);

    }


    private Author getAuthorByName() {
        return authorDao.findAuthorByName("Ishiguro");
    }


    @Transactional
    public void addNewBookWithExistingAuthor(){
        Author author = getAuthorByName();
        author.addBook(new Book("Clara and Sun",30,"Sci-Fi"));
    }


    @Transactional
    public void removeFirstBookFromExistingAuthor(){
        Author author = getAuthorByName();
        author.removeBook(author.getBooks().get(0));

    }

    @Transactional
    public void removeLastBookFromExistingAuthor(){
        Author author = getAuthorByName();
        author.removeBook(author.getBooks().get(author.getBooks().size()-1));
    }


    @Transactional
    public void saveAuthorWithThreeBooks(){
        Author author = new Author();
        author.setName("Ishiguro");
        Book book1 = new Book("A pale view of hill",35.3,"Novel");
        Book book2 = new Book("Don't let me go",30,"Novel");
        Book book3 = new Book("The remains of a day",35.6,"Novel");

        author.addBook(book1);
        author.addBook(book2);
        author.addBook(book3);

        authorDao.save(author);

    }
}
