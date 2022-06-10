package com.example.demo.command;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommandServiceImpl implements CommandService {

    @Autowired
    private CommandRepository commandRepository;

    @Override
    public List<command> getAllCommands() {
        return commandRepository.findAll();
    }

    @Override
    public void saveCommand(command command) {
        this.commandRepository.save(command);
        
    }

    @Override
    public command getCommandById(long id) {
        Optional<command> optionalCommand = commandRepository.findById(id);
        command command = null;
        if(optionalCommand.isPresent()) {
            command = optionalCommand.get();
        }
        else{
            throw new RuntimeException("Command not found for id: " + id);
        }
        return command;
    }

    @Override
    public void deleteCommandById(long id) {
        this.commandRepository.deleteById(id);
    }

    
    
}
