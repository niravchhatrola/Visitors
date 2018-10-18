package com.chhatrola.visitors.web.controller.impl;

import com.chhatrola.visitors.util.ResponseUtil;
import com.chhatrola.visitors.web.model.*;
import com.chhatrola.visitors.web.model.ResponseStatus;
import com.chhatrola.visitors.web.service.ContractorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

@RestController
@RequestMapping("contractor")
@Api(value="Contractor", description="Contractor Management operation")
public class ContractorControllerImpl {


    private static final String SIGNATURE_PATH = "signature/";
    private static final String DOCUMENT_PATH = "document/";

    @Autowired
    ContractorService contractorService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Response> create(@RequestBody RequestData requestData) throws JsonProcessingException, ParseException {
        return contractorService.createContractor(requestData);
    }

    @RequestMapping(value = "/fetchSignedInContractors", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Response> fetchSignedInContractors(@RequestBody RequestData requestData) throws JsonProcessingException, ParseException {
        return contractorService.fetchSignedInContractors(requestData);
    }

    @RequestMapping(value = "/fetchSignedOutContractors", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Response> fetchSignedOutContractors(@RequestBody RequestData requestData) throws JsonProcessingException, ParseException {
        return contractorService.fetchSignedOutContractors(requestData);
    }

    @RequestMapping(value = "/contractorSignOut", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Response> contractorSignOut(@RequestBody RequestData requestData) throws JsonProcessingException, ParseException {
        return contractorService.contractorSignOut(requestData);
    }

    @RequestMapping(value = "/searchContractor", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Response> searchContracor(@RequestBody RequestData requestData) throws JsonProcessingException, ParseException {
        return contractorService.searchContractor(requestData);
    }

    @RequestMapping(value = "/uploadSignature", method = RequestMethod.POST, produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Response> uploadSignature(@RequestParam(value="imgFile") MultipartFile[] files, @RequestParam(value = "documentId") Long documentId) throws IOException {
        return contractorService.uploadFile(files,documentId, SIGNATURE_PATH);
    }

    @RequestMapping(value = "/uploadDocument", method = RequestMethod.POST, produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Response> uploadDocument(@RequestParam(value="imgFile") MultipartFile[] files, @RequestParam(value = "documentId") Long documentId) throws IOException {
        return contractorService.uploadFile(files,documentId, DOCUMENT_PATH);
    }
}
