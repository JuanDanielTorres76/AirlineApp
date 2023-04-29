package model;
import java.io.Serializable;

public class Passenger implements Serializable{

    private String name;

    private String lastName;

    private String id;

    private Priority prioriry;

    private Category category;
    

    public Passenger(String name, String lastName, String id, Priority priority, Category category){
        
        this.name = name;
        
        this.lastName = lastName;
        
        this.id = id;
        
        this.prioriry = priority;
        
        this.category = category;
    
    }
    
    public String getName() {
        
        return this.name;
    
    }

    public void setName(String name) {
        
        this.name = name;
 
    }

    public String getLastName() {
 
        return this.lastName;
 
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;

    }

    public String getId() {

        return this.id;

    }

    public void setId(String id) {

        this.id = id;

    }

    public Priority getPrioriry() {

        return this.prioriry;

    }

    public String toString(){

        return "Name " + getName() + " Last name: "+ getLastName() + " Id: " + getId() + " Priority: " + getPrioriry() + " Category " + getCategory();

    }

    public void setPrioriry(Priority prioriry) {

        this.prioriry = prioriry;

    }

    
    public Category getCategory() {

        return category;

    }


    public void setCategory(Category category) {

        this.category = category;

    }


}
