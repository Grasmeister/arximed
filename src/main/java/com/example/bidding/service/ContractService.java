package com.example.bidding.service;

import com.example.bidding.model.contract.Contract;
import com.example.bidding.model.contract.ContractForm;
import com.example.bidding.repository.ContractEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {
    @Autowired
    private ContractEntityRepository contractEntityRepository;

    public List<Contract> listAll() {
        return contractEntityRepository.findAll();
    }

    public Contract createContract(ContractForm contractForm) {
        Contract contract = new Contract();
        contract.setContractId(contractForm.getContractId());
        contract.setContractAmount(contractForm.getContractAmount());
        contract.setPurchaseAmount(contractForm.getPurchaseAmount());
        contract.setContractEndDate(contractForm.getTimeContractEnd());
        contract.setDateAuction(contractForm.getTimeAuction());
        contract.setClient(contractForm.getClient());
        contract.setStatusEnum(contractForm.getStatusEnum());

        Contract contract1 = contractEntityRepository.save(contract);

        return contract1;
    }
}
