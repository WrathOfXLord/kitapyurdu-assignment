package com.testinium.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.testinium.pages.FavouritesPage;

public class FavouritesPageTest extends LoginPageTest {
    static FavouritesPage favouritesPage;
    static String id;
    @BeforeAll
    public static void initializeFavouritesPage() {
        favouritesPage = new FavouritesPage();
        try {
            id = new String(Files.readAllBytes(Paths.get("./id.txt")));
            logger.info("Id read from id.txt. Id: " + id);
        } catch (IOException e) {
            logger.error("Failed reading id from the file !");
        }
    }

    @Test
    public void favouritesPageTest() {
        favouritesPage.navigateToFavorites();
        favouritesPage.removeFromFavorites(id);
    }


}
