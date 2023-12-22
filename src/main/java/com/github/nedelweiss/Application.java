package com.github.nedelweiss;

import com.github.nedelweiss.image.ImageController;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Application {

    private static final int JAVALIN_PORT = 7072;

    public static void main(String[] args) {
        ImageController imageController = new ImageController();

        Javalin application = Javalin.create(config -> config.staticFiles.add("/image", Location.CLASSPATH))
            .start(JAVALIN_PORT);

        application.post("/upload", imageController.upload());
    }
}