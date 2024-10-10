package util;


import com.google.gson.Gson;
import pojo.TestData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {
    private TestData testData;
    public JsonDataReader(String filePath) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            // Deserialize JSON to TestData object
            testData = gson.fromJson(reader, TestData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to get the TestData object
    public TestData getTestData() {
        return testData;
    }

}
