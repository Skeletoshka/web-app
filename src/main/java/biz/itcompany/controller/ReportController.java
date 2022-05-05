package biz.itcompany.controller;

import biz.itcompany.service.ReportService;
import biz.itcompany.view.ContractClientView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping(value ="/client")
    @CrossOrigin
    public ContractClientView get(@RequestBody String id){
        return reportService.getClientContract(Integer.parseInt(id));
    }
}
