package usr;

import support.Catalog;
import support.FileAccessable;
import support.UserNotFoundException;

import java.io.*;
import java.util.ArrayList;

/**
 * Class {@code UserCatalog} is the bridge between the {@code User} Object and the text file.
 * It extend from Class {@code Catalog}
 *
 * @author  Tianqi Cheng
 * @see     support.Catalog
 */
public class UserCatalog extends Catalog{


    /**
     * Instantiates a new User catalog.
     */
    public UserCatalog(){
        super("usr");
    }

    /**
     * Instantiates a new User catalog.
     *
     * @param ID the id
     */
    public UserCatalog(String ID){
        super("usr",ID);
    }

    /**
     * Register boolean.
     *
     * @param usr the usr
     * @return the boolean
     */
    public boolean register(User usr){
        if (super.isFull()) {
            usr.setUserID(super.getCatalogID()+ catalog.size());
            catalog.add(usr);
            save();
            return true;
        }
        else {
            save();
            return false;
        }
    }

    /**
     * User locator user.
     *
     * @param id the id
     * @return the user
     * @throws UserNotFoundException the user not found exception
     */
    public User userLocator(String id) throws UserNotFoundException {
        int tem = Integer.parseInt(id);
        if (tem > 100)
            throw new UserNotFoundException(id);
        return (User) catalog.get(tem);
    }
}
