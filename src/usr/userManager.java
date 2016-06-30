package usr;

import support.DataManager;
import support.NoAccessPermitException;
import support.UserNotFoundException;

/**
 * Class {@code UserManager} is the management class for all order. It extend from the
 * class {@code DataManager}
 *
 * @author  Tianqi Cheng
 * @see     support.DataManager;
 */

public class UserManager extends DataManager{
    /**
     * Instantiates a new User manager.
     */
    public UserManager() {
        super.currentCatalog = new UserCatalog();
    }

    private void register(User usr){
        UserCatalog uc = (UserCatalog) currentCatalog;
        if (!uc.register(usr))
            uc = new UserCatalog();
    }

    /**
     * New employee.
     *
     * @param ne the ne
     * @param hr the hr
     * @throws NoAccessPermitException the no access permit exception
     */
    public void newEmployee(User ne, User hr)throws NoAccessPermitException {
        if (!(hr instanceof humanResource))
            throw new NoAccessPermitException("Employee Data");
        else
            register(ne);

    }

    /**
     * New customer.
     *
     * @param ne the ne
     * @throws NoAccessPermitException the no access permit exception
     */
    public void newCustomer(User ne)throws NoAccessPermitException{
        if (!(ne instanceof Customer))
            throw new NoAccessPermitException("Customer Data");
        else
            register(ne);
    }

    /**
     * User locator user.
     *
     * @param ID the id
     * @return the user
     * @throws UserNotFoundException the user not found exception
     */
    public User userLocator(String ID) throws UserNotFoundException {
        String catalogID = ID.substring(0,ID.length()-2);
        String userID = ID.substring(ID.length()-2,ID.length());
        UserCatalog uc = new UserCatalog(catalogID);
        return uc.userLocator(userID);
    }

    /**
     * Login boolean.
     *
     * @param ID the id
     * @param pw the pw
     * @return the boolean
     */
    public boolean login(String ID,String pw) {
        try {
            return (userLocator(ID)).logIn(pw);
        }
        catch (UserNotFoundException unf){
            System.err.print(unf.getMessage());
            return false;
        }
    }

    /**
     * Log out.
     *
     * @param usr the usr
     */
    public void logOut(User usr){
        usr.logOut();
    }

}
