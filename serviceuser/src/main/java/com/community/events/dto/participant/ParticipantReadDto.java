package com.community.events.dto.participant;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link com.community.events.entities.Participant}
 */
public class ParticipantReadDto implements Serializable {
    private final Long id;
    private final String email;
    private final String lastName;
    private final String firstName;
    private final String phone;
    private final Set<RoleDto> roles;

    public ParticipantReadDto(Long id, String email, String lastName, String firstName, String phone, Set<RoleDto> roles) {
        this.id = id;
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhone() {
        return phone;
    }

    public Set<RoleDto> getRoles() {
        return roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipantReadDto entity = (ParticipantReadDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.phone, entity.phone) &&
                Objects.equals(this.roles, entity.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, lastName, firstName, phone, roles);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "email = " + email + ", " +
                "lastName = " + lastName + ", " +
                "firstName = " + firstName + ", " +
                "phone = " + phone + ", " +
                "roles = " + roles + ")";
    }

    /**
     * DTO for {@link com.community.events.entities.Role}
     */
    public static class RoleDto implements Serializable {
        private final Long id;
        private final String name;

        public RoleDto(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RoleDto entity = (RoleDto) o;
            return Objects.equals(this.id, entity.id) &&
                    Objects.equals(this.name, entity.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ", " +
                    "name = " + name + ")";
        }
    }
}