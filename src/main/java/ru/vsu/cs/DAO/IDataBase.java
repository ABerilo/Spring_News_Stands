package ru.vsu.cs.DAO;

import ru.vsu.cs.Models.*;

import java.util.List;

public interface IDataBase {
    List<Book> getBooks();

    List<Magazine> getMagazines();

    List<NewsPaper> getNewsPapers();

    List<Paper> getAllPaper();

    Paper getPaper(final int id);

    int addPaper(Paper paper);

    void editProductBD(Paper paper);

    void removeFromBD(Paper paper);
}
