package biz.itcompany.service;

import biz.itcompany.model.Client;
import biz.itcompany.model.Company;
import biz.itcompany.model.Order;
import biz.itcompany.model.Worker;
import biz.itcompany.repository.*;
import biz.itcompany.view.ContractClientView;
import biz.itcompany.view.ContractWorkerView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private PostRepository postRepository;

    public ContractClientView getClientContract(Integer id){
        ContractClientView contractClientView = new ContractClientView();
        Order order = orderRepository.getOne(id);
        Client client = clientRepository.getOne(order.getClientId());
        List<Worker> workerList = workerRepository.findAll();
        Company company = companyRepository.getOne(1);
        BeanUtils.copyProperties(order, contractClientView);
        BeanUtils.copyProperties(client, contractClientView);
        BeanUtils.copyProperties(company, contractClientView);
        Worker workerDir = workerList.stream().filter(worker -> worker.getPostId().equals(1) && worker.getWorkerDateEndJob() == null).findFirst().get();
        contractClientView.setWorkerName(workerDir.getWorkerName());
        contractClientView.setWorkerLastName(workerDir.getWorkerLastName());
        contractClientView.setWorkerMiddleName(workerDir.getWorkerMiddleName());
        return contractClientView;
    }

    public ContractWorkerView getWorkerClient(Integer id){
        ContractWorkerView contractWorkerView = new ContractWorkerView();
        Worker worker = workerRepository.getOne(id);
        List<Worker> workerList = workerRepository.findAll();
        Worker workerDir = workerList.stream().filter(workerD -> workerD.getPostId().equals(1) && workerD.getWorkerDateEndJob() == null).findFirst().get();
        Company company = companyRepository.getOne(1);
        BeanUtils.copyProperties(company, contractWorkerView);
        BeanUtils.copyProperties(worker, contractWorkerView);
        contractWorkerView.setDirName(workerDir.getWorkerName());
        contractWorkerView.setDirLastName(workerDir.getWorkerLastName());
        contractWorkerView.setDirMiddleName(workerDir.getWorkerMiddleName());
        contractWorkerView.setPostName(postRepository.getOne(worker.getPostId()).getPostName());
        return contractWorkerView;
    }
}
