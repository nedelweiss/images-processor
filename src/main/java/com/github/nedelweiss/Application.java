package com.github.nedelweiss;

import com.github.nedelweiss.image.ImageController;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

public class Application {

    private static final int JAVALIN_PORT = 7072;

    public static void main(String[] args) {
        ImageController imageController = new ImageController();

        JavalinJte.init();
        Javalin application = Javalin.create().start(JAVALIN_PORT);

        application.get("/", imageController.uploadPage());
        application.post("/upload", imageController.upload());
    }
}