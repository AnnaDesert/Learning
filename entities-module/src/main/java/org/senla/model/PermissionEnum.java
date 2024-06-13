package org.senla.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Getter
@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PermissionEnum {
    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    SUPER_ADMIN_READ("super_admin:read"),
    SUPER_ADMIN_UPDATE("super_admin:update"),
    SUPER_ADMIN_CREATE("super_admin:create"),
    SUPER_ADMIN_DELETE("super_admin:delete"),
    USER_READ("user:read"),
    USER_UPDATE("user:update"),
    USER_CREATE("user:create"),
    USER_DELETE("user:delete");

    private final String permission;

    @JsonCreator
    public static PermissionEnum fromValue(@JsonProperty("permissions") String permission)
    {
        for(PermissionEnum b : PermissionEnum.values()) {
            if (b.permission.equals(permission)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + permission + "'");
    }
}
