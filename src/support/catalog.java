package support;

import java.io.*;
import java.util.ArrayList;

/**
 * Class {@code Catalog} handles the data with text file. In order to save memory from large scale
 * data base, every catalog object only contain 100 object.
 *
 * @author  Tianqi Cheng
 */
public abstract class Catalog implements FileAccessable{
    protected ArrayList<Object> catalog;
    private String catalogID;
    private String name;

    /**
     * Crate a catalog base on its type, it can be a user or order.
     *
     * @param n the type
     */
    public Catalog(String n){
        this.name = n;
        newCatalog();
    }

    /**
     * Load pacific text file into memory.
     *
     * @param n  the type
     * @param ID the id
     */
    public Catalog(String n,String ID){
        catalogID = ID;
        this.name = n;
        catalog = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream("/"+name+"/"+catalogID+".txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object i = ois.readObject();
            while (i != null) {
                catalog.add(i);
                i = ois.readObject();
            }
            ois.close();
        }
        catch (EOFException eofe){

        }
        catch (FileNotFoundException fnf){
            System.out.print(fnf.getMessage());
            fnf.printStackTrace();
        }
        catch (IOException ioe){
            System.out.print(ioe.getMessage());
            ioe.printStackTrace();
        }
        catch (ClassNotFoundException cnf){
            System.out.print(cnf.getMessage());
            cnf.printStackTrace();
        }
    }

    /**
     * New catalog.
     */
    public void newCatalog(){
        try {
            FileReader fr = new FileReader("/"+name+"/index.txt");
            BufferedReader bf = new BufferedReader(fr);
            Integer id = bf.read()-48;
            if (id > 0) id++;
            catalogID = id.toString();
            catalog = new ArrayList<>();
        }
        catch (FileNotFoundException fnf){
            fnf.printStackTrace();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    @Override
    public void save() {
        try {
            FileOutputStream fos = new FileOutputStream("/"+name+"/"+catalogID+".txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Object i : catalog) {
                oos.writeObject(i);
            }
            oos.close();
        }
        catch (FileNotFoundException fnf){
            fnf.printStackTrace();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    /**
     * Get catalog array list.
     *
     * @return the array list
     */
    public ArrayList<Object> getCatalog(){
        return catalog;
    }

    /**
     * Is full boolean.
     *
     * @return the boolean
     */
    public boolean isFull(){
        return catalog.size() < 100;
    }

    /**
     * Gets catalog id.
     *
     * @return the catalog id
     */
    public String getCatalogID() {
        return catalogID;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }
}
