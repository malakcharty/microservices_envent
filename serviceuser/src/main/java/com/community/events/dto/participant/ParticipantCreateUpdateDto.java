package com.community.events.dto.participant;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link com.community.events.entities.Participant}
 */
public class ParticipantCreateUpdateDto implements Serializable {
    private final String email;
    private final String password;
    private final String lastName;
    private final String firstName;
    private final String phone;

    private Set<Long> roleIds;

    public ParticipantCreateUpdateDto(String email, String password, String lastName, String firstName, String phone) {
        this.email = email;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipantCreateUpdateDto entity = (ParticipantCreateUpdateDto) o;
        return Objects.equals(this.email, entity.email) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.phone, entity.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, lastName, firstName, phone);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "email = " + email + ", " +
                "password = " + password + ", " +
                "lastName = " + lastName + ", " +
                "firstName = " + firstName + ", " +
                "phone = " + phone + ")";
    }
}