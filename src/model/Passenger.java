public class Passenger {

    private String name;
    private String lastName;
    private String id;
    private Priority prioriry;

    public Passenger(String name, String lastName, String id, Priority priority){
        this.name = name;
        this.lastName = lastName;
        this.id = id;
        this.prioriry = priority;
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

    public void setPrioriry(Priority prioriry) {
        this.prioriry = prioriry;
    }


}
