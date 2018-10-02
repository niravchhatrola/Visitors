package com.chhatrola.visitors.util;

import com.chhatrola.visitors.web.model.ResponseData;
import com.chhatrola.visitors.web.model.ResponseStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {

    /**
     * This method will prepare sresponse and return ResponseEntity.
     * @param status
     * @param data
     * @return
     */
    public static ResponseEntity<ResponseData> prepareResponse(ResponseStatus status, Object data) throws JsonProcessingException {
        return new ResponseEntity<>(new ResponseData(status.getCode(), JsonUtil.toJson(data), status.getMessage()), HttpStatus.OK);
    }
}
