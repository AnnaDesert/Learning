/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.55).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.codejournal.maven.swagger2java.api;

import io.codejournal.maven.swagger2java.model.BatchOfProductCreationDTO;
import io.codejournal.maven.swagger2java.model.BatchOfProductDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-06-13T17:37:57.333556400+03:00[Europe/Moscow]")
@Validated
public interface BatchApi {

    Logger log = LoggerFactory.getLogger(BatchApi.class);

    default Optional<ObjectMapper> getObjectMapper(){
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest(){
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @Operation(summary = "Добваить партию", description = "Добваить партию", tags={ "batch" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Created") })
    @RequestMapping(value = "/batch",
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    default ResponseEntity<Void> addBatch(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody BatchOfProductCreationDTO body
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default BatchApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Получить все партии", description = "Получить все партии", tags={ "batch" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "*/*", array = @ArraySchema(schema = @Schema(implementation = BatchOfProductDTO.class)))) })
    @RequestMapping(value = "/batch",
        produces = { "*/*" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<BatchOfProductDTO>> allBatch() {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {\r\n  \"expirationDateStart\" : \"2000-01-23T04:56:07.000+00:00\",\r\n  \"count\" : 1,\r\n  \"idProduct\" : 6,\r\n  \"id\" : 0,\r\n  \"expirationDateEnd\" : \"2000-01-23T04:56:07.000+00:00\"\r\n}, {\r\n  \"expirationDateStart\" : \"2000-01-23T04:56:07.000+00:00\",\r\n  \"count\" : 1,\r\n  \"idProduct\" : 6,\r\n  \"id\" : 0,\r\n  \"expirationDateEnd\" : \"2000-01-23T04:56:07.000+00:00\"\r\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default BatchApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Получить партию по ID", description = "Получить партию по ID", tags={ "batch" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "*/*", schema = @Schema(implementation = BatchOfProductDTO.class))) })
    @RequestMapping(value = "/batch/{id}",
        produces = { "*/*" }, 
        method = RequestMethod.GET)
    default ResponseEntity<BatchOfProductDTO> getBatchById(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={ "1" }, minimum="1"
)) @PathVariable("id") Long id
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\r\n  \"expirationDateStart\" : \"2000-01-23T04:56:07.000+00:00\",\r\n  \"count\" : 1,\r\n  \"idProduct\" : 6,\r\n  \"id\" : 0,\r\n  \"expirationDateEnd\" : \"2000-01-23T04:56:07.000+00:00\"\r\n}", BatchOfProductDTO.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default BatchApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Удалить партию по ID", description = "Удалить партию по ID", tags={ "batch" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK") })
    @RequestMapping(value = "/batch/{id}",
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> removeBatchById(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={ "1" }, minimum="1"
)) @PathVariable("id") Long id
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default BatchApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Изменить партию", description = "Изменить партию", tags={ "batch" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK") })
    @RequestMapping(value = "/batch/{id}",
        consumes = { "application/json" }, 
        method = RequestMethod.PATCH)
    default ResponseEntity<Void> updateBatch(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={ "1" }, minimum="1"
)) @PathVariable("id") Long id
, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody BatchOfProductCreationDTO body
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default BatchApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}

