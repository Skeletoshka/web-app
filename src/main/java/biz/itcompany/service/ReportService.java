package biz.itcompany.service;

import biz.itcompany.model.Client;
import biz.itcompany.model.Order;
import biz.itcompany.model.Worker;
import biz.itcompany.repository.ClientRepository;
import biz.itcompany.repository.OrderRepository;
import biz.itcompany.repository.WorkerRepository;
import biz.itcompany.view.ContractClientView;
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

    public ContractClientView getClientContract(Integer id){
        ContractClientView contractClientView = new ContractClientView();
        Order order = orderRepository.getOne(id);
        Client client = clientRepository.getOne(order.getClientId());
        List<Worker> workerList = workerRepository.findAll();
        BeanUtils.copyProperties(order, contractClientView);
        BeanUtils.copyProperties(client, contractClientView);
        Worker workerDir = workerList.stream().filter(worker -> worker.getPostId().equals(1) && worker.getWorkerDateEndJob() == null).findFirst().get();
        contractClientView.setWorkerName(workerDir.getWorkerName());
        contractClientView.setWorkerLastName(workerDir.getWorkerLastName());
        contractClientView.setWorkerMiddleName(workerDir.getWorkerMiddleName());
        return contractClientView;
    }
}
