package app.vercel.ceaiapp.repository;

import app.vercel.ceaiapp.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    public List<Funcionario> findByPessoaNomeContainingIgnoreCase(String nome);
}
