package bean;
// Generated 15/11/2023 21:32:57 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ClienteGvo generated by hbm2java
 */
@Entity
@Table(name="cliente_gvo"
    ,catalog="guilherme_osterberg2"
)
public class ClienteGvo  implements java.io.Serializable {


     private int idClienteGvo;
     private UsuariosGvo usuariosGvo;
     private String nomeGvo;
     private String sobreNomeGvo;
     private String cpfGvo;
     private String enderecoGvo;
     private String paisGvo;
     private String bairroGvo;
     private String cidadeGvo;
     private String telefoneGvo;
     private String celularGvo;
     private String descontoGvo;
     private Set comprasGvos = new HashSet(0);

    public ClienteGvo() {
    }

	
    public ClienteGvo(int idClienteGvo, UsuariosGvo usuariosGvo, String nomeGvo, String sobreNomeGvo, String cpfGvo, String enderecoGvo, String paisGvo, String bairroGvo, String cidadeGvo, String telefoneGvo, String celularGvo, String descontoGvo) {
        this.idClienteGvo = idClienteGvo;
        this.usuariosGvo = usuariosGvo;
        this.nomeGvo = nomeGvo;
        this.sobreNomeGvo = sobreNomeGvo;
        this.cpfGvo = cpfGvo;
        this.enderecoGvo = enderecoGvo;
        this.paisGvo = paisGvo;
        this.bairroGvo = bairroGvo;
        this.cidadeGvo = cidadeGvo;
        this.telefoneGvo = telefoneGvo;
        this.celularGvo = celularGvo;
        this.descontoGvo = descontoGvo;
    }
    public ClienteGvo(int idClienteGvo, UsuariosGvo usuariosGvo, String nomeGvo, String sobreNomeGvo, String cpfGvo, String enderecoGvo, String paisGvo, String bairroGvo, String cidadeGvo, String telefoneGvo, String celularGvo, String descontoGvo, Set comprasGvos) {
       this.idClienteGvo = idClienteGvo;
       this.usuariosGvo = usuariosGvo;
       this.nomeGvo = nomeGvo;
       this.sobreNomeGvo = sobreNomeGvo;
       this.cpfGvo = cpfGvo;
       this.enderecoGvo = enderecoGvo;
       this.paisGvo = paisGvo;
       this.bairroGvo = bairroGvo;
       this.cidadeGvo = cidadeGvo;
       this.telefoneGvo = telefoneGvo;
       this.celularGvo = celularGvo;
       this.descontoGvo = descontoGvo;
       this.comprasGvos = comprasGvos;
    }
   
     @Id 

    
    @Column(name="IdCliente_gvo", unique=true, nullable=false)
    public int getIdClienteGvo() {
        return this.idClienteGvo;
    }
    
    public void setIdClienteGvo(int idClienteGvo) {
        this.idClienteGvo = idClienteGvo;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_Usuarios_gvo", nullable=false)
    public UsuariosGvo getUsuariosGvo() {
        return this.usuariosGvo;
    }
    
    public void setUsuariosGvo(UsuariosGvo usuariosGvo) {
        this.usuariosGvo = usuariosGvo;
    }

    
    @Column(name="nome_gvo", nullable=false, length=50)
    public String getNomeGvo() {
        return this.nomeGvo;
    }
    
    public void setNomeGvo(String nomeGvo) {
        this.nomeGvo = nomeGvo;
    }

    
    @Column(name="sobreNome_gvo", nullable=false, length=50)
    public String getSobreNomeGvo() {
        return this.sobreNomeGvo;
    }
    
    public void setSobreNomeGvo(String sobreNomeGvo) {
        this.sobreNomeGvo = sobreNomeGvo;
    }

    
    @Column(name="cpf_gvo", nullable=false, length=14)
    public String getCpfGvo() {
        return this.cpfGvo;
    }
    
    public void setCpfGvo(String cpfGvo) {
        this.cpfGvo = cpfGvo;
    }

    
    @Column(name="endereco_gvo", nullable=false, length=60)
    public String getEnderecoGvo() {
        return this.enderecoGvo;
    }
    
    public void setEnderecoGvo(String enderecoGvo) {
        this.enderecoGvo = enderecoGvo;
    }

    
    @Column(name="pais_gvo", nullable=false, length=60)
    public String getPaisGvo() {
        return this.paisGvo;
    }
    
    public void setPaisGvo(String paisGvo) {
        this.paisGvo = paisGvo;
    }

    
    @Column(name="bairro_gvo", nullable=false, length=60)
    public String getBairroGvo() {
        return this.bairroGvo;
    }
    
    public void setBairroGvo(String bairroGvo) {
        this.bairroGvo = bairroGvo;
    }

    
    @Column(name="cidade_gvo", nullable=false, length=60)
    public String getCidadeGvo() {
        return this.cidadeGvo;
    }
    
    public void setCidadeGvo(String cidadeGvo) {
        this.cidadeGvo = cidadeGvo;
    }

    
    @Column(name="telefone_gvo", nullable=false, length=25)
    public String getTelefoneGvo() {
        return this.telefoneGvo;
    }
    
    public void setTelefoneGvo(String telefoneGvo) {
        this.telefoneGvo = telefoneGvo;
    }

    
    @Column(name="celular_gvo", nullable=false, length=25)
    public String getCelularGvo() {
        return this.celularGvo;
    }
    
    public void setCelularGvo(String celularGvo) {
        this.celularGvo = celularGvo;
    }

    
    @Column(name="desconto_gvo", nullable=false, length=25)
    public String getDescontoGvo() {
        return this.descontoGvo;
    }
    
    public void setDescontoGvo(String descontoGvo) {
        this.descontoGvo = descontoGvo;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="clienteGvo")
    public Set getComprasGvos() {
        return this.comprasGvos;
    }
    
    public void setComprasGvos(Set comprasGvos) {
        this.comprasGvos = comprasGvos;
    }




}


