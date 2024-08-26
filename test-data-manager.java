package com.healthcare.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestDataManager {
    private static final String TEST_DATA_FILE = "src/test/resources/testdata/testdata.yaml";
    private static Map<String, Object> testData;

    static {
        loadTestData();
    }

    private static void loadTestData() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            testData = mapper.readValue(new File(TEST_DATA_FILE), HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
            testData = new HashMap<>();
        }
    }

    public static Object getTestData(String key) {
        return testData.get(key);
    }

    public static void setTestData(String key, Object value) {
        testData.put(key, value);
    }
}
