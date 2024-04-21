package by.Vlad.controllers;

import by.Vlad.DAO.PeopleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleController {
  private PeopleDAO peopleDAO;

  @Autowired
  public PeopleController(PeopleDAO peopleDAO) {
    this.peopleDAO = peopleDAO;
  }

  @GetMapping
  public String getPeoples(Model model) {
    model.addAttribute("peoples",peopleDAO.getAllPeople());
    return "peoples";
  }

  @GetMapping("/${id}")
  public String getPeople(@PathVariable int id, Model model) {
    model.addAttribute("people",peopleDAO.getPeopleById(id));
    return "people";
  }
}
