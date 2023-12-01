package org.example;

public class Resposta {

    private String json;

    public Resposta(String json) {
        this.json = json;
    }

    @Override
    public String toString() {
        return "Resposta{" +
                "json='" + json + '\'' +
                '}';
    }
}
