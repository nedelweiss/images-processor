package com.github.nedelweiss.image;

import io.javalin.http.Handler;
import io.javalin.http.UploadedFile;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ImageController {

    private final String directory;

    public ImageController() {
        try {
            this.directory = new File("./").getCanonicalPath() + "/temp/";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Handler upload() {
        return context -> {
            for (UploadedFile file : context.uploadedFiles("files")) {
                FileUtils.copyInputStreamToFile(file.content(), new File(directory + file.filename()));
            }
            context.json("Upload successful");
        };
    }
}
