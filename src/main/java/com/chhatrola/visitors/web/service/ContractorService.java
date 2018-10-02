package com.chhatrola.visitors.web.service;


import com.chhatrola.visitors.util.ResponseUtil;
import com.chhatrola.visitors.web.model.*;
import com.chhatrola.visitors.web.repository.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

@Service("contractorService")
public class ContractorService {
//
//    String create(Authoriser contractorView);
//
//    List<Contractor> fetchSignedInContractors(Long authoriserId);
//
//    List<Contractor> fetchSignedOutContractors(Long authoriserId);
//
//    String contractorSignOut(Authoriser authoriser);

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ContractorRepository contractorRepository;

    @Autowired
    VendorRepository vendorRepository;

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    JobTypeRepository jobTypeRepository;

    @Autowired
    ContractorVisitRepository contractorVisitRepository;

    public ResponseEntity<Response> createContractor(RequestData requestData) throws JsonProcessingException, ParseException {

        Contractor contractor = contractorRepository.findByContractorIdNumber(requestData.getContractorIdNumber());
        if(contractor==null){
            Contractor contractorToBeCreated = new Contractor();
//            contractorToBeCreated.setContractorIdExpDate(DateFormat.getDateInstance().parse(requestData.getContractorIdExpIDDate()));
            contractorToBeCreated.setContractorIdNumber(requestData.getContractorIdNumber());
            contractorToBeCreated.setContractorIdType(requestData.getContractorIdType());
            contractorToBeCreated.setContractorName(requestData.getContractorName());
            contractor = contractorRepository.save(contractorToBeCreated);
        }

        ContractorVisit contractorVisit = new ContractorVisit();
        contractorVisit.setContractor(contractor);
        contractorVisit.setBranch(branchRepository.getOne(requestData.getBranchCode()));
        contractorVisit.setEmployee(employeeRepository.findOne(requestData.getEmpId()));
        contractorVisit.setJobType(jobTypeRepository.findOne(requestData.getJobCode()));
        contractorVisit.setVisitInTime(new Date());
        contractorVisit.setHazardRegViewed(requestData.getHazardRegViewed());
        contractorVisit.setVendor(vendorRepository.findOne(requestData.getVendorId()));
        contractorVisit = contractorVisitRepository.save(contractorVisit);

        ResponseData responseData = new ResponseData();
        responseData.setContractorVisitId(contractorVisit.getContactorVisitId());
        return ResponseUtil.prepareResponse(ResponseStatus.CONTRACTOR_VISIT_SUCCESSFULLY_CREATED, responseData);
    }
}
