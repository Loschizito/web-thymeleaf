package com.portfolio.model;

import java.util.List;

public record Projeto(String titulo, String descricao, List<String> tecnologias, String link) {
}
