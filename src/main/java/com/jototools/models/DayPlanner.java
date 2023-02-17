package com.jototools.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="DayPlanner")
public class DayPlanner {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @NotEmpty(message="Date is required!")
    private String date;
    
    private String breakfast;
    private String morning;
    private String lunch;
    private String afternoon;
    private String dinner;
    private String evening;
    
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
  
    public DayPlanner() {
    	
    }
    

	public DayPlanner(@NotEmpty(message = "Date is required!") String date, String breakfast, String morning,
			String lunch, String afternoon, String dinner, String evening, Date createdAt, Date updatedAt, User user) {
		this.date = date;
		this.breakfast = breakfast;
		this.morning = morning;
		this.lunch = lunch;
		this.afternoon = afternoon;
		this.dinner = dinner;
		this.evening = evening;
		this.user = user;
	}






	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getDate() {
		return date;
	}




	public void setDate(String date) {
		this.date = date;
	}




	public String getBreakfast() {
		return breakfast;
	}




	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}




	public String getMorning() {
		return morning;
	}




	public void setMorning(String morning) {
		this.morning = morning;
	}




	public String getLunch() {
		return lunch;
	}




	public void setLunch(String lunch) {
		this.lunch = lunch;
	}




	public String getAfternoon() {
		return afternoon;
	}




	public void setAfternoon(String afternoon) {
		this.afternoon = afternoon;
	}




	public String getDinner() {
		return dinner;
	}




	public void setDinner(String dinner) {
		this.dinner = dinner;
	}




	public String getEvening() {
		return evening;
	}




	public void setEvening(String evening) {
		this.evening = evening;
	}




	public Date getCreatedAt() {
		return createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    
    
}
