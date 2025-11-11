package com.skillsync.ml;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Component
public class MLModelLoader {

    private String modelData;

    public void loadModel(String modelPath) throws IOException {
        File file = new File(modelPath);
        this.modelData = Files.readString(file.toPath());
        System.out.println("Modelo cargado correctamente desde: " + modelPath);
    }

    public String getModelData() {
        return modelData;
    }
}
