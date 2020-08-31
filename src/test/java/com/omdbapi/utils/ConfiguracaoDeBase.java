package com.omdbapi.utils;

public class ConfiguracaoDeBase extends BaseDeConfiguracao {

    public String getApiKey() {
        configuracaoDeLeituraProperties();
        return propriedade.getProperty("API_KEY");
    }

    public String getIdDoFilme() {
        configuracaoDeLeituraProperties();
        return propriedade.getProperty("ID_DO_FILME");
    }

    public String getIdDoFilmeNaoEncontrado() {
        configuracaoDeLeituraProperties();
        return propriedade.getProperty("ID_DO_FILME_NAO_ENCONTRADO");
    }

    public String getCorpoFilmeEncontrado() {
        configuracaoDeLeituraProperties();
        return propriedade.getProperty("CorpoFilmeEncontrado");
    }

    public String getCorpoFilmeNaoEncontrado() {
        configuracaoDeLeituraProperties();
        return propriedade.getProperty("CorpoFilmeNaoEncontrado");
    }
}