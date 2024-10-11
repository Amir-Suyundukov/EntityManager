package ru.suyundukov.MyProject.entityTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreatePerson() throws Exception {
        String json = "{ \"name\": \"Qwe\"," +
                " \"surName\": \"qas\"," +
                " \"patronymic\": \"fd\"," +
                " \"centralBank\": \"bank\"," +
                " \"snils\": \"123\" }";

        mockMvc.perform(post("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated()) // Проверка статуса ответа
                .andExpect(jsonPath("$.name").value("Qwe")) // Проверка имени в ответе
                .andExpect(jsonPath("$.surName").value("qas")) // Проверка фамилии в ответе
                .andExpect(jsonPath("$.patronymic").value("fd")) // Проверка отчества в ответе
                .andExpect(jsonPath("$.centralBank").value("bank")) // Проверка банка в ответе
                .andExpect(jsonPath("$.snils").value("123")); // Проверка СНИЛСа в ответе
    }

    @Test
    public void testGetPerson() throws Exception {
        // Создаем персонажа перед его получением
        String json = "{ \"name\": \"Qwe\"," +
                " \"surName\": \"qas\"," +
                " \"patronymic\": \"fd\"," +
                " \"centralBank\": \"bank\"," +
                " \"snils\": \"123\" }";

        mockMvc.perform(post("/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));
        mockMvc.perform(get("/person/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Qwe")) // Проверка имени в ответе
                .andExpect(jsonPath("$.surName").value("qas")) // Проверка фамилии в ответе
                .andExpect(jsonPath("$.patronymic").value("fd")) // Проверка отчества в ответе
                .andExpect(jsonPath("$.centralBank").value("bank")) // Проверка банка в ответе
                .andExpect(jsonPath("$.snils").value("123")); // Проверка СНИЛСа в ответе
    }

    @Test
    public void testUpdatePerson() throws Exception {
        // Создаем персонажа перед обновлением
        String json = "{ \"name\": \"Qwe\"," +
                " \"surName\": \"qas\"," +
                " \"patronymic\": \"fd\"," +
                " \"centralBank\": \"bank\"," +
                " \"snils\": \"123\" }";

        mockMvc.perform(post("/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));
        String updatedJson = "{ \"name\": \"NewName\"," +
                " \"surName\": \"NewSurName\"," +
                " \"patronymic\": \"NewPatronymic\"," +
                " \"centralBank\": \"NewBank\"," +
                " \"snils\": \"456\" }";

        mockMvc.perform(put("/person/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedJson))
                .andExpect(status().isOk());

        // Проверяем обновление
        mockMvc.perform(get("/person/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("NewName"))
                .andExpect(jsonPath("$.surName").value("NewSurName"))
                .andExpect(jsonPath("$.patronymic").value("NewPatronymic"))
                .andExpect(jsonPath("$.centralBank").value("NewBank"))
                .andExpect(jsonPath("$.snils").value("456"));
    }

    @Test
    public void testDeletePerson() throws Exception {
        // Создаем персонажа перед удалением
        String json = "{ \"name\": \"Qwe\"," +
                " \"surName\": \"qas\"," +
                " \"patronymic\": \"fd\"," +
                " \"centralBank\": \"bank\"," +
                " \"snils\": \"123\" }";

        mockMvc.perform(post("/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));

        // Удаляем персонажа
        mockMvc.perform(delete("/person/1"))
                .andExpect(status().isNoContent());

        // Проверяем, что персонаж удален
        mockMvc.perform(get("/person/1"))
                .andExpect(status().isNotFound());
    }
}
