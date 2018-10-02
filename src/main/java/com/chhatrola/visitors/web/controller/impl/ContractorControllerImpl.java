package com.chhatrola.visitors.web.controller.impl;

import com.chhatrola.visitors.web.model.RequestData;
import com.chhatrola.visitors.web.model.Response;
import com.chhatrola.visitors.web.service.ContractorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("contractor")
@Api(value="Contractor", description="Contractor Management operation")
public class ContractorControllerImpl {

    @Autowired
    ContractorService contractorService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Response> create(@RequestBody RequestData requestData) throws JsonProcessingException, ParseException {
        return contractorService.createContractor(requestData);
    }

//    @RequestMapping(value = "/fetchSignedInContractors", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
//    public ResponseEntity<List<Contractor>> fetchSignedInContractors(@RequestBody Authoriser authoriserView){
//        List<Contractor> contractors = contractorService.fetchSignedInContractors(authoriserView.getId());
//        return new ResponseEntity<List<Contractor>>(contractors, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/fetchSignedOutContractors", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
//    public ResponseEntity<List<Contractor>> fetchSignedOutContractors(@RequestBody Authoriser authoriserView){
//        List<Contractor> contractors = contractorService.fetchSignedInContractors(authoriserView.getId());
//        return new ResponseEntity<List<Contractor>>(contractors, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/contractorSignOut", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
//    public ResponseEntity<String> contractorSignOut(Long authoriserId, Long contractorId){
//        contractorService.contractorSignOut(new Authoriser());
//        return new ResponseEntity<String>("Successfully Signout.", HttpStatus.OK);
//    }
//
//    /**
//     * https://www.mkyong.com/spring-boot/spring-boot-file-upload-example-ajax-and-rest/
//     * @param signature
//     * @param contractorId
//     * @param authoriserId
//     * @return
//     */
//    @PostMapping(value = "/uploadSignature")
//    public ResponseEntity<String> uploadSignature(@RequestParam MultipartFile signature, @RequestParam Long contractorId, @RequestParam Long authoriserId){
//        return new ResponseEntity<String>("Successfully Uploaded.", HttpStatus.OK);
//    }
//
//    @PostMapping(value = "/uploadDocument")
//    public ResponseEntity<String> uploadDocument(@RequestParam MultipartFile signature, @RequestParam Long contractorId, @RequestParam Long authoriserId){
//        return new ResponseEntity<String>("Successfully Uploaded.", HttpStatus.OK);
//    }
}
