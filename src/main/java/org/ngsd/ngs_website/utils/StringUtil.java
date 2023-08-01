package org.ngsd.ngs_website.utils;

import jdk.jfr.Description;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Trieu Quang Dung
 * @created 2023.08.01 - 1:49 PM
 * @project NGS Website
 */
@Description("StringUtil Model")
public class StringUtil {

    /**
     * Description: Check String isBank
     *
     * @param str
     * @return boolean
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((!Character.isWhitespace(str.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Description: Capitalize Text
     *
     * @param text
     * @return String
     */
    public static String capitalizeText(String text) {
        if (StringUtils.isEmpty(text)) return text;
        List<String> list = Arrays.asList(text.split(" "));
        return list.stream().map(StringUtils::capitalize).collect(Collectors.joining(" "));
    }

    /**
     * Description: Remove space
     *
     * @param text
     * @return String
     */
    public static String removeSpace(String text) {
        return text.replace("/(\r\n|\n|\r)/gm", "");
    }

    /**
     * Description: Convert Vietnamese String to English string
     *
     * @param str
     * @return String
     */
    public static String convertViToEn(String str) {
        str = str.replaceAll("à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ", "a");
        str = str.replaceAll("è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ", "e");
        str = str.replaceAll("ì|í|ị|ỉ|ĩ", "i");
        str = str.replaceAll("ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ", "o");
        str = str.replaceAll("ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ", "u");
        str = str.replaceAll("ỳ|ý|ỵ|ỷ|ỹ", "y");
        str = str.replaceAll("đ", "d");

        str = str.replaceAll("À|Á|Ạ|Ả|Ã|Â|Ầ|Ấ|Ậ|Ẩ|Ẫ|Ă|Ằ|Ắ|Ặ|Ẳ|Ẵ", "A");
        str = str.replaceAll("È|É|Ẹ|Ẻ|Ẽ|Ê|Ề|Ế|Ệ|Ể|Ễ", "E");
        str = str.replaceAll("Ì|Í|Ị|Ỉ|Ĩ", "I");
        str = str.replaceAll("Ò|Ó|Ọ|Ỏ|Õ|Ô|Ồ|Ố|Ộ|Ổ|Ỗ|Ơ|Ờ|Ớ|Ợ|Ở|Ỡ", "O");
        str = str.replaceAll("Ù|Ú|Ụ|Ủ|Ũ|Ư|Ừ|Ứ|Ự|Ử|Ữ", "U");
        str = str.replaceAll("Ỳ|Ý|Ỵ|Ỷ|Ỹ", "Y");
        str = str.replaceAll("Đ", "D");
        return str;
    }

    /**
     * Description: Generate Unique file name
     *
     * @param fileName
     * @return String
     */
    public static String genUniqueFileName(String fileName) {
        if (org.springframework.util.ObjectUtils.isEmpty(fileName)) {
            fileName = "";
        }
        String fullTime = DateUtil.toString(LocalDateTime.now());
        return fullTime + "_" +  convertViToEn(fileName.replace(" ", "-"));
    }
}
