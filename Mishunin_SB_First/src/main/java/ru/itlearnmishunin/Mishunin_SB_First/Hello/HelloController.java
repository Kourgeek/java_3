package ru.itlearnmishunin.Mishunin_SB_First.Hello;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class HelloController {

    private final List<String> strings = new ArrayList<>();
    private final HashMap<Integer,String> hashmap = new HashMap<>();

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name)
    {
     return String.format("Hello, %s!", name);
    }
    @GetMapping("/update-array")
    public String UpdateArray(@RequestParam(value = "param") String param)
    {
        strings.add(param);
        return "Array successfully updated";
    }
    @GetMapping("/show-array")
    public String ShowArray()
    {
        return strings.toString();
    }

    @GetMapping("/update-hashmap")
    public String UpdateHashmap(@RequestParam(value = "value") String value)
    {
        Integer key = hashmap.size();
        hashmap.put(key+1,value);
        return "Hashmap successfully updated";
    }
    @GetMapping("/show-hashmap")
    public String ShowHashmap()
    {
        return hashmap.toString();
    }

    @GetMapping("show-length")
    public String ShowLength()
    {
        return String.format("Array length is: %d, \n Hashmap length is: %d",strings.size(),hashmap.size());
    }


}
