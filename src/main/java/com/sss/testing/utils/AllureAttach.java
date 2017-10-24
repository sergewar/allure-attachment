package com.sss.testing.utils;

import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public final class AllureAttach {
    private static final Logger LOG = LoggerFactory.getLogger(AllureAttach.class);

    private AllureAttach() {
        throw new UnsupportedOperationException("Private constructor");
    }

    /**
     * @param attachmentName attachment name
     * @param content        content
     * @return content
     */
    @Attachment(value = "{0}")
    public static String attachContent(String attachmentName, String content) {
        LOG.debug("Attach to allure content without formatting");
        return content;
    }

    /**
     * @param attachmentName attachment name
     * @param httpContent    content
     * @return content
     */
    @Attachment(value = "{0}", type = "message/http")
    public static String attachHttpContent(String attachmentName, String httpContent) {
        LOG.debug("Attach to allure content as http content");
        return httpContent;
    }

    /**
     * @param attachmentName attachment name
     * @param xmlContent     content
     * @return content
     */
    @Attachment(value = "{0}", type = "text/xml")
    public static String attachXmlContent(String attachmentName, String xmlContent) {
        LOG.debug("Attach to allure content as xml content");
        return xmlContent;
    }

    /**
     * @param attachmentName attachment name
     * @param textContent    content
     * @return content
     */
    @Attachment(value = "{0}", type = "text/plain")
    public static String attachTextContent(String attachmentName, String textContent) {
        LOG.debug("Attach to allure content as plain content");
        return textContent;
    }

    /**
     * @param attachmentName attachment name
     * @param jsonContent    content
     * @return content
     */
    @Attachment(value = "{0}", type = "text/json")
    public static String attachJsonContent(String attachmentName, String jsonContent) {
        LOG.debug("Attach to allure content as json content");
        return jsonContent;
    }

    /**
     * @param attachmentName attachment name
     * @param image          image
     * @return Byte array of image
     */
    @Attachment(value = "{0}", type = "image/png")
    public static byte[] attachImage(String attachmentName, File image) {
        if (image == null) {
            return (new byte[]{});
        }
        return fileToByteArray(image);
    }

    /**
     * @param attachmentName attachment name
     * @param image          image
     * @return Byte array of image
     */
    @Attachment(value = "{0}", type = "image/png")
    public static byte[] attachImage(String attachmentName, byte[] image) {
        return image == null ? new byte[]{} : image;
    }

    /**
     * @param attachmentName attachment name
     * @param pdf            pdf
     * @return Byte array of pdf
     */
    @Attachment(value = "{0}", type = "application/pdf")
    public static byte[] attachPDF(String attachmentName, File pdf) {
        if (pdf == null) {
            return (new byte[]{});
        }
        return fileToByteArray(pdf);
    }

    /**
     * @param attachmentName attachment name
     * @param pdf            pdf
     * @return Byte array of pdf
     */
    @Attachment(value = "{0}", type = "application/pdf")
    public static byte[] attachPDF(String attachmentName, byte[] pdf) {
        return pdf == null ? new byte[]{} : pdf;
    }

    /**
     * convert File to byte[]
     *
     * @param file File
     * @return byte[]
     */
    private static byte[] fileToByteArray(File file) {
        try {
            return Files.toByteArray(file);
        } catch (Exception e) {
            LOG.debug("Transform File into byte[] failed");
            e.printStackTrace();
            return (new byte[]{});
        }
    }
}
