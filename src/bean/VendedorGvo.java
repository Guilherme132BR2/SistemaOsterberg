package bean;
// Generated 15/11/2023 21:32:57 by Hibernate Tools 4.3.1

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VendedorGvo generated by hbm2java
 */
@Entity
@Table(name = "vendedor_gvo",
         catalog = "guilherme_osterberg2"
)
public class VendedorGvo implements java.io.Serializable {

    private int idVendedorGvo;
    private UsuariosGvo usuariosGvo;
    private String nomeGvo;
    private String cpfGvo;
    private Date dataNascGvo;
    private String generoGvo;

    public VendedorGvo() {
    }

    public VendedorGvo(int idVendedorGvo, UsuariosGvo usuariosGvo, String nomeGvo, String cpfGvo, Date dataNascGvo, String generoGvo) {
        this.idVendedorGvo = idVendedorGvo;
        this.usuariosGvo = usuariosGvo;
        this.nomeGvo = nomeGvo;
        this.cpfGvo = cpfGvo;
        this.dataNascGvo = dataNascGvo;
        this.generoGvo = generoGvo;
    }

    public VendedorGvo(int idVendedorGvo, UsuariosGvo usuariosGvo, String nomeGvo, String cpfGvo, Date dataNascGvo, String generoGvo, Set comprasGvos) {
        this.idVendedorGvo = idVendedorGvo;
        this.usuariosGvo = usuariosGvo;
        this.nomeGvo = nomeGvo;
        this.cpfGvo = cpfGvo;
        this.dataNascGvo = dataNascGvo;
        this.generoGvo = generoGvo;
    }

    @Id

    @Column(name = "idVendedor_gvo", unique = true, nullable = false)
    public int getIdVendedorGvo() {
        return this.idVendedorGvo;
    }

    public void setIdVendedorGvo(int idvendedorGvo) {
        this.idVendedorGvo = idVendedorGvo;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_Usuarios_gvo", nullable = false)
    public UsuariosGvo getUsuariosGvo() {
        return this.usuariosGvo;
    }

    public void setUsuariosGvo(UsuariosGvo usuariosGvo) {
        this.usuariosGvo = usuariosGvo;
    }

    @Column(name = "nome_gvo", nullable = false, length = 50)
    public String getNomeGvo() {
        return this.nomeGvo;
    }

    public void setNomeGvo(String nomeGvo) {
        this.nomeGvo = nomeGvo;
    }

    @Column(name = "cpf_gvo", nullable = false, length = 14)
    public String getCpfGvo() {
        return this.cpfGvo;
    }

    public void setCpfGvo(String cpfGvo) {
        this.cpfGvo = cpfGvo;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "dataNasc_gvo", nullable = false, length = 10)
    public Date getDataNascGvo() {
        return this.dataNascGvo;
    }

    public void setDataNascGvo(Date dataNascGvo) {
        this.dataNascGvo = dataNascGvo;
    }

    @Column(name = "genero_gvo", nullable = false, length = 15)
    public String getGeneroGvo() {
        return this.generoGvo;
    }

    public void setGeneroGvo(String generoGvo) {
        this.generoGvo = generoGvo;
    }

}