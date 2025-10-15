package in.stark.sample1.sbdemo.Controller;


import in.stark.sample1.sbdemo.entity.LogEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/entries")
public class EntryController {

    private Map<Long, LogEntry> entries = new HashMap<>();

    @GetMapping("/all")
    public List<LogEntry> getAll(){
        return new ArrayList<>(entries.values());
    }

    @GetMapping("/get/{id}")
    public String getOne(@PathVariable long id){
        return entries.get(id).print();
    }

    @PostMapping("/insert")
    public void createEntry(@RequestBody LogEntry entry){
        entries.put(entry.getId(),entry);
    }

    @DeleteMapping("/remove/{id}")
    public boolean deleteEntry(@PathVariable long id){
        boolean flag = entries.containsKey(id);
        if(flag) {
            entries.remove(id);
        return true;
        }
    return false;
    }

    @PutMapping("/update")
    public boolean updateEntry(@RequestBody)
}
