// 📁 src/main/java/com/dto/ProjetoDTO/dto/UsuarioResponseDTO.java
package com.dto.ProjetoDTO.dto;

import com.dto.ProjetoDTO.model.Usuario;

public class UsuarioResponseDTO {
    private Long id;
    private String nome;
    private String email;
    // ❌ NÃO tem senha (saída)

    public UsuarioResponseDTO() {}

    // Construtor que copia de uma entidade (SEM copiar a senha)
    public UsuarioResponseDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        // senha? não existe campo aqui
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}