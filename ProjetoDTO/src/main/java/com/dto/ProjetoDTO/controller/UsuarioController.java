// 📁 src/main/java/com/dto/ProjetoDTO/controller/UsuarioController.java
package com.dto.ProjetoDTO.controller;

import com.dto.ProjetoDTO.dto.UsuarioRequestDTO;
import com.dto.ProjetoDTO.dto.UsuarioResponseDTO;
import com.dto.ProjetoDTO.model.Usuario;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    // Simulando um "banco de dados" em memória (só para o exemplo)
    private Usuario bancoFake;

    // ============================================================
    // 📥 POST /usuarios  →  CADASTRO (cliente MANDA senha)
    // ============================================================
    @PostMapping
    public UsuarioResponseDTO cadastrar(@RequestBody UsuarioRequestDTO request) {

        // 1. Recebe o DTO de entrada (que TEM senha)
        System.out.println("Senha recebida: " + request.getSenha());

        // 2. Converte DTO de entrada → Entidade
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());
        usuario.setSenha(criptografar(request.getSenha()));  // 👈 criptografa!

        // 3. Salva no banco (aqui é fake, na vida real é repository.save)
        bancoFake = usuario;
        System.out.println("Senha guardada (hash): " + usuario.getSenha());

        // 4. Converte Entidade → DTO de saída (SEM senha)
        return new UsuarioResponseDTO(usuario);
    }

    // ============================================================
    // 📤 GET /usuarios/1  →  CONSULTA (cliente NÃO recebe senha)
    // ============================================================
    @GetMapping("/{id}")
    public UsuarioResponseDTO buscar(@PathVariable Long id) {

        // 1. Pega a entidade do banco (COM senha)
        Usuario usuario = bancoFake;

        // 2. Converte Entidade → DTO de saída (SEM senha)
        return new UsuarioResponseDTO(usuario);
    }

    // Método fake de criptografia (na vida real: BCryptPasswordEncoder)
    private String criptografar(String senhaPura) {
        return "HASH_" + senhaPura;
    }
}