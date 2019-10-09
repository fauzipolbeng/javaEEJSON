package com.verdin.jsf.model;

import com.verdin.jsf.ejb.MovieDAO;
import com.verdin.jsf.ejb.SembakoDAO;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;


@ManagedBean(name="movieView")
@ViewScoped
public class MovieView implements Serializable {
	static final long serialVersionUID = 12345674411l;

    private List<Movie> movies;
     
    @ManagedProperty("#{movieService}")
    private MovieDAO service;
 
    @PostConstruct
    public void init() {
    	try {
    		movies = service.getMovie();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
     
    public List<Movie> getMovies() {
        return movies;
    }
 
    public void setService(MovieDAO service) {
        this.service = service;
    }
}