package com.Codeclan.example.JavaSpringOnetoManyHomework.components;

import com.Codeclan.example.JavaSpringOnetoManyHomework.models.File;
import com.Codeclan.example.JavaSpringOnetoManyHomework.models.Folder;
import com.Codeclan.example.JavaSpringOnetoManyHomework.models.User;
import com.Codeclan.example.JavaSpringOnetoManyHomework.repositories.FileRepository;
import com.Codeclan.example.JavaSpringOnetoManyHomework.repositories.FolderRepository;
import com.Codeclan.example.JavaSpringOnetoManyHomework.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FolderRepository folderRepository;

    @Autowired
    private FileRepository fileRepository;

    @Override
    public void run(ApplicationArguments args){
        User jeb = new User("Jeb");
        userRepository.save(jeb);

        User val = new User("Val");
        userRepository.save(val);


        Folder engines = new Folder("engines", jeb);
        folderRepository.save(engines);

        Folder fueltanks = new Folder("fueltanks", val);
        folderRepository.save(fueltanks);

        Folder parachutes = new Folder("parachutes", jeb);
        folderRepository.save(parachutes);


        File nerva = new File("Nerva", ".nuc", 3, engines);
        fileRepository.save(nerva);

        File booster = new File("Booster", "..moar", 10, engines);
        fileRepository.save(booster);

        File bigorange = new File("BigOrange", ".gas", 64, fueltanks);
        fileRepository.save(bigorange);

        File moose = new File("Moose", ".dumb", 2, parachutes);
        fileRepository.save(moose);

        jeb.addFolder(engines);
        jeb.addFolder(parachutes);
        val.addFolder(fueltanks);
        userRepository.save(jeb);
        userRepository.save(val);

        engines.addFile(nerva);
        engines.addFile(booster);
        fueltanks.addFile(bigorange);
        parachutes.addFile(moose);
        folderRepository.save(engines);
        folderRepository.save(fueltanks);
        folderRepository.save(parachutes);
    }

}
