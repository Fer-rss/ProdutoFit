
package persistencia;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 *
 * @author ferna
 */
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_produto", nullable = false, length = 100)
    private String nomeProduto;

    @Column(name = "fornecedor", length = 100)
    private String fornecedor;

    @Column(name = "categoria", length = 50)
    private String categoria;

    @Column(name = "observacao", length = 255)
    private String observacao;

    @Column(name = "preco", precision = 10, scale = 2, nullable = false)
    private BigDecimal preco;

    @Column(name = "qtdd_estoque", nullable = false)
    private int qtddEstoque;

    // Construtor
    public Produto() {}

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getQtddEstoque() {
        return qtddEstoque;
    }

    public void setQtddEstoque(int qtddEstoque) {
        this.qtddEstoque = qtddEstoque;
    }

    @Override
    public String toString() {
        return "Produto: " + nomeProduto + ", Preço: R$" + preco;
    }
}