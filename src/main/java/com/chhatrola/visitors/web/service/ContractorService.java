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
import java.util.List;

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
        contractorVisit.setSignedOut("true");
        contractorVisit = contractorVisitRepository.save(contractorVisit);

        ResponseData responseData = new ResponseData();
        responseData.setContractorVisitId(contractorVisit.getContactorVisitId());
        return ResponseUtil.prepareResponse(ResponseStatus.CONTRACTOR_VISIT_SUCCESSFULLY_CREATED, responseData);
    }

    public ResponseEntity<Response> fetchSignedInContractors(RequestData requestData) throws JsonProcessingException{
        List<ContractorVisit> signedInContractor = contractorVisitRepository.findByEmployee_employeeIdAndSignedOutAndBranch_BranchCode(requestData.getEmpId(), "true", requestData.getBranchCode());
        if(signedInContractor == null || signedInContractor.isEmpty()){
            return ResponseUtil.prepareResponse(ResponseStatus.NO_SIGNED_IN_CONTRACTORS, "");
        }
        ResponseData responseData = new ResponseData();
        responseData.setContractorVisitList(signedInContractor);
        return ResponseUtil.prepareResponse(ResponseStatus.SUCCESSFULLY_FETCHED_SIGND_IN_CONTRACTORS, responseData);
    }

    public ResponseEntity<Response> fetchSignedOutContractors(RequestData requestData) throws JsonProcessingException{
        List<ContractorVisit> signedInContractor = contractorVisitRepository.findByEmployee_employeeIdAndSignedOutAndBranch_BranchCode(requestData.getEmpId(), "false", requestData.getBranchCode());
        if(signedInContractor == null || signedInContractor.isEmpty()){
            return ResponseUtil.prepareResponse(ResponseStatus.NO_SIGNED_OUT_CONTRACTORS, "");
        }
        ResponseData responseData = new ResponseData();
        responseData.setContractorVisitList(signedInContractor);
        return ResponseUtil.prepareResponse(ResponseStatus.SUCCESSFULLY_FETCHED_SIGND_OUT_CONTRACTORS, responseData);
    }

    public ResponseEntity<Response> contractorSignOut(RequestData requestData) throws JsonProcessingException{
        List<ContractorVisit> contractorVisits = contractorVisitRepository.findByContractor_ContractorIdAndEmployee_employeeIdAndSignedOutAndBranch_BranchCode(requestData.getContractorId(), requestData.getEmpId(), "true", requestData.getBranchCode());
        for(ContractorVisit contractorVisit : contractorVisits){
            contractorVisit.setSignedOut("false");
            contractorVisit.setVisitOutTime(new Date());
            contractorVisitRepository.save(contractorVisit);
        }
        return ResponseUtil.prepareResponse(ResponseStatus.CONTRACTOR_SUCCESSFULLY_SIGNED_OUT, "");
    }
}
