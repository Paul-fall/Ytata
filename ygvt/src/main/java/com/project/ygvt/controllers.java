package com.project.ygvt;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/project")
public class controllers {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private Map<String, String> notes = new TreeMap<>();
    //GET запрос
    @GetMapping
    public List<String> list() {
        return notes
                .entrySet()
                .stream()
                .map(entry -> String.format("%s - %s", entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public String read(@PathVariable String id) {
        if (!notes.containsKey(id)) {
            return ("Not");
        }
        return notes.get(id);
    }
    
    //пример GET запроса
    @GetMapping("/teset")
    public Tabel1 gettone(@RequestParam(value = "name", defaultValue = "Test") String name)
    {
        System.out.print(name);
        return new Tabel1(counter.incrementAndGet(), String.format(template, name));
    }
    //пример POST запроса
    @RequestMapping(value = "/tepost")
    @ResponseStatus(HttpStatus.OK)
    public String postttwo(
            @RequestParam(value = "name", defaultValue = "Test", required=false) String id,
            @RequestParam(value = "note", defaultValue = "Test", required=false) String note)
    {
        System.out.print(id +" "+note);
        notes.put(id,note);
        return (id+ " "+ note);
    }
}
