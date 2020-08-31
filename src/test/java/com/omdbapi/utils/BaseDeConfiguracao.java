package com.omdbapi.utils;

import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class BaseDeConfiguracao {
    static Properties propriedade;
    static JsonSchemaValidator json;

    public static void configuracaoDeLeituraProperties() {
        try {
            File solicitacaoDeArquivo = new File("src/configuracao/configuracao.property");
            FileInputStream entradaDeArquivo = new FileInputStream(solicitacaoDeArquivo);
            propriedade = new Properties();
            propriedade.load(entradaDeArquivo);
        } catch (Exception e) {
            System.out.println("Erro de excecao: " + e.getMessage());
        }
    }
}
