package app.vercel.ceaiapp.repository;


import app.vercel.ceaiapp.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
