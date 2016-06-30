package usr;

/**
 * Class {@code Employee} handle the employee information. it extends User
 *
 * @author  Tianqi Cheng
 * @see     usr.User
 */
public abstract class Employee extends User{
    private String name;
    private User supervisor;

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets supervisor.
     *
     * @return the supervisor
     */
    public User getSupervisor() {
        return supervisor;
    }

    /**
     * Sets supervisor.
     *
     * @param supervisor the supervisor
     */
    public void setSupervisor(User supervisor) {
        this.supervisor = supervisor;
    }
}
