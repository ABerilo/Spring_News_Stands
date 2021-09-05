package ru.vsu.cs.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.vsu.cs.Models.Book;
import ru.vsu.cs.Models.Magazine;
import ru.vsu.cs.Models.NewsPaper;
import ru.vsu.cs.Models.Paper;

import java.util.List;

@Repository
public class HibernateRepository implements IDataBase {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> getBooks() {
        Session session = getSession();
        return session.createQuery("from Book ").list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Magazine> getMagazines() {
        Session session = getSession();
        return session.createQuery("from Magazine").list();
    }

    @Override
    public List<NewsPaper> getNewsPapers() {
        Session session = getSession();
        return session.createQuery("from NewsPaper").list();
    }

    @Override
    public List<Paper> getAllPaper() {
        Session session = getSession();
        return session.createQuery(" from Paper").list();
    }

    @Override
    public Paper getPaper(int id) {
        List<Paper> papers = getAllPaper();
        return papers.stream().filter(paper -> paper.getId() == id).findAny().orElse(null);
    }

    @Override
    public void addPaper(Paper paper) {
        Session session = getSession();
        session.save(paper);
    }

    @Override
    public void editProductBD(Paper paper) {
        Session session = getSession();
        session.update(paper);
    }


    @Override
    public void removeFromBD(Paper paper) {
        Session session = getSession();
        session.delete(paper);
    }
}
