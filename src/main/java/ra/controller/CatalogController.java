package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.model.entity.Catalog;
import ra.model.service.CatalogService;

import java.util.List;

@Controller
@RequestMapping("CatalogController")
public class CatalogController {
    @Autowired
    private CatalogService catalogService;

    @RequestMapping("hello123")
    public String catalog() {
        return "catalog";
    }

    @RequestMapping(value = "getAll")
    public ModelAndView getAllCatalog() {
        ModelAndView mav = new ModelAndView("catalogs");
        List<Catalog> listCatalog = catalogService.findAll();
        mav.addObject("listCatalog", listCatalog);
        return mav;
    }

    @GetMapping("initCreate")
    public String initCreate(Model model) {
//        ModelAndView mav = new ModelAndView("catalogNew");
        Catalog ctNew = new Catalog();
        model.addAttribute("ctNew", ctNew);
        return "catalogNew";
    }

    @PostMapping("create")
    public String createCatalog(@ModelAttribute("ctNew") Catalog ctNew) {
        Catalog catalog = new Catalog(ctNew.getCatalogName(), ctNew.getAge(), ctNew.isSex(), ctNew.getAddress(), ctNew.getBirthDate(), ctNew.isCatalogStatus());
        boolean result = catalogService.save(catalog);
        if (result) {
            return "redirect:getAll";
        } else {
            return "error";
        }
    }

    @GetMapping("initUpdate")
    public String initUpdate(Model model , int catalogId ){
        Catalog ctUpdate = catalogService.findById(catalogId);
        model.addAttribute("ctUpdate",ctUpdate);
        return "catalogUpdate";
    }

    @PostMapping("update")
    public String updateCatalog(Catalog ctUpdate){
        boolean result = catalogService.update(ctUpdate);
        if (result){
            return "redirect:getAll";
        } else {
            return "error";
        }
    }

    @GetMapping("delete")
    public String deleteCatalog(int catalogId){
        boolean result = catalogService.delete(catalogId);
        if (result){
            return "redirect:getAll";
        } else {
            return "error";
        }
    }

    @PostMapping("search")
    public String search(@ModelAttribute("search") String name,Model model ){
       List<Catalog> listCat= catalogService.search(name);
       if (listCat.size()!=0){
           model.addAttribute("listCatalog",listCat);
           return "catalogs";
       }else {
           return "errorFail";
       }
    }

}
