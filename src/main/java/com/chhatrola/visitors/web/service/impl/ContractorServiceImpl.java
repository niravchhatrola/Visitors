//package com.infosys.branchvisit.web.service.impl;
//
//import com.infosys.branchvisit.web.model.Authoriser;
//import Contractor;
//import com.infosys.branchvisit.web.repository.AuthoriserRepository;
//import ContractorRepository;
//import com.infosys.branchvisit.web.service.ContractorService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
///**
// * Created by niv214 on 27/8/17.
// */
//@Service("contractorService")
//@Transactional
//public class ContractorServiceImpl implements ContractorService {
//
//    @Autowired
//    ContractorRepository contractorRepository;
//
//    @Autowired
//    AuthoriserRepository authoriserRepository;
//
//    @Override
//    public String create(Authoriser authoriser){
//        Authoriser authoriserToBeUpdated = authoriserRepository.getOne(authoriser.getId());
//        List<Contractor> contractorList = authoriser.getContractorList();
//        if(contractorList == null || contractorList.size() != 1){
//            return "Error while creating Contractor";
//        }
//        Contractor contractor = authoriser.getContractorList().get(0);
//        authoriserToBeUpdated.getContractorList().add(contractor);
//        authoriserRepository.save(authoriserToBeUpdated);
//        return "Contractor Successfully Created";
//    }
//
//    @Override
//    public List<Contractor> fetchSignedInContractors(Long authoriserId){
//        return contractorRepository.findByAuthoriserIdAndSignedOut(authoriserId, "N");
//    }
//
//    @Override
//    public List<Contractor> fetchSignedOutContractors(Long authoriserId){
//        return contractorRepository.findByAuthoriserIdAndSignedOut(authoriserId, "Y");
//    }
//
//    @Override
//    public String contractorSignOut(Authoriser authoriser){
//        Contractor signOutContractor = contractorRepository.findByAuthoriserIdAndContractorId(1l, 1l);
//        if(signOutContractor == null){
//            return "No Contractor found of this details";
//        }
////        signOutContractor.setVisitOutTime(new Date());
//        contractorRepository.save(signOutContractor);
//        return "Contractor successfully signed out";
//    }
//}
