package me.afua.librarydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;

@Controller
public class MainController {

    @Autowired
    BookRepository bookRepo;

    @Autowired
    BorrowingHistoryRepo borrowingHistoryRepo;

    @RequestMapping("/")
    public String showIndex(Model model)
    {
        model.addAttribute("active","link");
        return "index";
    }


    @RequestMapping("/addbooks")
    public void addBooks()
    {
        Book newBook = new Book();
        newBook.setTitle("This is the first book");
        newBook.setAuthor("Test Author");
        newBook.setImage("https://upload.wikimedia.org/wikipedia/commons/8/8f/Whitby_Abbey_image.jpg");
        newBook.setISBN("ISBN 0-471-19047-0");
        bookRepo.save(newBook);

        newBook = new Book();
        newBook.setTitle("This is the second book");
        newBook.setAuthor("Test Author Two");
        newBook.setImage("https://upload.wikimedia.org/wikipedia/commons/3/32/Dreaming_(13687618944).jpg");
        newBook.setISBN("ISBN 0-271-39038-5");
        newBook.setBorrowed(false);
        bookRepo.save(newBook);

        newBook = new Book();
        newBook.setTitle("This is the third book");
        newBook.setAuthor("Test Author Three");
        newBook.setBorrowed(false);
        bookRepo.save(newBook);
    }

    @RequestMapping("/addbook")
    public String addBook()
    {
        return "addform";
    }

    @RequestMapping("/editbook")
    public String editBook()
    {
        Book oldBook = bookRepo.findOne(new Long(1));
        oldBook.setAuthor("Test Author One");
        bookRepo.save(oldBook);
        return "editform";
    }

    @RequestMapping("/borrowbook")
    public String borrowBook(Model model)
    {
        Book oldBook = bookRepo.findOne(new Long(2));
        oldBook.setBorrowed(true);
        oldBook.setLastborrowed(new Date());
        bookRepo.save(oldBook);
        model.addAttribute("booklist",bookRepo.findAll());
        model.addAttribute("displaymsg",oldBook.getTitle()+" has been borrowed");
        return "list";
    }
    @RequestMapping("/borrow/{id}")
    public String borrowBook(Model model, @PathVariable("id") String theBookId)
    {
        if(theBookId!=null)
        {
            Book oldBook = bookRepo.findOne(new Long(theBookId));
            oldBook.setBorrowed(true);
            oldBook.setLastborrowed(new Date());
            oldBook.addToBorrowed();
            bookRepo.save(oldBook);

            model.addAttribute("booklist",bookRepo.findAll());
            model.addAttribute("displaymsg",oldBook.getTitle()+" has been borrowed");
            BorrowingHistory bH = new BorrowingHistory(oldBook);
            bH.setDescription("borrowed");
            borrowingHistoryRepo.save(bH);
            model.addAttribute("active","list");
            return "list";
        }
        else{
            return "redirect:/listbooks";
        }
    }

    @RequestMapping("/return/{id}")
    public String returnBook(Model model, @PathVariable("id") String theBookId)
    {

        if(theBookId!=null)
        {
            Book oldBook = bookRepo.findOne(new Long(theBookId));
            oldBook.setBorrowed(false);
            oldBook.setLastborrowed(new Date());
            bookRepo.save(oldBook);
            model.addAttribute("booklist",bookRepo.findAll());
            model.addAttribute("displaymsg",oldBook.getTitle()+" has been returned");
            model.addAttribute("active","list");
            return "list";
        }
        else
            return "redirect:/listbooks";


    }

    @RequestMapping("/returnbook")
    public String returnBook(Model model)
    {
        Book oldBook = bookRepo.findOne(new Long(2));
        oldBook.setBorrowed(false);
        bookRepo.save(oldBook);
        model.addAttribute("booklist",bookRepo.findAll());
        model.addAttribute("displaymsg",oldBook.getTitle()+" has been returned");
        return "list";
    }

    @RequestMapping("/showpopularbooks")
    public String popularBooks(Model model)
    {
        model.addAttribute("booklist",bookRepo.findAllByOrderByBorrowedtimesDesc());
        model.addAttribute("displaymsg","Books ordered by popularity");
        model.addAttribute("active","popular");
        return "list";
    }

    @RequestMapping("/listbooks")
    public String showBooks(Model model)
    {
        addBooks();
        model.addAttribute("booklist",bookRepo.findAll());
        model.addAttribute("displaymsg","This page lists all books in the library");
        /*
            Sets the value of the active variable in the navigation bar to 'list', so that the
            appropriate option is highlighted
        */
        model.addAttribute("active","list");
        return "list";
    }

    @RequestMapping("/availablebooks")
    public String showAvailable(Model model)
    {
        model.addAttribute("booklist",bookRepo.findAllByBorrowed(false));
        model.addAttribute("active","available");
        return "list";
    }
    @RequestMapping("/borrowedbooks")
    public String showBorrowed(Model model)
    {
        model.addAttribute("booklist",bookRepo.findAllByBorrowed(true));
        model.addAttribute("active","borrowed");
        return "list";
    }

    @RequestMapping("/showhistory")
    public String bookHistory(Model model)
    {
        model.addAttribute("history",borrowingHistoryRepo.findAll());
        return "history";
    }


    @RequestMapping("/showhistory/{id}")
    public String bookHistory(Model model, @PathVariable("id") String bookId)
    {

        model.addAttribute("history",borrowingHistoryRepo.findAllByABook(bookRepo.findOne(new Long(bookId))));
        return "history";
    }

    @GetMapping("/add")
    public String showAddBookForm(Model model)
    {
        model.addAttribute("aBook",new Book());
        return "add";
    }

    @PostMapping("/addbook")
    public String addABook(@Valid@ModelAttribute("aBook") Book bookToSave, BindingResult result)
    {
        if(!result.hasErrors())
        {
            bookRepo.save(bookToSave);
            return "redirect:/listbooks";
        }

        else{
            System.out.println("Year of publication"+bookToSave.getYearPub());
            return "add";
        }

    }

}
