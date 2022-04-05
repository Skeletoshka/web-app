package biz.itcompany.controller;

import biz.itcompany.model.Client;
import biz.itcompany.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value ="/client")
    public String getList(@RequestParam(name = "id", required = false) Integer id, Model model){
        if(id == null) {
            List<Client> clients = clientService.getAll();
            model.addAttribute("listClient", clients);
        }else{
            Client client = clientService.get(id);
            model.addAttribute("listClient", client);
        }
        return "client";
    }
}
