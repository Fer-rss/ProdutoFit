
package persistencia;

import jakarta.persistence.*;

/**
 *
 * @author ferna
 */
@Entity
@Table(name = "fornecedor")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_fornecedor", nullable = false, length = 100)
    private String nomeFornecedor;

    @Column(name = "cnpj", nullable = false, unique = true, length = 20)
    private String cnpj;

    @Column(name = "prazo_entrega", length = 50)
    private String prazoEntrega;

    // Construtor
    public Fornecedor() {}

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getPrazoEntrega() {
        return prazoEntrega;
    }

    public void setPrazoEntrega(String prazoEntrega) {
        this.prazoEntrega = prazoEntrega;
    }

    @Override
    public String toString() {
        return "Fornecedor: " + nomeFornecedor + " | CNPJ: " + cnpj;
    }
}
