/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JONATHAN
 */
@Entity
@Table(name = "LIBRO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l")
    , @NamedQuery(name = "Libro.findByLibIsbn", query = "SELECT l FROM Libro l WHERE l.libIsbn = :libIsbn")
    , @NamedQuery(name = "Libro.findByAuCodigo", query = "SELECT l FROM Libro l WHERE l.auCodigo = :auCodigo")
    , @NamedQuery(name = "Libro.findByLibTitulo", query = "SELECT l FROM Libro l WHERE l.libTitulo = :libTitulo")
    , @NamedQuery(name = "Libro.findByLibValorPrestamo", query = "SELECT l FROM Libro l WHERE l.libValorPrestamo = :libValorPrestamo")})
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "LIB_ISBN")
    private String libIsbn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "AU_CODIGO")
    private String auCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "LIB_TITULO")
    private String libTitulo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "LIB_VALOR_PRESTAMO")
    private BigDecimal libValorPrestamo;

    public Libro() {
    }

    public Libro(String libIsbn) {
        this.libIsbn = libIsbn;
    }

    public Libro(String libIsbn, String auCodigo, String libTitulo, BigDecimal libValorPrestamo) {
        this.libIsbn = libIsbn;
        this.auCodigo = auCodigo;
        this.libTitulo = libTitulo;
        this.libValorPrestamo = libValorPrestamo;
    }

    public String getLibIsbn() {
        return libIsbn;
    }

    public void setLibIsbn(String libIsbn) {
        this.libIsbn = libIsbn;
    }

    public String getAuCodigo() {
        return auCodigo;
    }

    public void setAuCodigo(String auCodigo) {
        this.auCodigo = auCodigo;
    }

    public String getLibTitulo() {
        return libTitulo;
    }

    public void setLibTitulo(String libTitulo) {
        this.libTitulo = libTitulo;
    }

    public BigDecimal getLibValorPrestamo() {
        return libValorPrestamo;
    }

    public void setLibValorPrestamo(BigDecimal libValorPrestamo) {
        this.libValorPrestamo = libValorPrestamo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (libIsbn != null ? libIsbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.libIsbn == null && other.libIsbn != null) || (this.libIsbn != null && !this.libIsbn.equals(other.libIsbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Biblioteca.Libro[ libIsbn=" + libIsbn + " ]";
    }
    
}
