package cz.fi.muni.pa165.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Product {
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(nullable=false,unique=true)
	private String name;
        
        
        @Enumerated(EnumType.STRING)
        private Color color;
        
        @Temporal(TemporalType.DATE)
        java.util.Date date;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Date getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public enum Color {BLACK, RED, WHITE;}
        
       
}
