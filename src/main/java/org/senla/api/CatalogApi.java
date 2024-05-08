/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.5.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.senla.api;

import org.senla.model.Error;
import org.senla.model.ProductCatalog;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.senla.model.dto.ProductCatalogDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-05T16:09:04.794912+03:00[Europe/Moscow]", comments = "Generator version: 7.5.0")
@Validated
@Tag(name = "catalog", description = "Запросы для product_catalog")
public interface CatalogApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /catalog : Добваить каталог
     * Добваить каталог
     *
     * @param productCatalog  (required)
     * @return Каталог успешно добавлен (status code 200)
     *         or Что-то пошло не так (status code 200)
     */
    @Operation(
        operationId = "addCatalog",
        summary = "Добваить каталог",
        description = "Добваить каталог",
        tags = { "catalog" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Каталог успешно добавлен"),
            @ApiResponse(responseCode = "default", description = "Что-то пошло не так", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
        }
    )
    @RequestMapping(
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    @PostMapping("/catalog")
    void addCatalog(
        @Parameter(name = "ProductCatalog", description = "", required = true) @Valid @RequestBody ProductCatalogDTO productCatalog
    );

    /**
     * GET /catalog : Получить все каталоги
     * Получить все каталоги
     *
     * @return Все каталоги (status code 200)
     *         or Что-то пошло не так (status code 200)
     */
    @Operation(
        operationId = "allCatalog",
        summary = "Получить все каталоги",
        description = "Получить все каталоги",
        tags = { "catalog" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Все каталоги", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProductCatalog.class)))
            }),
            @ApiResponse(responseCode = "default", description = "Что-то пошло не так", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
        }
    )
    @RequestMapping(
        produces = { "application/json" }
    )
    @GetMapping("/catalog")
    List<ProductCatalogDTO> allCatalog();

    /**
     * GET /catalog/{id_shop} : Получить каталог по ID торговой точки
     * Получить каталог по ID торговой точки
     *
     * @param idShop ID торговой точки (required)
     * @return Кталог (status code 200)
     *         or Что-то пошло не так (status code 200)
     */
    @Operation(
        operationId = "getCatalogByIdShop",
        summary = "Получить каталог по ID торговой точки",
        description = "Получить каталог по ID торговой точки",
        tags = { "catalog" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Кталог", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ProductCatalog.class))
            }),
            @ApiResponse(responseCode = "default", description = "Что-то пошло не так", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
        }
    )
    @RequestMapping(
        produces = { "application/json" }
    )
    @GetMapping("/catalog/{id_shop}")
    Optional<ProductCatalogDTO> getCatalogByIdShop(
        @Parameter(name = "id_shop", description = "ID торговой точки", required = true, in = ParameterIn.PATH) @PathVariable("id_shop") Long idShop
    );

    /**
     * DELETE /catalog/{id_shop} : Удалить каталог по ID торговой точки
     * Удалить каталог по ID торговой точки
     *
     * @param idShop ID торговой точки (required)
     * @return Кталог удален (status code 200)
     *         or Что-то пошло не так (status code 200)
     */
    @Operation(
        operationId = "removeCatalogByIdShop",
        summary = "Удалить каталог по ID торговой точки",
        description = "Удалить каталог по ID торговой точки",
        tags = { "catalog" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Кталог удален"),
            @ApiResponse(responseCode = "default", description = "Что-то пошло не так", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
        }
    )
    @RequestMapping(
        produces = { "application/json" }
    )
    @DeleteMapping("/catalog/{id_shop}")
    void removeCatalogByIdShop(
        @Parameter(name = "id_shop", description = "ID торговой точки", required = true, in = ParameterIn.PATH) @PathVariable("id_shop") Long idShop
    );

    /**
     * PATCH /catalog : Изменить каталог
     * Изменить каталог
     *
     * @param productCatalog  (required)
     * @return Каталог успешно изменен (status code 200)
     *         or Что-то пошло не так (status code 200)
     */
    @Operation(
        operationId = "updateCatalog",
        summary = "Изменить каталог",
        description = "Изменить каталог",
        tags = { "catalog" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Каталог успешно изменен"),
            @ApiResponse(responseCode = "default", description = "Что-то пошло не так", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
        }
    )
    @RequestMapping(
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    @PatchMapping("/catalog/{id_shop}")
    void updateCatalog(
            @Parameter(name = "id_shop", description = "ID каталога", required = true, in = ParameterIn.PATH) @Valid @RequestBody ProductCatalogDTO productCatalog, @PathVariable("id") Long idShop
    );

}
