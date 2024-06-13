/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.55).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.codejournal.maven.swagger2java.api;

import io.codejournal.maven.swagger2java.model.ProductCatalogCreationDTO;
import io.codejournal.maven.swagger2java.model.ProductCatalogDTO;
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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-06-13T17:37:54.212889500+03:00[Europe/Moscow]")
@Validated
public interface CatalogApi {

    Logger log = LoggerFactory.getLogger(CatalogApi.class);

    default Optional<ObjectMapper> getObjectMapper(){
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest(){
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @Operation(summary = "Добваить каталог", description = "Добваить каталог", tags={ "catalog" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Created") })
    @RequestMapping(value = "/catalog",
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    default ResponseEntity<Void> addCatalog(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ProductCatalogCreationDTO body
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default CatalogApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Получить все каталоги", description = "Получить все каталоги", tags={ "catalog" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "*/*", array = @ArraySchema(schema = @Schema(implementation = ProductCatalogDTO.class)))) })
    @RequestMapping(value = "/catalog",
        produces = { "*/*" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<ProductCatalogDTO>> allCatalog() {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {\r\n  \"idShop\" : 6,\r\n  \"price\" : 5.637377,\r\n  \"count\" : 5,\r\n  \"id\" : 0,\r\n  \"idBatch\" : 1\r\n}, {\r\n  \"idShop\" : 6,\r\n  \"price\" : 5.637377,\r\n  \"count\" : 5,\r\n  \"id\" : 0,\r\n  \"idBatch\" : 1\r\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default CatalogApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Получить каталог по ID торговой точки", description = "Получить каталог по ID торговой точки", tags={ "catalog" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "*/*", schema = @Schema(implementation = ProductCatalogDTO.class))) })
    @RequestMapping(value = "/catalog/{id}",
        produces = { "*/*" }, 
        method = RequestMethod.GET)
    default ResponseEntity<ProductCatalogDTO> getCatalogByIdShop(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={ "1" }, minimum="1"
)) @PathVariable("id") Long id
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\r\n  \"idShop\" : 6,\r\n  \"price\" : 5.637377,\r\n  \"count\" : 5,\r\n  \"id\" : 0,\r\n  \"idBatch\" : 1\r\n}", ProductCatalogDTO.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default CatalogApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Удалить каталог по ID торговой точки", description = "Удалить каталог по ID торговой точки", tags={ "catalog" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK") })
    @RequestMapping(value = "/catalog/{id}",
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> removeCatalogByIdShop(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={ "1" }, minimum="1"
)) @PathVariable("id") Long id
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default CatalogApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Изменить каталог", description = "Изменить каталог", tags={ "catalog" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK") })
    @RequestMapping(value = "/catalog/{id}",
        consumes = { "application/json" }, 
        method = RequestMethod.PATCH)
    default ResponseEntity<Void> updateCatalog(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={ "1" }, minimum="1"
)) @PathVariable("id") Long id
, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ProductCatalogCreationDTO body
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default CatalogApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}

