package app.vercel.ceaiapp.repository;

import app.vercel.ceaiapp.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
