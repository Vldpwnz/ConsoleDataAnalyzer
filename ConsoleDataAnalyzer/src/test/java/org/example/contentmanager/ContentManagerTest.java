package org.example.contentmanager;


import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ContentManagerTest{

    @Test
    public void testIfFileNotExists(){
        List<String> actualMessage = ContentManager.getContent("noFile");
        assertTrue(actualMessage == null);
    }

}