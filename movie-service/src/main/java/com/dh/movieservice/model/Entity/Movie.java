package com.dh.movieservice.model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author vaninagodoy
 */

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Basic(fetch = FetchType.LAZY)
    private String genre;

    @Basic(fetch = FetchType.LAZY)
    private String urlStream;

    /*
    public Movie(Object o, String s, String terror, String s1) {
    }
     */
}
