package dev.rebecamf.myspringmypersonalproject.activities;

import java.util.Set;

import dev.rebecamf.myspringmypersonalproject.users.User;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "activities")
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_activity")
    private Long id; 

    private String name;
    private String location;
    private String days;
    private String month;
    private String time;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String range;
    private int capacity;
    
   

    @JsonIgnore
    @ManyToMany(mappedBy = "activities")
    Set<User> users;

}