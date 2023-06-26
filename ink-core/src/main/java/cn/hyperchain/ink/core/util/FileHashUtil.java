package cn.hyperchain.ink.core.util;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by superlee on 2017/7/31.
 * 计算文件hash
 */
public class FileHashUtil {
    /**
     * 通过文件实际路径获取文件hash
     *
     * @return 文件64位hash值
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    public static String getFileHashByRealPath(String filePath) throws IOException, NoSuchAlgorithmException {
        return getFileHashByRealPath(filePath,"SHA-256");
    }

    /**
     * 通过文件实际路径获取文件hash
     *
     * @param fileName 文件绝对路径
     * @param hashType hash类型，SHA1/SHA256/SHA512/MD5，默认为SHA256
     * @return 文件64位hash值
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    public static String getFileHashByRealPath(String fileName, String hashType) throws IOException, NoSuchAlgorithmException {
        if (StringUtils.isEmpty(fileName)) {
            return null;
        }

        if (StringUtils.isEmpty( hashType) || hashType.trim().equals("")) {
            hashType = "SHA-256";
        }
        MessageDigest md5;
        try(InputStream fis = new FileInputStream(fileName)) {
            byte buffer[] = new byte[1024];
            md5 = MessageDigest.getInstance(hashType);
            for (int numRead = 0; (numRead = fis.read(buffer)) > 0; ) {
                md5.update(buffer, 0, numRead);
            }
        }

        return toHexString(md5.digest());
    }

    /**
     * 通过MultipartFile文件形式获取文件hash
     *
     * @param file     文件
     * @return 文件hash
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    public static String getFileHashByFile(MultipartFile file) throws IOException, NoSuchAlgorithmException {
        return getFileHashByFile(file,"SHA-256");
    }

    /**
     * 通过MultipartFile文件形式获取文件hash
     *
     * @param file     文件
     * @param hashType hash类型，SHA1/SHA256/SHA512/MD5，默认为SHA256
     * @return 文件hash
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    public static String getFileHashByFile(MultipartFile file, String hashType) throws IOException, NoSuchAlgorithmException {

        if (null == file) {
            return null;
        }

        if (null == hashType || "".equals(hashType.trim())) {
            hashType = "SHA-256";
        }


        InputStream fis = file.getInputStream();
        byte buffer[] = new byte[1024];
        MessageDigest md5 = MessageDigest.getInstance(hashType);
        for (int numRead = 0; (numRead = fis.read(buffer)) > 0; ) {
            md5.update(buffer, 0, numRead);
        }
        fis.close();
        return toHexString(md5.digest());
    }

    /**
     * 通过文件输入流获取文件hash
     *
     * @param fis      文件输入流
     * @param hashType hash类型，默认SHA256
     * @return 文件hash
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public static String getFileHashByInputStream(InputStream fis, String hashType) throws NoSuchAlgorithmException, IOException {

        if (null == fis) {
            return null;
        }

        if (null == hashType || hashType.trim().equals("")) {
            hashType = "SHA-256";
        }
        byte buffer[] = new byte[1024];
        MessageDigest md5 = MessageDigest.getInstance(hashType);
        for (int numRead = 0; (numRead = fis.read(buffer)) > 0; ) {
            md5.update(buffer, 0, numRead);
        }
        fis.close();
        return toHexString(md5.digest());
    }

    /**
     * 获取字符串的hash
     *
     * @param strSrc   原始字符串
     * @param hashType hash类型，默认SHA256
     * @return 字符串hash
     * @throws NoSuchAlgorithmException
     */
    public static String getStringHash(String strSrc, String hashType) throws NoSuchAlgorithmException {
        if (null == strSrc || strSrc.trim().equals("")) {
            return null;
        }
        if (null == hashType || hashType.trim().equals("")) {
            hashType = "SHA-256";
        }
        MessageDigest md = MessageDigest.getInstance(hashType);
        md.update(strSrc.getBytes());
        return toHexString(md.digest());
    }

    /**
     * byte数组转16进制字符串
     *
     * @param src byte数组
     * @return 16进制字符串
     */
    private static String toHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv + "");
        }
        return stringBuilder.toString();
    }

    public static String getStringHash(String str) {
        MessageDigest messageDigest;
        String encodestr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
            encodestr = toHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encodestr;
    }
}
