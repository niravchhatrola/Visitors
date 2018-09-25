//package com.infosys.branchvisit.web.service.impl;
//
//import com.infosys.branchvisit.web.model.Authoriser;
//import com.infosys.branchvisit.web.repository.AuthoriserRepository;
//import com.infosys.branchvisit.web.service.AuthoriserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.List;
//import java.util.UUID;
//
///**
// * Created by niv214 on 27/8/17.
// */
//@Service("authoriserService")
//@Transactional
//public class AuthoriserServiceImpl implements AuthoriserService {
//
//    @Autowired
//    AuthoriserRepository authoriserRepository;
//
//
//    @Override
//    public Authoriser loginService(Authoriser authoriserView) {
//        List<Authoriser> authorisers = authoriserRepository.findByUserName(authoriserView.getUserName());
//        UUID uuid = UUID.randomUUID();
//        if(authorisers.size()!=1){
//            return null;
//        }
//        Authoriser authoriser = authorisers.get(0);
//        authoriser.setAuthToken(uuid.toString());
//        authoriserRepository.save(authoriser);
//        return  authoriser;
//    }
//
//    @Override
//    public String logoutService(Authoriser authoriserView) {
//        Authoriser authoriser = authoriserRepository.getOne(authoriserView.getId());
//        authoriser.setAuthToken(null);
//        authoriserRepository.save(authoriser);
//        return "Successfully logged out.";
//    }
//}
