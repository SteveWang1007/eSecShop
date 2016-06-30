package support;

/**
 * Interface {@code FileAccessable} apply to all file in package need to communicate with text file
 *
 * @author  Tianqi Cheng
 * @see     productData.ProductCatalog
 */

public interface FileAccessable {
    /**
     * Save all data in to text file.
     */
    public void save();
}
