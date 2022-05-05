package biz.itcompany.controller;

import biz.itcompany.service.ReportService;
import biz.itcompany.view.ContractClientView;
import biz.itcompany.view.ContractWorkerView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping(value ="/client")
    @CrossOrigin
    public ContractClientView getClient(@RequestBody String id){
        return reportService.getClientContract(Integer.parseInt(id));
    }

    @PostMapping(value ="/worker")
    @CrossOrigin
    public ContractWorkerView getWorker(@RequestBody String id){
        return reportService.getWorkerClient(Integer.parseInt(id));
    }
}
