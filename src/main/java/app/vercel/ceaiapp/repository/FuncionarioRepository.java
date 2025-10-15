package app.vercel.ceaiapp.repository;

import app.vercel.ceaiapp.entity.Funcionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>/*, JpaSpecificationExecutor<Funcionario> */ {

    public Page<Funcionario> findByPessoaNomeContainingIgnoreCase(String nome, Pageable pageable);
}
