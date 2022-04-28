package com.company.applicationforcbrf.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataFileService {
    private final File file;

    public DataFileService(@Value("${filepath.data}") File file) {
        this.file = file;
    }

    public synchronized List<String> readTable() {
        List<String> result = new ArrayList<>();
        try (FileReader fr = new FileReader(file);
             BufferedReader reader = new BufferedReader(fr)) {
            String line = reader.readLine();
            while (line != null) {
                line = reader.readLine();
                result.add(line);
            }
            return result;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public synchronized void write(String element) {
        try (FileWriter fw = new FileWriter(file,true);
             BufferedWriter bufferedWriter = new BufferedWriter(fw)) {
            bufferedWriter.write(System.lineSeparator());
            bufferedWriter.write(element);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
