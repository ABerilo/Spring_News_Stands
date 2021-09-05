import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.vsu.cs.Controllers.BookController;
import ru.vsu.cs.Controllers.MagazineController;
import ru.vsu.cs.Controllers.NewsPaperController;
import ru.vsu.cs.Models.Book;
import ru.vsu.cs.Models.Magazine;
import ru.vsu.cs.Models.NewsPaper;
import ru.vsu.cs.Models.Paper;
import ru.vsu.cs.config.Config;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = Config.class)
@WebAppConfiguration
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductsTest {
    @Autowired
    private BookController bookController;
    @Autowired
    private MagazineController magazineController;
    @Autowired
    private NewsPaperController newspaperController;
    private final Book book = new Book("Atlas Shrugged", "Ayn Rand", "Random House", 1168);
    private final Magazine magazine = new Magazine("Kinfolk", 9, "2018-10-10", 26);
    private final NewsPaper newspaper = new NewsPaper("Newspaper", 6, "2000-05-18");


    @Test
    @Order(1)
    public void createBookTest() {
        int id = bookController.createBook(book);
        Paper product = bookController.show(id);
        Assertions.assertEquals(book, product);
    }

    @Test
    @Order(2)
    public void createMagazineTest() {
        int id = magazineController.createMagazine(magazine);
        Paper product = magazineController.show(id);
        Assertions.assertEquals(magazine, product);
    }

    @Order(3)
    @Test
    public void createNewspaperTest() {
        int id = newspaperController.createNewsPaper(newspaper);
        Paper product = newspaperController.show(id);
        Assertions.assertEquals(newspaper, product);
    }


    @Order(4)
    @Test
    public void deleteBookTest() {
        int id = bookController.createBook(book);
        bookController.delete(id);
        Paper product = bookController.show(id);
        Assertions.assertNull(product);
    }

    @Order(5)
    @Test
    public void deleteMagazineTest() {
        int id = magazineController.createMagazine(magazine);
        magazineController.delete(id);
        Paper product = magazineController.show(id);
        Assertions.assertNull(product);
    }

    @Order(6)
    @Test
    public void deleteNewsPaperTest() {
        int id = newspaperController.createNewsPaper(newspaper);
        newspaperController.delete(id);
        Paper product = newspaperController.show(id);
        Assertions.assertNull(product);
    }

    @Order(7)
    @Test
    public void showBooksTest() {
        List<Paper> bookList = new ArrayList<>();
        bookList.add(book);
        Assertions.assertEquals(bookList, bookController.showBook());
    }

    @Order(8)
    @Test
    public void showMagazinesTest() {
        List<Paper> magazineList = new ArrayList<>();
        magazineList.add(magazine);
        Assertions.assertEquals(magazineList, magazineController.showMagazine());
    }

    @Order(9)
    @Test
    public void showNewspaperTest() {
        List<Paper> newspaperList = new ArrayList<>();
        newspaperList.add(newspaper);
        Assertions.assertEquals(newspaperList, newspaperController.showNewsPaper());
    }

    @Order(10)
    @Test
    public void editBookTest() {
        int idBook = bookController.createBook(book);
        book.setNumPages(123456);
        book.setPublishingHouse("newPH");
        book.setAuthor("NewAuthor");
        bookController.updateBook(idBook, book);
        Assertions.assertEquals(book, bookController.show(idBook));
    }

    @Order(11)
    @Test
    public void editMagazineTest() {
        int idMagazine = magazineController.createMagazine(magazine);
        magazine.setName("newMagazineName");
        magazine.setNumPages(1234567);
        magazine.setNumber(666);
        magazine.setDate("2000-12-12");
        magazineController.updateMagazine(idMagazine, magazine);
        Assertions.assertEquals(magazine, magazineController.show(idMagazine));
    }

    @Test
    @Order(12)
    public void editNewspaperTest() {
        int idNewspaper = newspaperController.createNewsPaper(newspaper);
        newspaper.setName("newNewsPaperName");
        newspaper.setNumber(666);
        newspaper.setDate("2000-12-12");
        newspaperController.updateNewsPaper(idNewspaper, newspaper);
        Assertions.assertEquals(newspaper, newspaperController.show(idNewspaper));
    }
}
