package com.chhatrola.visitors.web.service;


import com.chhatrola.visitors.util.ResponseUtil;
import com.chhatrola.visitors.web.model.*;
import com.chhatrola.visitors.web.repository.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service("contractorService")
public class ContractorService {


    private static final String SIGNATURE_PATH = "/home/niv214/signature/";
    private static final String DOCUMENT_PATH = "/home/niv214/document/";

    @Autowired
    DocumentRepository documentRepository;

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

    public ResponseEntity<Response> searchContractor(RequestData requestData) throws JsonProcessingException{
//        List<ContractorVisit> contractorVisits = contractorVisitRepository.findByContractor_ContractorIdAndEmployee_employeeIdAndSignedOutAndBranch_BranchCode(requestData.getContractorId(), requestData.getEmpId(), "true", requestData.getBranchCode());
//        for(ContractorVisit contractorVisit : contractorVisits){
//            contractorVisit.setSignedOut("false");
//            contractorVisit.setVisitOutTime(new Date());
//            contractorVisitRepository.save(contractorVisit);
//        }


        ContractorVisit contractorVisit = new ContractorVisit();
//        contractorVisit.setEmployee(employeeRepository.findOne(requestData.getEmpId()));
        contractorVisit.setVendor(vendorRepository.findOne(requestData.getVendorId()));
        contractorVisit.setBranch(branchRepository.findOne(requestData.getBranchCode()));
        contractorVisit.setContractor(contractorRepository.findByContractorName(requestData.getContractorName()));
        contractorVisit.setJobType(jobTypeRepository.findOne(requestData.getJobCode()));
        Example<ContractorVisit> contractorVisitExample = Example.of(contractorVisit);

//        matcher.getPropertySpecifiers().getSpecifiers().
        List<ContractorVisit> all = contractorVisitRepository.findAll(contractorVisitExample);
//        List<Contractor> contractors = all.stream().map(ContractorVisit::getContractor).collect(Collectors.toList());

//        ExampleMatcher.PropertySpecifiers propertySpecifiers = contractorVisitExample.getMatcher().getPropertySpecifiers();
//        propertySpecifiers.add(new ExampleMatcher.PropertySpecifier().);
        ResponseData responseData = new ResponseData();
        responseData.setContractorVisitList(all);
        return ResponseUtil.prepareResponse(ResponseStatus.CONTRACTOR_SUCCESSFULLY_SIGNED_OUT, responseData);
    }

    public ResponseEntity<Response> uploadSignature(MultipartFile[] files, Long documentId) throws IOException {
        Document document = documentRepository.findOne(documentId);
        if(document == null){
            return ResponseUtil.prepareResponse(ResponseStatus.SIGNATURE_SUCCESSFULLY_UPLOADED, "");
        }

        for(MultipartFile file : files){
            String filePath = SIGNATURE_PATH+documentId;
            file.transferTo(new File("resources/"+documentId+".png"));
        }

        return ResponseUtil.prepareResponse(ResponseStatus.SIGNATURE_SUCCESSFULLY_UPLOADED, "");
    }
}
