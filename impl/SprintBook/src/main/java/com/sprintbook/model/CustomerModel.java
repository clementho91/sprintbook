package com.sprintbook.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity(name = "customer")
@Getter
@Setter
@NoArgsConstructor
public class CustomerModel{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    /**
     *
     * Attribute Type Constraints Notes
     * Id UUID PK
     * First Name String
     * Middle Name String Null is acceptable
     * Last Name String
     * Email Address String Unique
     * Phone Number String
     */
    @Column(name = "first_name")
    String firstName;
    @Column(name = "middle_name")
    String middleName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "email")
    String email;

    @Column(name = "phone_number")
    String phoneNumber;

    @CreationTimestamp
    @Column(name = "created_at")
    Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    Date updatedAt;


}
