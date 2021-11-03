package com.ceiba.espacio.controlador;




import com.ceiba.ApplicationMock;
import com.ceiba.espacio.comando.ComandoEspacio;
import com.ceiba.espacio.servicio.testbuilder.ComandoEspacioTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorEspacio.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorEspacioTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Deberia crear un espacio")
    void deberiaCrearUnEspacio() throws Exception{
        // arrange
        ComandoEspacio espacio = new ComandoEspacioTestDataBuilder().build();
        // act - assert
        mockMvc.perform(post("/espacio")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(espacio)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 3}"));

    }

    @Test
    void deberiaFallarAlCrearUnEspacioConNombreRepetido() throws Exception{
        // arrange
        ComandoEspacio espacio = new ComandoEspacioTestDataBuilder().conNombre("A00").build();
        // act - assert
        mockMvc.perform(post("/espacio")
                 .contentType(MediaType.APPLICATION_JSON)
                 .content(objectMapper.writeValueAsString(espacio)))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("{'nombreExcepcion':'ExcepcionDuplicidad', 'mensaje': 'El espacio ya existe en el sistema'}"));

    }

    @Test
    @DisplayName("Deberia actualizar un espacio")
    void deberiaActualizarUnEspacio() throws Exception{
        // arrange
        Long id = 1L;
        ComandoEspacio espacio = new ComandoEspacioTestDataBuilder().build();
        // act - assert
        mockMvc.perform(put("/espacio/{id}",id)
                 .contentType(MediaType.APPLICATION_JSON)
                 .content(objectMapper.writeValueAsString(espacio)))
                 .andExpect(status().isOk());
    }
    @Test
    void deberiaFallarAlActualizarUnEspacioQueNoExiste() throws Exception{
        Long id = 23L;
        ComandoEspacio espacio = new ComandoEspacioTestDataBuilder().build();
        // act - assert
        mockMvc.perform(put("/espacio/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(espacio)))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("{'nombreExcepcion':'ExcepcionDuplicidad', 'mensaje': 'El espacio no existe en el sistema'}"));
    }



    @Test
    @DisplayName("Debe eliminar un espacio")
    void debeEliminarUnEspacio() throws Exception{
        // arrange
        Long id = 2L;
        // act - assert
        mockMvc.perform(delete("/espacio/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(get("/espacio")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

}
