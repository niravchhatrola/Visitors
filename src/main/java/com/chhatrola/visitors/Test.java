package com.chhatrola.visitors;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.function.Consumer;

/**
 * Created by niv214 on 27/5/18.
 */
public class Test {

//    public static void main(String[] args) throws JsonParseException, IOException {
//        JsonFactory jsonFactory = new JsonFactory();
//        JsonParser jp = jsonFactory.createJsonParser(new File("/home/niv214/Learn/WORK/CStructure/work/CStructure/src/main/resources/data.json"));
//        jp.setCodec(new ObjectMapper());
//        JsonNode jsonNode = jp.readValueAsTree();
//        Consumer<JsonNode> data = (JsonNode node) -> System.out.println(node.asText());
//        jsonNode.forEach(data);
//    }

/*    private static Set<String> getAllKeys(JSONPObject json) {

//        json./
//        for (String key : json.keySet()) {
//            Object obj = json.get(key);
//            if (obj instanceof JSONObject) keys.addAll(getAllKeys(json.getJSONObject(key)));
//            if (obj instanceof JSONArray) keys.addAll(getAllKeys(json.getJSONArray(key)));
//        }
//
//        keys.addAll(json.keySet());
        return keys;
    }*/

    public static void main(String[] args) throws JsonParseException, IOException {

    testJsonNodeDemo();
    readJsonWithJsonNode();
        System.out.println("done");

    }

    static JsonNode rootNode;
    static ObjectMapper objectMapper;
    public static void testJsonNodeDemo()throws IOException{
        objectMapper = new ObjectMapper();
        rootNode = objectMapper.readTree(new File("src/main/resources/data.json"));
    }
    public static JsonNode readJsonWithJsonNode() throws JsonProcessingException {
        String prettyPrintEmployee = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
        System.out.println(prettyPrintEmployee);

        return rootNode;
    }
}
