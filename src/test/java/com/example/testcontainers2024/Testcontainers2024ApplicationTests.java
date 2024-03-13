package com.example.testcontainers2024;

import com.example.testcontainers2024.services.CompanyService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;

@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
//@TestConfiguration(proxyBeanMethods = false)
//@WebMvcTest
class Testcontainers2024ApplicationTests {

    @Autowired
    private MockMvc mockMvc;
//
//    @MockBean
//    private SubscriberService subscriberService;
//
//    @MockBean
//    private SubscribeService subscribeService;

    @Autowired
    private CompanyService companyService;

    @Container
    public static DockerComposeContainer<?> container = new DockerComposeContainer<>(new File("docker/docker-compose.yaml")).withLocalCompose(true);
    //.waitingFor("postgres",Wait.forLogMessage(".*database system is ready to accept connections.*\\s", 2));

    @BeforeAll
    static void setUp() {
        container.start();
    }

    @AfterAll
    static void finishMethod() {
        container.stop();
    }

    @Test
    void contextLoads() {
    }

    @Test
    void checkSubscribesPost() throws Exception {

        String jsonSubsribes = "[\n" + "    {\n" + "        \"name\": \"subscription1\",\n" + "        \"description\": \"description1\"\n" + "    },\n" + "    {\n" + "        \"name\": \"subscription2\",\n" + "        \"description\": \"description2\"\n" + "    },\n" + "    {\n" + "        \"name\": \"subscription3\",\n" + "        \"description\": \"description3\"\n" + "    }\n" + "]";

        // Отправляем POST запрос с JSON сообщением
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/subscribes").contentType(MediaType.APPLICATION_JSON).content(jsonSubsribes)).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        // Получаем ответ
        result = mockMvc.perform(MockMvcRequestBuilders.get("/subscribes")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        String resp = result.getResponse().getContentAsString();
        JsonElement element = JsonParser.parseString(resp);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonFormatted = gson.toJson(element);
        System.out.println("Debug!!! ==> " + jsonFormatted);
    }


}

