package com.kbe.warehouse.controllerTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(ControllerTester.class)
public class ControllerTester {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private static FruitService fruitService;

    /*@Test
    public void getAllFruits() throws Exception {
        Player player1 = new Player("Strawberry", 3.0, 10, true);
        Player player2 = new Player("Cherry", 2.4, 19, false);

        List<Player> playerList = new ArrayList<Player>() {
            {
                add(player1);
                add(player2);
            }
        };
        when(fruitService.getAllFruits()).thenReturn(playerList);
        mockMvc.perform(get("/fruits").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }*/
}
