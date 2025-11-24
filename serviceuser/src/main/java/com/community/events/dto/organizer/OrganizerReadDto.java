package com.community.events.dto.organizer;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link com.community.events.entities.Organizer}
 */
public class OrganizerReadDto implements Serializable {
    private final Long id;
    private final String email;
    private final String lastName;
    private final String firstName;
    private final String phone;
    private final Set<RoleDto> roles;
    private final Set<EventShortDto> events;

    public OrganizerReadDto(Long id, String email, String lastName, String firstName, String phone, Set<RoleDto> roles, Set<EventShortDto> events) {
        this.id = id;
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.roles = roles;
        this.events = events;
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

    public Set<EventShortDto> getEvents() {
        return events;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizerReadDto entity = (OrganizerReadDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.phone, entity.phone) &&
                Objects.equals(this.roles, entity.roles) &&
                Objects.equals(this.events, entity.events);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, lastName, firstName, phone, roles, events);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "email = " + email + ", " +
                "lastName = " + lastName + ", " +
                "firstName = " + firstName + ", " +
                "phone = " + phone + ", " +
                "roles = " + roles + ", " +
                "events = " + events + ")";
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