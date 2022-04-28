package com.company.applicationforcbrf.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class ContentFileService {

    private final File file;

    public ContentFileService(@Value("${filepath.content}") String contentFilePath) {
        this.file = new File(contentFilePath);
    }

    public synchronized String read(int offset, int length) {
        char[] buf = new char[length];
        try (FileReader reader = new FileReader(file)) {
            reader.skip(offset);
            reader.read(buf);
            return String.valueOf(buf);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public synchronized void write(MultipartFile multipartFile) {
        try (InputStream fileIn = multipartFile.getInputStream();
             FileWriter fileOut = new FileWriter(file, true)) {
            while (fileIn.available() > 0) {
                int oneByte = fileIn.read();
                fileOut.write(oneByte);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
            throw new RuntimeException();
        }
    }
}
