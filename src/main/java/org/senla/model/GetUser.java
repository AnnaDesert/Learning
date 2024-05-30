package org.senla.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * GetUser
 */

@JsonTypeName("getUser")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-05T16:09:04.794912+03:00[Europe/Moscow]", comments = "Generator version: 7.5.0")
public class GetUser {

  private Long id;

  private String name;

  private String surname;

  private String phoneNumber;

  private String email;

  /**
   * Права доступа пользователя
   */
  public enum RoleEnum {
    SUPER_ADMIN("SUPER_ADMIN"),
    
    ADMIN("ADMIN"),
    
    USER("USER");

    private String value;

    RoleEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static RoleEnum fromValue(String value) {
      for (RoleEnum b : RoleEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private RoleEnum role;

  public GetUser id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * ID пользователя
   * @return id
  */
  
  @Schema(name = "id", example = "10", description = "ID пользователя", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public GetUser name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Имя пользователя
   * @return name
  */
  
  @Schema(name = "name", example = "Игорь", description = "Имя пользователя", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GetUser surname(String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * Фамилия пользователя
   * @return surname
  */
  
  @Schema(name = "surname", example = "Снигерев", description = "Фамилия пользователя", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("surname")
  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public GetUser phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  /**
   * Номер телефона пользователя
   * @return phoneNumber
  */
  
  @Schema(name = "phone_number", example = "7 956 845 34 56", description = "Номер телефона пользователя", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("phone_number")
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public GetUser email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Email пользователя
   * @return email
  */
  
  @Schema(name = "email", example = "snigerev@mail.ru", description = "Email пользователя", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public GetUser role(RoleEnum role) {
    this.role = role;
    return this;
  }

  /**
   * Права доступа пользователя
   * @return role
  */
  
  @Schema(name = "role", example = "USER", description = "Права доступа пользователя", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("role")
  public RoleEnum getRole() {
    return role;
  }

  public void setRole(RoleEnum role) {
    this.role = role;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetUser getUser = (GetUser) o;
    return Objects.equals(this.id, getUser.id) &&
        Objects.equals(this.name, getUser.name) &&
        Objects.equals(this.surname, getUser.surname) &&
        Objects.equals(this.phoneNumber, getUser.phoneNumber) &&
        Objects.equals(this.email, getUser.email) &&
        Objects.equals(this.role, getUser.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, surname, phoneNumber, email, role);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetUser {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

