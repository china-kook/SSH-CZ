package com.ikook.action;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUploadAction extends ActionSupport {

    // 提交过来的文件
    private File file;
    // 提交过来的 file 的文件名
    private String fileFileName;
    // 提交过来的 file 的文件类型
    private String fileContentType;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    @Override
    public String execute() throws Exception {
        // 文件输入流
        InputStream inputStream = new FileInputStream(file);

        // 设置文件保存的目录
        String uploadPath = ServletActionContext.getServletContext().getRealPath("/upload");

        // 设置目标文件
        File toFile = new File(uploadPath, this.getFileFileName());

        // 文件输出流
        OutputStream outputStream = new FileOutputStream(toFile);

        byte[] buffer = new byte[8192];
        int length = 0;

        // 读取 file 文件输出到 toFile 文件中
        while( -1 != (length = inputStream.read(buffer, 0, buffer.length))) {
            outputStream.write(buffer);
        }

        // 关闭输入流和输出流
        inputStream.close();
        outputStream.close();

        return SUCCESS;
    }
}
