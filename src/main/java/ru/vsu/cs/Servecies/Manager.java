package ru.vsu.cs.Servecies;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import ru.vsu.cs.DAO.IDataBase;
import ru.vsu.cs.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("manager")
public class Manager {
    private IDataBase iDataBase;

    @Autowired
    public Manager(@Qualifier("hibernateRepository") IDataBase iDataBase) {
        this.iDataBase = iDataBase;
    }

    @Transactional
    public List<Book> getBooks() {
        return iDataBase.getBooks();
    }

    @Transactional
    public List<Magazine> getMagazines() {
        return iDataBase.getMagazines();
    }

    @Transactional
    public List<NewsPaper> getNewsPapers() {
        return iDataBase.getNewsPapers();
    }

    @Transactional
    public int addNewPaper(Paper paper) {
        return iDataBase.addPaper(paper);
    }

    @Transactional
    public Paper getPaper(int id) {
        return iDataBase.getPaper(id);
    }

    @Transactional
    public void removePaper(final int id) {
        iDataBase.removeFromBD(iDataBase.getPaper(id));
    }

    @Transactional
    public void editPaper(Paper paper) {
        iDataBase.editProductBD(paper);
    }
}
