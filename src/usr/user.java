package usr;

import java.io.IOException;
import java.io.Serializable;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import support.NotLogInException;

/**
 * Class {@code User} handle the user information
 *
 * @author  Tianqi Cheng
 */
public abstract class User implements Serializable {
    private String  userID;
    private String  userName;
    private String  passWord;
    private boolean status;

    /**
     * Instantiates a new User.
     */
    public User() {
        status   = true;
        userName = "Guest";

        try {
            setPassWord("Default");
        } catch (NotLogInException nli) {
            nli.printStackTrace();
        }

        userID = "0";
    }

    /**
     * Instantiates a new User.
     *
     * @param un the un
     * @param pw the pw
     * @param id the id
     * @param st the st
     */
    public User(String un, String pw, String id, boolean st) {
        userName = un;
        passWord = pw;
        userID   = id;
        status   = st;
    }

    /**
     * Method description
     *
     *
     * @param obj
     *
     * @return
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof User)) {
            return false;
        }

        User user = (User) obj;

        return user.userID == this.userID;
    }

    /**
     * Log in boolean.
     *
     * @param pw the pw
     * @return the boolean
     */
    public boolean logIn(String pw) {
        if (isPWCorrect(pw)) {
            status = true;

            return true;
        } else {
            return false;
        }
    }

    /**
     * Log out.
     */
    public void logOut() {
        status = false;
    }

    private String pwDecoder() throws IOException {
        byte[] data = (new BASE64Decoder()).decodeBuffer(passWord);

        return new String(data);
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String toString() {
        return userID + ',' + userName + ',' + passWord + ',' + status;
    }

    /**
     * Get en pw string.
     *
     * @return the string
     */
    public String getEnPW() {
        return passWord;
    }

    /**
     * Is pw correct boolean.
     *
     * @param pw the pw
     * @return the boolean
     */
    public boolean isPWCorrect(String pw) {
        try {
            return (pwDecoder().equals(pw));
        } catch (IOException e) {
            e.printStackTrace();

            return false;
        }
    }

    /**
     * Sets pass word.
     *
     * @param pw the pw
     * @throws NotLogInException the not log in exception
     */
    public void setPassWord(String pw) throws NotLogInException {
        if (status) {
            byte[] data = pw.getBytes();

            passWord = (new BASE64Encoder()).encodeBuffer(data);
        } else {
            throw new NotLogInException();
        }
    }

    /**
     * Get status string.
     *
     * @return the string
     */
    public String getStatus() {
        if (status) {
            return "online";
        } else {
            return "offline";
        }
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Sets user id.
     *
     * @param userID the user id
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * Get user name string.
     *
     * @return the string
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set user name.
     *
     * @param un the un
     */
    public void setUserName(String un) {
        userName = un;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
