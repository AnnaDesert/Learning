package org.senla.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.senla.model.PermissionEnum.ADMIN_CREATE;
import static org.senla.model.PermissionEnum.ADMIN_DELETE;
import static org.senla.model.PermissionEnum.ADMIN_READ;
import static org.senla.model.PermissionEnum.ADMIN_UPDATE;
import static org.senla.model.PermissionEnum.SUPER_ADMIN_CREATE;
import static org.senla.model.PermissionEnum.SUPER_ADMIN_DELETE;
import static org.senla.model.PermissionEnum.SUPER_ADMIN_READ;
import static org.senla.model.PermissionEnum.SUPER_ADMIN_UPDATE;
import static org.senla.model.PermissionEnum.USER_CREATE;
import static org.senla.model.PermissionEnum.USER_DELETE;
import static org.senla.model.PermissionEnum.USER_READ;
import static org.senla.model.PermissionEnum.USER_UPDATE;

@Getter
@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum RoleEnum {
    SUPER_ADMIN("SUPER_ADMIN",
            Set.of(
                    SUPER_ADMIN_READ,
                    SUPER_ADMIN_UPDATE,
                    SUPER_ADMIN_DELETE,
                    SUPER_ADMIN_CREATE
            )
    ),
    ADMIN("ADMIN",
            Set.of(
                    ADMIN_READ,
                    ADMIN_UPDATE,
                    ADMIN_DELETE,
                    ADMIN_CREATE
            )
    ),
    USER("USER",
            Set.of(
                    USER_READ,
                    USER_UPDATE,
                    USER_DELETE,
                    USER_CREATE
            )
    );

    @JsonValue
    private final String value;
    private final Set<PermissionEnum> permissions;

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static RoleEnum fromValue(String value) {
        for(RoleEnum b : RoleEnum.values()) {
            if(b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public List<SimpleGrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
