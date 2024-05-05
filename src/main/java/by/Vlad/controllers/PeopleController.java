package by.Vlad.controllers;

import by.Vlad.DAO.PeopleDAO;
import by.Vlad.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    model.addAttribute("peoples", peopleDAO.getAllPeople());

    return "people/peoples";
  }

  @GetMapping("/{id}")
  public String getPeople(@PathVariable int id, Model model) {
    model.addAttribute("people", peopleDAO.getPeopleById(id));
    model.addAttribute("books", peopleDAO.getPeoplesBook(id));
    return "people/people";
  }

  @GetMapping("/new")
  public String newPeople(Model model) {
    model.addAttribute("people", new People());
    return "people/peopleNew";
  }

  @PostMapping("/new")
  public String newPeople(@ModelAttribute("people") People people) {
    peopleDAO.addPeople(people);
    return "redirect:/people";
  }

  @DeleteMapping("/{id}")
  public String deletePeople(@PathVariable int id) {
    peopleDAO.delete(id);
    return "redirect:/people";
  }

  @GetMapping("/{id}/edit")
  public String editPeople(@PathVariable int id, Model model) {
    model.addAttribute("people", peopleDAO.getPeopleById(id));
    return "people/peopleEdit";
  }

  @PatchMapping("/{id}/edit")
  public String updatePeople(@PathVariable int id, @ModelAttribute People people) {
    peopleDAO.update(id, people);
    return "redirect:/people/" + id;
  }
}
