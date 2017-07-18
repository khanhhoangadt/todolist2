package hoang.todolist;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "todolist")
public class Todolist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(unique = true, nullable = false, length = 200)
	private String username;
	
    @JsonIgnore
    private String firstDate;
    private String lastDate;
    
    public Todolist() {
    	
    }
    
    public Todolist(String username, String firstDate, String lastDate) {
    	this.username = username;
    	this.firstDate = firstDate;
    	this.lastDate = lastDate;
    }
    
    public long getId() {
    	return id;
    }
    
    public void setId(long id) {
    	this.id=id;
    }
    
    public String getUsername() {
    	return username;
    }
    
    public void setUsername(String username) {
    	this.username = username;
    }

    public String getFirstDate() {
    	return firstDate;
    }
    
    public void setFirstDate(String firstDate) {
    	this.firstDate = firstDate;
    }
    
    public String getLastDate() {
    	return lastDate;
    }
    
    public void setLastDate(String lastDate) {
    	this.lastDate = lastDate;
    }
    
    @Override
    public String toString() {
        return "Todolist{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstDate='" + firstDate + '\'' +
                ", lastDate='" + lastDate + '\'' +
                '}';
    }
}
