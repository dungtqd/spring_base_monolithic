package org.ngsd.ngs_website.utils;

/**
 * @author Trieu Quang Dung
 * @created 2023.08.01 - 2:27 PM
 * @project NGS Website
 */
public class FileUtil {

    /**
     * Description: Get Extension file
     *
     * @param fileName
     * @return
     */
    public static String getExtensionFile(String fileName) {
        String extension = "";
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i + 1);
        }
        return extension;
    }
}
