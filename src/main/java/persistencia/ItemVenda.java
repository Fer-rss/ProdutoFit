package persistencia;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "item_venda")
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_produto", nullable = false, length = 100)
    private String nomeProduto;

    @Column(nullable = false)
    private int quantidade;

    @Column(name = "preco_unitario", precision = 10, scale = 2, nullable = false)
    private BigDecimal precoUnitario;

    @ManyToOne
    @JoinColumn(name = "venda_id", nullable = false)
    private Venda venda;

    public ItemVenda() {}

    public ItemVenda(String nomeProduto, int quantidade, double precoUnitario) {
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.precoUnitario = BigDecimal.valueOf(precoUnitario);
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    // Calcula subtotal: quantidade * preço unitário
    public BigDecimal getSubtotal() {
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

    @Override
    public String toString() {
        return nomeProduto + " - " + quantidade + " x R$" + precoUnitario;
    }
}
