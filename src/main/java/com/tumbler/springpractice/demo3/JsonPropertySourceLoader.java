package com.tumbler.springpractice.demo3;

import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.*;

/**
 * 1. 编写JsonPropertySourceLoader实现PropertySourceLoader接口
 * 2. 在resouces下创建META-INF并编写spring.factories类加载
 * 3. 在resouces创建appliaction.json进行测试（application的文件命名是ConfigFileApplicationListener定义好了的）
 * 扩展：ConfigFileApplicationListener类在SpringBoot 2.6.0后被移除，使用了全新的加载机制，具体细节可另外了解
 * @author gengweiweng
 * @time 2021/12/1
 * @desc 自定义实现加载json配置文件
 */
public class JsonPropertySourceLoader implements PropertySourceLoader {
    @Override
    public String[] getFileExtensions() {
        return new String[]{"json"};
    }

    @Override
    public List<PropertySource<?>> load(String name, Resource resource) throws IOException {
        List<PropertySource<?>> result = new ArrayList<>();
        Map<String, Object> map = mapPropertySource(resource);
        PropertySource source = new MapPropertySource(name, map);
        result.add(source);
        return result;
    }


    private Map<String , Object> mapPropertySource(Resource resource) throws IOException{
        if(resource == null){
            return null;
        }
        HashMap<String, Object> result = new HashMap<>();
        JsonParser parser = JsonParserFactory.getJsonParser();
        Map<String, Object> map = parser.parseMap(readFile(resource));
        nestMap("",result, map);
        return result;
    }

    private String readFile(Resource resource) throws IOException{
        BufferedInputStream in = (BufferedInputStream) resource.getInputStream();
        List<Byte> bytes = new LinkedList<>();
        byte[] readByte = new byte[1024];
        int length ;
        while ((length = in.read(readByte)) != -1){
            for (int i=0; i<length ; i++){
                bytes.add(readByte[i]);
            }
        }

        byte[] allBytes = new byte[bytes.size()];
        int index = 0;
        for (Byte b:bytes){
            allBytes[index] = b;
            index += 1;
        }
        return new String(allBytes);
    }


    private void nestMap(String prefix, Map<String, Object> result, Map<String, Object> map) {
        if (prefix.length() > 0) {
            prefix += ".";
        }

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() instanceof Map) {
                nestMap(prefix + entry.getKey(), result, (Map<String, Object>) entry.getValue());
            }else {
                result.put(prefix + entry.getKey(), entry.getValue());
            }
        }
    }
}
